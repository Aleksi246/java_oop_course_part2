package model;

import java.util.HashMap;
import java.util.Set;

public class Converter {
    static class CurrencyRates{

    static HashMap<String,Double> currencys = new HashMap<String,Double>();
    static{
        currencys.put("EUR", 1.0);
        currencys.put("USD", 1.1646);     // US Dollar
        currencys.put("GBP", 0.8702);     // British Pound Sterling
        currencys.put("AUD", 1.7897);     // Australian Dollar
        currencys.put("CAD", 1.6056);     // Canadian Dollar
        currencys.put("CHF", 0.9366);     // Swiss Franc
        currencys.put("CNY", 8.3202);     // Chinese Yuan Renminbi
        currencys.put("JPY", 173.10);     // Japanese Yen
        currencys.put("HKD", 9.0915);     // Hong Kong Dollar
        currencys.put("INR", 102.5795);   // Indian Rupee
        currencys.put("NOK", 11.674);     // Norwegian Krone
        currencys.put("SEK", 11.003);     // Swedish Krona
        currencys.put("NZD", 1.9892);     // New Zealand Dollar
        currencys.put("PHP", 66.762);     // Philippine Peso
        currencys.put("PLN", 4.2653);     // Polish Zloty
        currencys.put("THB", 37.704);     // Thai Baht
        currencys.put("TRY", 47.9289);    // Turkish Lira
        currencys.put("ZAR", 20.6439);    // South African Rand
    }
    //List<String> keyList = new ArrayList<>(map.keySet());
    static Set<String> keys = currencys.keySet();
    }

    public double getAmount(String from, String to, double amountOfFrom){
        return (CurrencyRates.currencys.get(to)*amountOfFrom)/CurrencyRates.currencys.get(from);
    }
    public Set getKeys(){
        return CurrencyRates.keys;
    }

}
