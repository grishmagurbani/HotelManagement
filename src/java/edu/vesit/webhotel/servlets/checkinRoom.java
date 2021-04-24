/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.servlets;

import edu.vesit.webhotel.bean.Booking;
import edu.vesit.webhotel.bean.Guest;
import edu.vesit.webhotel.dao.bookingsDAO;
import edu.vesit.webhotel.dao.detailsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class checkinRoom extends HttpServlet {

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
        System.out.println("insidecheckin");
        
        String phoneno = request.getParameter("phoneno").toString();
        String roomno = request.getParameter("roomno").toString();
        System.out.println("phone is "+phoneno+"room is "+roomno);
        Boolean st=false;
        bookingsDAO bDAO=new bookingsDAO();
        detailsDAO dDAO=new detailsDAO();
        
               
        if(!phoneno.equals("") && !roomno.equals(""))
        {
            System.out.println("HAppy?");
             st=bDAO.roomCheckin(phoneno,roomno);
             if(st)
             {
            request.setAttribute("message","Checked-in Successfully.");
        //  response.sendRedirect("Login.jsp");
            request.getRequestDispatcher("VisitorManagement.jsp").forward(request, response);
            
                 
             }
             else
             {
            request.setAttribute("message","Error.");
        //  response.sendRedirect("Login.jsp");
            request.getRequestDispatcher("VisitorManagement.jsp").forward(request, response);
            
             }
            
        }
        else
        {
            request.setAttribute("message","Please enter the roomno.");
        //  response.sendRedirect("Login.jsp");
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
