/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huy3003.quotation;

import com.huy3003.customer.Customer;
import com.huy3003.staff.Staff;
import java.sql.Date;

/**
 *
 * @author huy
 */
public class Quotation {
    
    private int id;
    private String name;
    private Date dateCreate;
    private Date expirationDate;
    private Float priceQuote;
    private boolean status;
    private Customer cus;
    private Staff staff;

    public Quotation() {
    }

    public Quotation(Customer cus, String name, Date dateCreate, Date expirationDate, Float priceQuote, Staff staff) {
        this.cus = cus;
        this.name = name;
        this.dateCreate = dateCreate;
        this.expirationDate = expirationDate;
        this.priceQuote = priceQuote;
        this.staff = staff;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Float getPriceQuote() {
        return priceQuote;
    }

    public void setPriceQuote(Float priceQuote) {
        this.priceQuote = priceQuote;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    
    
}
