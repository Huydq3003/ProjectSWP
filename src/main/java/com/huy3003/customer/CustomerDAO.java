/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huy3003.customer;

import com.huy3003.product.Product;
import com.huy3003.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huy
 */
public class CustomerDAO {
    private static final String LOGIN = "SELECT id, first_name, last_name, phone, address FROM account.customer WHERE email=? AND password=? ";
    private static final String SEARCH = "SELECT id, first_name, last_name, email, phone FROM account.customer WHERE first_name + ' ' + last_name like ?";
    private static final String DELETE = "DELETE account.customer WHERE id=?";
    private static final String UPDATE = "UPDATE account.customer SET first_name=?, last_name=?, email=?, phone=?, address=? WHERE id=?";
    private static final String CREATE = "INSERT INTO tblUsers(first_name, last_name, email, phone, address, password) VALUES(?,?,?,?,?,?)";

    public Customer checkLogin(String email, String password) throws SQLException {
        Customer loginCustomer = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, email);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    loginCustomer = new Customer(id, email, firstName, lastName, phone, address, "");
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return loginCustomer;
    }
    
    public List<Product> getListProduct(String search) {
        List<Product> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("first_name");
                    String material = rs.getString("last_name");
                    String size = rs.getString("size");
                    String style = rs.getString("style");
                    Float price = rs.getFloat("price");                   
                    int quantity = rs.getInt("quantity");                   
                    listProduct.add(new Product(id, name, material, size, style, price, quantity));
                }
            }
        } catch (Exception e) {
        }
        return listProduct;
    }
    
    public boolean create(Customer cus) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE);
                ptm.setString(1, cus.getFirstName());
                ptm.setString(2, cus.getLastName());
                ptm.setString(3, cus.getEmail());
                ptm.setString(4, cus.getPhone());
                ptm.setString(5, cus.getAddress());
                ptm.setString(6, cus.getPassword());
                result = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
    
    public boolean delete(String id) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, id);
                int count = ptm.executeUpdate();
                if (count > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
    
    public boolean update(Customer cus) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, cus.getFirstName());
                ptm.setString(2, cus.getLastName());
                ptm.setString(3, cus.getEmail());
                ptm.setString(4, cus.getPhone());
                ptm.setString(5, cus.getAddress());
                ptm.setInt(6, cus.getId());
                result = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
}
