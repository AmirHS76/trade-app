package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "transfer")
    private double amount;
    @Column(name = "time")
    private LocalTime Date;
    @Column(name = "result")
    private String result;
    @Column(name = "type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "firstpersonid")
    private Person person1;

    @ManyToOne
    @JoinColumn(name = "secondpersonid")
    private Person person2;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double transfer) {
        this.amount = transfer;
    }

    public LocalTime getDate() {
        return Date;
    }

    public void setDate(LocalTime date) {
        Date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Person getPerson1() {
        return person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }
}