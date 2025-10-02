package dao;

import entity.Currency;
import entity.Transaction;
import jakarta.persistence.EntityManager;

public class TranDao {

    public void persist(Transaction tra) {
        EntityManager em = datasource.MdbConnection.getInstance();
        em.getTransaction().begin();
        em.persist(tra);
        em.getTransaction().commit();
    }
    public void update(Transaction tra) {
        EntityManager em = datasource.MdbConnection.getInstance();
        em.getTransaction().begin();
        em.merge(tra);
        em.getTransaction().commit();
    }
}
