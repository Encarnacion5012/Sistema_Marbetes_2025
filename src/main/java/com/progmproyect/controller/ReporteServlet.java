package com.progmproyect.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.progmproyect.util.daos.RenovacionDao; // Usamos este DAO ahora
import com.progmproyect.util.modelos.Renovacion; // Y este Modelo

@WebServlet("/ReporteServlet")
public class ReporteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fechaInicioStr = request.getParameter("fechaInicio");
        String fechaFinStr = request.getParameter("fechaFin");
        
        if (fechaInicioStr != null && !fechaInicioStr.isEmpty() && fechaFinStr != null && !fechaFinStr.isEmpty()) {
            try {
                LocalDate inicio = LocalDate.parse(fechaInicioStr);
                LocalDate fin = LocalDate.parse(fechaFinStr);
                
                // Usamos RenovacionDao para traer el detalle completo
                RenovacionDao dao = new RenovacionDao();
                List<Renovacion> lista = dao.listarPorFechas(inicio, fin);
                
                request.setAttribute("listaVentas", lista); // Ojo al nombre del atributo
                
            } catch (Exception e) {
                request.setAttribute("mensajeError", "Error en fechas.");
                e.printStackTrace();
            }
        }
        request.getRequestDispatcher("reporte.jsp").forward(request, response);
    }
    
    // Para que cargue la página si entras directo
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("reporte.jsp").forward(request, response);
    }
}