/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huy3003.account;

import com.huy3003.utils.DBUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author huy
 */
public class AccountDAO {
    
    private static final String GET_ALL_ACCOUNT = "SELECT \n" +
                                                "    admin.id AS admin_id, admin.first_name AS admin_first_name, admin.last_name AS admin_last_name, \n" +
                                                "    admin.email AS admin_email, admin.password AS admin_password, \n" +
                                                "    staff.id AS staff_id, staff.first_name AS staff_first_name, staff.last_name AS staff_last_name,\n" +
                                                "    staff.email AS staff_email, staff.password AS staff_password, staff.phone AS staff_phone,\n" +
                                                "    customer.id AS customer_id, customer.first_name AS customer_first_name, customer.last_name AS customer_last_name,\n" +
                                                "    customer.email AS customer_email, customer.password AS customer_password, \n" +
                                                "    customer.phone AS customer_phone, customer.address AS customer_address,\n" +
                                                "    guest.id AS guest_id, guest.first_name AS guest_first_name, guest.last_name AS guest_last_name,\n" +
                                                "    guest.email AS guest_email, guest.phone AS guest_phone\n" +
                                                "FROM \n" +
                                                "    account.admin AS admin\n" +
                                                "LEFT JOIN \n" +
                                                "    account.staff AS staff ON admin.id = staff.admin_id\n" +
                                                "LEFT JOIN \n" +
                                                "    account.customer AS customer ON admin.id = customer.admin_id\n" +
                                                "LEFT JOIN \n" +
                                                "    account.guest AS guest ON admin.id = guest.admin_id;";
    public static ArrayList<Account> getAllAccount() {
        ArrayList<Account> acc = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String url = GET_ALL_ACCOUNT;
                st = conn.createStatement();
                rs = st.executeQuery(url);
                while (rs.next()) {
                    String adminId = rs.getString("admin_id");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return acc;
    }
}
