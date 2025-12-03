package com.progmproyect.util.modelos;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reporte_ventas") // Mapea a la vista SQL
public class ReporteVenta {
    
    @Id
    @Column(name = "dia_venta")
    private LocalDate diaVenta;
    
    @Column(name = "conteo_bajo")
    private long conteoBajo; // count devuelve long en JPA
    
    @Column(name = "conteo_alto")
    private long conteoAlto;
    
    @Column(name = "costo_total")
    private double costoTotal;

    public ReporteVenta() {}

    // Getters y Setters
    public LocalDate getDiaVenta() { return diaVenta; }
    public void setDiaVenta(LocalDate diaVenta) { this.diaVenta = diaVenta; }

    public long getConteoBajo() { return conteoBajo; }
    public void setConteoBajo(long conteoBajo) { this.conteoBajo = conteoBajo; }

    public long getConteoAlto() { return conteoAlto; }
    public void setConteoAlto(long conteoAlto) { this.conteoAlto = conteoAlto; }

    public double getCostoTotal() { return costoTotal; }
    public void setCostoTotal(double costoTotal) { this.costoTotal = costoTotal; }
}
