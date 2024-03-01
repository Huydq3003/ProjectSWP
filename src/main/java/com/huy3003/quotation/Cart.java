/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huy3003.quotation;

import com.huy3003.product.Product;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author huy
 */
public class Cart {
    
    private Map<Integer, Product> cart;
    
    public Cart() {
        
    }

    public Cart(Map<Integer, Product> cart) {
        this.cart = cart;
    }

    public Map<Integer, Product> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, Product> cart) {
        this.cart = cart;
    }
    
    public boolean add(Product pro) {
        boolean newPro = true;
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(pro.getId())){
            newPro = false;
            int currentQuantity = (int) this.cart.get(pro.getId()).getQuantity();
            pro.setQuantity(currentQuantity + pro.getQuantity());
        } 
        cart.put(pro.getId(), pro);
        return newPro;
    }
    
    public void delete(int id) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)){
           this.cart.remove(id);
        }
    }
    
    public void update(int id, Product pro) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.replace(id, pro);
        }
    }
}
