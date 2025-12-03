package com.progmproyect.util.daos;

import javax.persistence.EntityManager;


import com.progmproyect.util.JPAutil;
import com.progmproyect.util.modelos.Vehiculo;

public class VehiculoDao {
    public Vehiculo buscarPorPlaca(String placa) {
       EntityManager em = JPAutil.getEntityManager();
       Vehiculo vehiculo = null;
       try {
         vehiculo = em.find(Vehiculo.class, placa);
       } catch (Exception e) {
        System.out.println("Error al buscar el vehiculo: " + e.getMessage());
       }finally {
        em.close();
       }
       return vehiculo;
    }

    public void actualizar(Vehiculo vehiculo) {
        EntityManager em = JPAutil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(vehiculo);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el vehiculo: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
}
