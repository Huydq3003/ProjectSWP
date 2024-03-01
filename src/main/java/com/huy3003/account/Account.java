/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huy3003.account;

import com.huy3003.admin.Admin;
import com.huy3003.customer.Customer;
import com.huy3003.guest.Guest;
import com.huy3003.staff.Staff;

/**
 *
 * @author huy
 */
public class Account {
    
    private Customer cus;
    private Staff staff;
    private Guest guest;
    private Admin ad;

    public Account(Customer cus, Staff staff, Guest guest, Admin ad) {
        this.cus = cus;
        this.staff = staff;
        this.guest = guest;
        this.ad = ad;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Admin getAd() {
        return ad;
    }

    public void setAd(Admin ad) {
        this.ad = ad;
    }
    
    
}
