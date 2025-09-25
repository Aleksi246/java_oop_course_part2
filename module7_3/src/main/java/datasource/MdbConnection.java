package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jakarta.persistence.*;

public class MdbConnection {
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManager getInstance() {

        if (em==null) {
            if (emf==null) {
                emf = Persistence.createEntityManagerFactory("CurrencyMariaDbUnit");
            }
            em = emf.createEntityManager();
        }
        return em;
    }

}
