package br.edu.ifsp.arq.web1.ifitness.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
