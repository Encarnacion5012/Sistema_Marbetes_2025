package com.progmproyect.util.daos;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.progmproyect.util.JPAutil;
import com.progmproyect.util.modelos.ReporteVenta;

public class ReporteDao {

    public List<ReporteVenta> obtenerReportePorFechas(LocalDate inicio, LocalDate fin) {
        EntityManager em = JPAutil.getEntityManager();
        List<ReporteVenta> lista = null;
        try {
            String jpql = "SELECT r FROM ReporteVenta r WHERE r.diaVenta BETWEEN :inicio AND :fin ORDER BY r.diaVenta DESC";
            TypedQuery<ReporteVenta> query = em.createQuery(jpql, ReporteVenta.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fin", fin);
            
            lista = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error en reporte: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return lista;
    }
}