package controller;

import dao.CurDao;
import view.View;
import entity.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

public class Controller {
    private View view;
    static CurDao curdao = new CurDao();


    public Controller(View view){
        this.view = view;
    }

    public BigDecimal getAmount(String from, String to, BigDecimal amountOfFrom){
        BigDecimal bfrom = curdao.getConv(from);
        BigDecimal bto = curdao.getConv(to);

        return (bto.multiply(amountOfFrom)).divide(bfrom, RoundingMode.HALF_UP);
    }

    public static Set getKeys(){
        return curdao.getAllAb();
    }

}
