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

}

