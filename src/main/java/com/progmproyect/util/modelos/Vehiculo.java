package com.progmproyect.util.modelos;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    
    @Id
    private String placa;
    @Basic
    private String marca;
    private String modelo;
    private int anio_fabricacion;
    private String identificacion_propietario;
    private boolean renovado;
    
    //Constructores
    public Vehiculo() {
        
    }
    public Vehiculo(String placa, String marca, String modelo, int anio_fabricacion, String identificacion_propietario, boolean renovado) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio_fabricacion = anio_fabricacion;
        this.identificacion_propietario = identificacion_propietario;
        this.renovado = renovado;
    }
    //Getters y Setters
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getMarca() {
        return marca;
    }   
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAnio_fabricacion() {
        return anio_fabricacion;
    }
    public void setAnio_fabricacion(int anio_fabricacion) {
        this.anio_fabricacion = anio_fabricacion;
    }
    public String getIdentificacion_propietario() {
        return identificacion_propietario;
    }

    public void setIdentificacion_propietario(String identificacion_propietario) {
        this.identificacion_propietario = identificacion_propietario;
    }
    public boolean isRenovado() {
        return renovado;
    }
    public void setRenovado(boolean renovado) {
        this.renovado = renovado;
    }

    //toString
    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio_fabricacion=" + anio_fabricacion +
                ", identificacion_propietario='" + identificacion_propietario + '\'' +
                ", renovado=" + renovado +
                '}';
    }

}