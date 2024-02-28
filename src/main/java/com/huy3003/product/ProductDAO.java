/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huy3003.product;

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
public class ProductDAO {
    
    private static final String SEARCH = "SELECT id, name, material, size, style, price, quantity FROM production.product WHERE name like ?";
    private static final String DELETE = "DELETE production.product WHERE id=?";
    private static final String UPDATE = "UPDATE production.product SET name=?, material=?, size=?, style=?, price=?, quantity=? WHERE id=?";
    private static final String CREATE = "INSERT INTO production.product(name, material, size, style, price, quantity) VALUES(?,?,?,?,?,?)";
    
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
                    String name = rs.getString("name");
                    String material = rs.getString("material");
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
    
    public boolean update(Product product) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, product.getName());
                ptm.setString(2, product.getMaterial());
                ptm.setString(3, product.getSize());
                ptm.setString(4, product.getStyle());
                ptm.setFloat(5, product.getPrice());
                ptm.setInt(6, product.getQuantity());
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
    
    public boolean create(Product pro) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE);
                ptm.setString(1, pro.getName());
                ptm.setString(2, pro.getMaterial());
                ptm.setString(3, pro.getSize());
                ptm.setString(4, pro.getStyle());
                ptm.setFloat(5, pro.getPrice());
                ptm.setInt(6, pro.getQuantity());
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
