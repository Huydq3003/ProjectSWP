/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huy3003.quotation;

import DLC.Extension;
import com.huy3003.customer.Customer;
import com.huy3003.customer.CustomerDAO;
import com.huy3003.product.Product;
import com.huy3003.staff.Staff;
import com.huy3003.utils.DBUtils;
import jakarta.enterprise.concurrent.Asynchronous;
import static java.rmi.server.LogStream.log;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author huy
 */
public class QuotationDAO {

    private static final String CREATE_QUOTATION = "INSERT INTO sale.quotation(name, date_create, customer_id, staff_id) VALUES(?,?,?,?)";
    private static final String CREATE_QUOTATION_PRODUCT = "INSERT INTO sale.quotation_product(quotation_id, product_id) VALUES(?,?)";
    private static final String GET_QUOTATION = "INSERT INTO sale.quotation_product(quotation_id, product_id) VALUES(?,?)";
    private static final String GET_LIST_QUOTATION = "";
    private static final String GET_QUOTATION_BASE_ON_USER = "SELECT id, date_create, customer_id";
    
    public List<Quotation> getOrders(boolean status) {
        List<Quotation> quo = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_QUOTATION);
                ptm.setBoolean(1, status);
                rs = ptm.executeQuery();
                quo = new ArrayList<>();
                while (rs.next()) {
                    int quotationID = rs.getInt("id");
                    String name = rs.getString("name");
                    Date createDate = rs.getDate("date_create");
                    Float priceQuote = rs.getFloat("price_quote");
                    int customerID = rs.getInt("customer_id");
                    Customer cus = new CustomerDAO().searchCustomerUpdate(customerID);
                    quo.add(new Quotation(cus, name, createDate, createDate, priceQuote, staff));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public int createQuotation(Quotation quo, Product pro, Customer cus, Staff staff) throws ClassNotFoundException, SQLException {
        int check = -1;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_QUOTATION, Statement.RETURN_GENERATED_KEYS);
                ptm.setString(1, quo.getName());
                ptm.setDate(2, new Date(System.currentTimeMillis()));
                ptm.setInt(3, cus.getId());
                ptm.setInt(4, staff.getId());
                if (ptm.executeUpdate() > 0) {
                    rs = ptm.getGeneratedKeys();
                    if (rs.next()) {
                        int quotationID = rs.getInt(1);
                        createQuotationProduct(pro, quotationID);
                        check = quotationID;
                    }
                }
            }
        } catch (Exception ex) {

        } finally {
            DBUtils.closeQueryConnection(conn, ptm, rs);
        }
        return check;
    }
    
    public boolean createQuotationProduct(Product pro, int quotationId) {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        Extension dlc = new Extension();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_QUOTATION_PRODUCT);
                ptm.setInt(1, quotationId);
                ptm.setInt(2, pro.getId());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception ex) {
            log("Error at createQuotationProduct in QuotationDAO" + ex.toString());
        } finally {
            DBUtils.closeQueryConnection(conn, ptm, null);
        }
        return check;
    }
    
    public List<Product> getQuotationByCustomerId(int customerId) throws SQLException, ClassNotFoundException {
        List<Quotation> quo = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_QUOTATION);
                ptm.setInt(1, customerId);
                rs = ptm.executeQuery();
                quo= new ArrayList<>();
                while (rs.next()) {
                    int quotationID = rs.getInt("quotation_id");
//                    Customer cus = new CustomerDAO().searchCustomerUpdate(customerId);
                }
            }
        } catch (Exception ex) {
            
        }
        return null;
        
    }

    public List<Quotation> getQuotationBaseOnStatusDetailAndUser(boolean status, String quotationStatus, Customer cus) {
        List<Quotation> quo = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_QUOTATION_BASE_ON_USER);
                ptm.setBoolean(1, status);
                ptm.setString(2, quotationStatus);
                ptm.setString(3, cus.getEmail());
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int quotationID = rs.getInt("id");
                    Date 
                    String
                }
            }
        } catch (Exception ex) {
            
        } 
    }


}
