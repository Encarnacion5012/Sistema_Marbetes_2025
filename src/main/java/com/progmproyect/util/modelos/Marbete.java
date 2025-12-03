package com.progmproyect.util.modelos;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marbetes")
public class Marbete {
   
   @Id
    private int secuencia;
    @Basic
    private int anio_inicio_renovacion;
    private int anio_fin_renovacion;
    private boolean vendido;

    //Constructores
    public Marbete() {
        
    }
    public Marbete(int secuencia, int anio_inicio_renovacion, int anio_fin_renovacion, boolean vendido) {
        this.secuencia = secuencia;
        this.anio_inicio_renovacion = anio_inicio_renovacion;
        this.anio_fin_renovacion = anio_fin_renovacion;
        this.vendido = vendido;
    }
    //Getters y Setters
    public int getSecuencia() {
        return secuencia;
    }
    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }
    public int getAnio_inicio_renovacion() {
        return anio_inicio_renovacion;
    }
    public void setAnio_inicio_renovacion(int anio_inicio_renovacion) {
        this.anio_inicio_renovacion = anio_inicio_renovacion;
    }
    public int getAnio_fin_renovacion() {
        return anio_fin_renovacion;
    }
    public void setAnio_fin_renovacion(int anio_fin_renovacion) {
        this.anio_fin_renovacion = anio_fin_renovacion;
    }
    public boolean isVendido() {
        return vendido;
    }
    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
    
    //toString
    @Override
    public String toString() {
        return "Marbete{" +
                "secuencia=" + secuencia +
                ", anio_inicio_renovacion=" + anio_inicio_renovacion +
                ", anio_fin_renovacion=" + anio_fin_renovacion +
                ", vendido=" + vendido +
                '}';
    }
}