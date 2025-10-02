package controller;

import dao.CurDao;
import dao.TranDao;
import entity.Currency;
import entity.Transaction;
import view.View;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;

public class Controller {
    private View view;
    static CurDao curdao = new CurDao();
    static TranDao trandao = new TranDao();


    public Controller(View view){
        this.view = view;
    }

    public BigDecimal getAmount(String from, String to, BigDecimal amountOfFrom){
        BigDecimal bfrom = curdao.getConv(from);
        BigDecimal bto = curdao.getConv(to);

        return (bto.multiply(amountOfFrom)).divide(bfrom, RoundingMode.HALF_UP);
    }

    public static List getKeys(){
        return curdao.getAllAb();
    }

    public void update(Currency cur){
        curdao.update(cur);
    }

    public void updatet(Transaction tra){
        trandao.update(tra);
    }

}
