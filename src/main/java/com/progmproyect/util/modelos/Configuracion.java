package com.progmproyect.util.modelos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configuraciones")
public class Configuracion {
    @Id
    private int id;
    private double costo_bajo;
    private double costo_alto;
    private int anio_fabricacion_inicia_alto;
    private LocalDate fecha_inicio_renovacion;
    private LocalDate fecha_fin_renovacion;

    //Constructores
    public Configuracion() {
        
    }
    public Configuracion(int id, double costo_bajo, double costo_alto, int anio_fabricacion_inicia_alto, LocalDate fecha_inicio_renovacion, LocalDate fecha_fin_renovacion) {
        this.id = id;
        this.costo_bajo = costo_bajo;
        this.costo_alto = costo_alto;
        this.anio_fabricacion_inicia_alto = anio_fabricacion_inicia_alto;
        this.fecha_inicio_renovacion = fecha_inicio_renovacion;
        this.fecha_fin_renovacion = fecha_fin_renovacion;
    }
    //Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getCosto_bajo() {
        return costo_bajo;
    }
    public void setCosto_bajo(double costo_bajo) {
        this.costo_bajo = costo_bajo;
    }
    public double getCosto_alto() {
        return costo_alto;
    }
    public void setCosto_alto(double costo_alto) {
        this.costo_alto = costo_alto;
    }
    public int getAnio_fabricacion_inicia_alto() {
        return anio_fabricacion_inicia_alto;
    }
    public void setAnio_fabricacion_inicia_alto(int anio_fabricacion_inicia_alto) {
        this.anio_fabricacion_inicia_alto = anio_fabricacion_inicia_alto;
    }
    public LocalDate getFecha_inicio_renovacion() {
        return fecha_inicio_renovacion;
    }
    public void setFecha_inicio_renovacion(LocalDate fecha_inicio_renovacion) {
        this.fecha_inicio_renovacion = fecha_inicio_renovacion;
    }
    public LocalDate getFecha_fin_renovacion() {
        return fecha_fin_renovacion;
    }
    public void setFecha_fin_renovacion(LocalDate fecha_fin_renovacion) {
        this.fecha_fin_renovacion = fecha_fin_renovacion;
    }
    //toString
    @Override
    public String toString() {
        return "Configuracion{" +
                "id=" + id +
                ", costo_bajo=" + costo_bajo +
                ", costo_alto=" + costo_alto +
                ", anio_fabricacion_inicia_alto=" + anio_fabricacion_inicia_alto +
                ", fecha_inicio_renovacion=" + fecha_inicio_renovacion +
                ", fecha_fin_renovacion=" + fecha_fin_renovacion +
                '}';          
}
}