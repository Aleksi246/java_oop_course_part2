package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="currency")
public class Currency {
    @Id
    @Column(name="abbreviation")
    private String abbreviation;
    @Column(name="name")
    private String name;
    @Column(name="conversion_rate_to_EUR")
    private BigDecimal conversion_rate_to_EUR;

    public Currency(String abbreviation, String name, BigDecimal d) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversion_rate_to_EUR = d;
    }

    public Currency() {

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

    public BigDecimal getConversion_rate_to_EUR() {
        return conversion_rate_to_EUR;
    }

    public void setConversion_rate_to_EUR(BigDecimal conversion_rate_to_EUR) {
        this.conversion_rate_to_EUR = conversion_rate_to_EUR;
    }

}