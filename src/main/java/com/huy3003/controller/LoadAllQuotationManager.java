/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.huy3003.controller;

import com.huy3003.quotation.Quotation;
import com.huy3003.quotation.QuotationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author huy
 */
public class LoadAllQuotationManager extends HttpServlet {

    private static final String ALL_QUOTATION = "viewAllQuotationManagement.jsp";
    private static final String PROCESSING_QUOTATION = "viewAllQuotationManagement.jsp";
    private static final String APPROVED_QUOTATION = "viewAllQuotationManagement.jsp";
    private static final String SUCCESSFUL_QUOTATION = "viewAllQuotationManagement.jsp";
    private static final String RETURNED_QUOTATION = "viewAllQuotationManagement.jsp";
    private static final String CANCLE_QUOTATION = "viewAllQuotationManagement.jsp";
    private static final String ERROR = "viewAllQuotationManagement.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try  {
            String action = request.getParameter("action");
            if (action.equals("LoadAllQuotationManager")) {
                QuotationDAO dao = new QuotationDAO();
                
                List<Quotation> list = new ArrayList<>();
                list.addAll(dao.getOrders(true));
                list.addAll(dao.getOrders(false));
            }
        } catch (Exception ex) {
            
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
