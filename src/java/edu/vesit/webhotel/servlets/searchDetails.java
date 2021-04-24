/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.servlets;

import edu.vesit.webhotel.bean.Guest;
import edu.vesit.webhotel.dao.loginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.vesit.webhotel.dao.detailsDAO;

/**
 *
 * @author HP
 */
public class searchDetails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String phoneno = request.getParameter("phoneno");

        System.out.println("phoneno:" + phoneno);
        detailsDAO lol = new detailsDAO();
        Guest guest = lol.checkExisting(phoneno);
        try {
            if (guest.getEmail()!=null && guest.getFullname()!=null && guest.getIdnumber()!=null && guest.getIdproof()!=null) {
                request.setAttribute("fullname", guest.getFullname());
                request.setAttribute("email", guest.getEmail());
                request.setAttribute("idproof", guest.getIdproof());
                request.setAttribute("idnumber", guest.getIdnumber());
                request.setAttribute("phoneno", phoneno);
                request.setAttribute("message", "Record Found.");
                request.setAttribute("result", "1");
                request.getRequestDispatcher("GuestBooking.jsp").forward(request, response);
            } else {
                System.out.println("inside else");

                request.setAttribute("fullname", "");
                request.setAttribute("email", "");
                request.setAttribute("idproof", "");
                request.setAttribute("idnumber", "");
                request.setAttribute("phoneno", phoneno);
                request.setAttribute("message", "Record not Found.Please enter details.");
                request.setAttribute("result", "0");
                //response.sendRedirect("GuestBooking.jsp");
                request.getRequestDispatcher("GuestBooking.jsp").forward(request, response);

            }
        } catch (Exception e) {
            System.out.print("hey FUCKER" + e);
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
