package dao;


import entity.Currency;

import java.math.BigDecimal;
import java.sql.*;
import datasource.MdbConnection;
import java.util.*;

public class CurDao {

    public BigDecimal getConv(String abbreviation){
        Connection conn = MdbConnection.getConnection();
        String sql = "SELECT conversion_rate_to_EUR FROM currency WHERE abbreviation=?";

        BigDecimal conv = new BigDecimal(0.0);

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, abbreviation);

            ResultSet rs = ps.executeQuery();

            rs.next();

            conv = rs.getBigDecimal(1);

        }catch(SQLException e){
            e.printStackTrace();
        }
        return conv;
    }

    //method to get all abreviations as a set

    public Set<String> getAllAb(){
        Connection conn = MdbConnection.getConnection();
        String sql = "SELECT abbreviation FROM currency";

        Set<String> abs = new HashSet<>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String ab = rs.getString(1);
                abs.add(ab);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return abs;

    }
}

