package com.progmproyect.controller;

import java.io.IOException;
import java.lang.module.Configuration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.progmproyect.util.daos.ConfiguracionDao;
import com.progmproyect.util.daos.MarbeteDao;
import com.progmproyect.util.daos.RenovacionDao;
import com.progmproyect.util.daos.VehiculoDao;
import com.progmproyect.util.modelos.Configuracion;
import com.progmproyect.util.modelos.Marbete;
import com.progmproyect.util.modelos.Renovacion;
import com.progmproyect.util.modelos.Vehiculo;

@WebServlet("/RenovacionServlet")
public class RenovacionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        VehiculoDao vehiculoDao = new VehiculoDao();
        ConfiguracionDao confiDao = new ConfiguracionDao();
        MarbeteDao marbeteDao = new MarbeteDao();
        RenovacionDao renovacionDao = new RenovacionDao();

        if ("buscar".equals(accion)) {
            // 1. Lógica para BUSCAR placa
            String placa = request.getParameter("placa");
            Vehiculo vehiculo = vehiculoDao.buscarPorPlaca(placa);
            Configuracion config = confiDao.obtenerConfiguracionActual();
            
            String mensaje = null;
            double costo = 0;

            if (vehiculo == null) {
                mensaje = "Vehículo no encontrado.";
            } else if (vehiculo.isRenovado()) {
                mensaje = "Este vehículo ya tiene su marbete renovado.";
            } else {
                // Calcular costo según reglas de negocio
                if (vehiculo.getAnio_fabricacion() >= config.getAnio_fabricacion_inicia_alto()) {
                    costo = config.getCosto_alto();
                } else {
                    costo = config.getCosto_bajo();
                }
                request.setAttribute("vehiculoEncontrado", vehiculo);
                request.setAttribute("costoCalculado", costo);
            }
            
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if ("procesar".equals(accion)) {
            // 2. Lógica para VENDER (Procesar renovación)
            String placa = request.getParameter("placaConfirmada");
            // Obtener el usuario de la sesión
            String vendedor = (String) request.getSession().getAttribute("usuarioLogueado");
            if (vendedor == null || vendedor.isEmpty()) {
                vendedor = "Usuario Desconocido"; // Por si entran directo sin login
            } // Podrías sacarlo de un input si quieres
                        
            Vehiculo vehiculo = vehiculoDao.buscarPorPlaca(placa);
            Configuracion config = confiDao.obtenerConfiguracionActual();
            Marbete marbete = marbeteDao.obtenerSiguenteMarbeteDisponible();

            if (marbete == null) {
                request.setAttribute("mensaje", "Error: No hay marbetes disponibles en el inventario.");
            } else {
                // Re-calcular costo por seguridad (no confiar solo en el input hidden)
                double costoFinal = (vehiculo.getAnio_fabricacion() >= config.getAnio_fabricacion_inicia_alto()) 
                                    ? config.getCosto_alto() : config.getCosto_bajo();

                // Crear objeto Renovacion
                Renovacion renovacion = new Renovacion();
                renovacion.setVehiculo(vehiculo);
                renovacion.setMarbete(marbete);
                renovacion.setAnio_fabricacion(vehiculo.getAnio_fabricacion());
                renovacion.setCosto(costoFinal);
                renovacion.setVendedor(vendedor);
                renovacion.setFecha_renovacion(LocalDate.now());

                // Guardar Transacción
                renovacionDao.guardarRenovacion(renovacion);

                // Actualizar Marbete y Vehículo
                marbete.setVendido(true);
                marbeteDao.actualizar(marbete);

                vehiculo.setRenovado(true);
                vehiculoDao.actualizar(vehiculo);

                request.setAttribute("mensajeExito", "¡Renovación exitosa! Marbete asignado: " + marbete.getSecuencia());
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
