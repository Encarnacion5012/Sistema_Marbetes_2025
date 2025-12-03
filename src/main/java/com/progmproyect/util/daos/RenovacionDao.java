package com.progmproyect.util.daos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.progmproyect.util.JPAutil;
import com.progmproyect.util.modelos.Renovacion;

public class RenovacionDao {
    public void guardarRenovacion(Renovacion renovacion) {
        EntityManager em = JPAutil.getEntityManager();  
        try {
            em.getTransaction().begin();
            em.persist(renovacion);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al guardar la renovación: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    public List<Renovacion> listarPorFechas(LocalDate inicio, LocalDate fin) {
        EntityManager em = JPAutil.getEntityManager();
        List<Renovacion> lista = null;
        try {
            // Ajustamos la fecha fin para que incluya todo el día hasta las 23:59 (si fuera necesario), 
            // pero como usas LocalDate, JPA compara solo la parte de la fecha o lo maneja según la BD.
            
            String jpql = "SELECT r FROM Renovacion r WHERE r.fecha_renovacion BETWEEN :inicio AND :fin ORDER BY r.fecha_renovacion DESC";
            TypedQuery<Renovacion> query = em.createQuery(jpql, Renovacion.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fin", fin);
            
            lista = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(em != null) em.close();
        }
        return lista;
    }
}
