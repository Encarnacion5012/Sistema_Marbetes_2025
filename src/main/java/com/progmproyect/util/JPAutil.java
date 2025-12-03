package com.progmproyect.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {
public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MarbetesPU");

public static EntityManager getEntityManager() {
    return emf.createEntityManager();
}
}
