package com.progmproyect.util.daos;

import java.util.List;

import javax.persistence.EntityManager;


import com.progmproyect.util.JPAutil;
import com.progmproyect.util.modelos.Marbete;

public class MarbeteDao {
    public Marbete obtenerSiguenteMarbeteDisponible(){
        EntityManager em = JPAutil.getEntityManager();
        List<Marbete> marbetes = null;
        try {
            marbetes = em.createQuery("SELECT m FROM Marbete m WHERE m.vendido = false ORDER BY m.secuencia ASC", Marbete.class).setMaxResults(1).getResultList();
        } catch (Exception e) {
            System.out.println("Error al obtener el marbete disponible: " + e.getMessage());
        }
        finally {
            em.close();
        }
        return (marbetes != null && !marbetes.isEmpty()) ? marbetes.get(0) : null;
    }

    public void actualizar(Marbete marbete) {
        EntityManager em = JPAutil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(marbete);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el marbete: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
}
