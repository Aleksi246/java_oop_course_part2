package entity;

public class Currency {

    private String abbreviation;
    private String name;
    private double conversion_rate_to_EUR;

    public Currency(String abbreviation, String name , double d){
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversion_rate_to_EUR = d;
    }


    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getConversion_rate_to_EUR() {
        return conversion_rate_to_EUR;
    }

    public void setConversion_rate_to_EUR(double conversion_rate_to_EUR) {
        this.conversion_rate_to_EUR = conversion_rate_to_EUR;
    }


}
