/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.servlets;

import edu.vesit.webhotel.bean.Guest;
import edu.vesit.webhotel.dao.detailsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class enterDetails extends HttpServlet {

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
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String idproof = request.getParameter("idproof");
        String idnumber = request.getParameter("idnumber");
        String phoneno=request.getParameter("phoneno");
        System.out.println("phone:"+phoneno);
        detailsDAO lol=new detailsDAO();
        Guest guestObj = new Guest();
        guestObj.setFullname(fullname);
        guestObj.setEmail(email);
        guestObj.setIdproof(idproof);
        guestObj.setIdnumber(idnumber);
        guestObj.setPhoneno(phoneno);
        detailsDAO d=new detailsDAO();
        Boolean dkn=d.enterNew(guestObj);
        if(dkn==true)
        {
            request.setAttribute("message","Successfully Entered.");
        //  response.sendRedirect("Login.jsp");
            request.getRequestDispatcher("GuestBooking.jsp").forward(request, response);
            request.setAttribute("result", "1");
        
        }
        else
        {
            request.setAttribute("message","Please enter all the details(Only if it is not present already)");
        //  response.sendRedirect("Login.jsp");
            request.setAttribute("result", "0");
            request.getRequestDispatcher("GuestBooking.jsp").forward(request, response);
            
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
