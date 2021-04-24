/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.servlets;

import edu.vesit.webhotel.bean.Booking;
import edu.vesit.webhotel.bean.Guest;
import edu.vesit.webhotel.dao.detailsDAO;
import edu.vesit.webhotel.dao.guestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class getBooking extends HttpServlet {

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
        String phoneno=request.getParameter("phoneno");
        request.setAttribute("phoneno",phoneno);
        Guest g=new Guest();
        detailsDAO dDAO=new detailsDAO();
        g=dDAO.checkExisting(phoneno);
        if(g.getFullname()!= null && g.getEmail()!=null && g.getIdnumber()!=null && g.getIdproof()!=null)
        {
            try{
            request.setAttribute("status","true");
            
            request.setAttribute("fullname",g.getFullname());
            request.setAttribute("email",g.getEmail());
            request.setAttribute("idproof",g.getIdproof());
            request.setAttribute("idnumber",g.getIdnumber());
            guestDAO gDAO=new guestDAO();
            System.out.println(g.getIdnumber());
            List<Booking> bookedList =  gDAO.getBookings(g);
            request.setAttribute("bookedList", bookedList);
            
            request.setAttribute("message","Found Successfully.");
            request.getRequestDispatcher("VisitorManagement.jsp").forward(request, response);
        }catch(Exception e){System.out.println(e);}
        }
        else
        {
            request.setAttribute("message","No Record Found.");
            request.getRequestDispatcher("VisitorManagement.jsp").forward(request, response);
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
