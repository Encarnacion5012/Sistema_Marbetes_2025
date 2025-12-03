package com.progmproyect.util.modelos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "renovaciones")
public class Renovacion {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "placa", referencedColumnName = "placa")
   private Vehiculo vehiculo;
    
   @ManyToOne
   @JoinColumn(name = "secuencia_marbete", referencedColumnName = "secuencia")
    private Marbete marbete;
    private int anio_fabricacion;
    private double costo;
    private String vendedor;
    private LocalDate fecha_renovacion;
       
    //Constructores
    public Renovacion() {
        
    }
    public Renovacion(int id, Vehiculo vehiculo, Marbete marbete, int anio_fabricacion, double costo, String vendedor, LocalDate fecha_renovacion) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.marbete = marbete;
        this.anio_fabricacion = anio_fabricacion;
        this.costo = costo;
        this.vendedor = vendedor;
        this.fecha_renovacion = fecha_renovacion;
    }
    //Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Marbete getMarbete() {
        return marbete;
    }
    public void setMarbete(Marbete marbete) {
        this.marbete = marbete;
    }
    public int getAnio_fabricacion() {
        return anio_fabricacion;
    }
    public void setAnio_fabricacion(int anio_fabricacion) {
        this.anio_fabricacion = anio_fabricacion;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public String getVendedor() {
        return vendedor;
    }
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    public LocalDate getFecha_renovacion() {
        return fecha_renovacion;
    }
    public void setFecha_renovacion(LocalDate fecha_renovacion) {
        this.fecha_renovacion = fecha_renovacion;
    }

    //toString
    @Override
    public String toString() {
        return "Renovacion{" +
                "id=" + id +
                ", vehiculo=" + vehiculo +
                ", marbete=" + marbete +
                ", anio_fabricacion=" + anio_fabricacion +
                ", costo=" + costo +
                ", vendedor='" + vendedor + '\'' +
                ", fecha_renovacion=" + fecha_renovacion +
                '}';
    }
}
