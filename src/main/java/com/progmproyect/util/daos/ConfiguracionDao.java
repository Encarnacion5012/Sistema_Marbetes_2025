package com.progmproyect.util.daos;


import java.util.List;

import javax.persistence.EntityManager;

import com.progmproyect.util.JPAutil;
import com.progmproyect.util.modelos.Configuracion;





public class ConfiguracionDao {
    public Configuracion obtenerConfiguracionActual() {
        EntityManager em = JPAutil.getEntityManager();
        List<Configuracion> configs = null;
        try {
           configs = em.createQuery("SELECT c FROM Configuracion c", Configuracion.class).setMaxResults(1).getResultList();
        } 
           catch (Exception e) {
            System.out.println("Error al obtener la configuración: " + e.getMessage());
        } finally {
            em.close();
        }
        return (configs != null && !configs.isEmpty()) ? configs.get(0) : null;
    }
}
