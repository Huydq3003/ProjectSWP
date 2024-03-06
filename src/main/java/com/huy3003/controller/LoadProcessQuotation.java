/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.huy3003.controller;

import DLC.MessageSpecified;
import com.huy3003.customer.Customer;
import com.huy3003.quotation.Quotation;
import com.huy3003.quotation.QuotationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author huy
 */
public class LoadProcessQuotation extends HttpServlet {

    private static final String ERROR = "customer.jsp";
    private static final String PROCESSING_QUOTATION = "customer.jsp";
    private static final String SUCCESS_QUOTATION = "customerSuccessful.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        Customer cus = (Customer)request.getSession().getAttribute("account.customer");
        try {
            String action = request.getParameter("action");
            if (action.equals("LoadProcessQuotation")) {
                QuotationDAO dao = new QuotationDAO();
                List<Quotation> list = new ArrayList<>();
                list.addAll(dao.getQuotationBaseOnStatusDetailAndUser(true, "Waiting...", cus));
                Collections.sort(list);
                if (!list.isEmpty()) {
                    request.setAttribute("LIST_PROCESSING_QUOTATION_USER", list);
                    url = PROCESSING_QUOTATION;
                } 
                else {
                    MessageSpecified message = new MessageSpecified(null, "Empty", "Don't have any processing quotation!");
                    request.setAttribute("ERROR_MESSAGE", message);
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
