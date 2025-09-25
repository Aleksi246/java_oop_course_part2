package dao;


import datasource.MdbConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import entity.*;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CurDao {

    public void persist(Currency cur) {
        EntityManager em = datasource.MdbConnection.getInstance();
        em.getTransaction().begin();
        em.persist(cur);
        em.getTransaction().commit();
    }
    public BigDecimal getConv(String ab) {
        EntityManager em = datasource.MdbConnection.getInstance();
        Currency cur = em.find(Currency.class, ab);
        BigDecimal d = cur.getConversion_rate_to_EUR();

        return d;
    }

    public List<String> getAllAb() {
        EntityManager em = datasource.MdbConnection.getInstance();
        List<String> abs = em.createQuery("select c.abbreviation from Currency c").getResultList();
        return abs;
    }

    public void update(Currency cur) {
        EntityManager em = datasource.MdbConnection.getInstance();
        em.getTransaction().begin();
        em.merge(cur);
        em.getTransaction().commit();
    }

}

