package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="transactionid")
    private int transactionId;
    @Column(name="transaction")
    private String transaction;

    public Transaction(String tranaction){
        this.transaction = tranaction;
    }
    public Transaction(){}


}
