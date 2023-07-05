package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "dollar")
    private double valueInDollar;
    @Column(name = "btc")
    private double valueInBtc;
    @Column(name = "rial")
    private double rial;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Person person;

    public double getRial() {
        return rial;
    }

    public void setRial(double rial) {
        this.rial = rial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public double getValueInDollar() {
        return valueInDollar;
    }

    public void setValueInDollar(double valueInDollar) {
        this.valueInDollar = valueInDollar;
    }

    public double getValueInBtc() {
        return valueInBtc;
    }

    public void setValueInBtc(double valueInBtc) {
        this.valueInBtc = valueInBtc;
    }
}
