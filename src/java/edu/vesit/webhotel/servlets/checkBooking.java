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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class checkBooking extends HttpServlet {

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
        String fullname = request.getParameter("fullname");
        String idnumber = request.getParameter("idnumber");
        Guest g=new Guest();
        guestDAO guestObj=new guestDAO();
        g.setFullname(fullname);
        g.setPhoneno(phoneno);
        g.setIdnumber(idnumber);
        String status = "false";
        
            
        detailsDAO objt=new detailsDAO();
        Guest visitor=new Guest();
        visitor=objt.checkExisting(phoneno);
        if(visitor.getFullname()!=null && visitor.getIdnumber()!=null)
        {
            if(visitor.getFullname().equals(g.getFullname()) && visitor.getIdnumber().equals(g.getIdnumber()) )
            { System.out.println("got here");
        try{          
        List<Booking> bookedList =  guestObj.getBookings(g);
        request.setAttribute("bookedList", bookedList);
        status="true";
        request.setAttribute("status", status);
        request.setAttribute("phoneno",phoneno);
        request.getRequestDispatcher("GuestCancellation.jsp").forward(request, response);
    }catch(Exception e)
    {System.out.println("exception"+e);
          
    }
            }
            else{
          request.setAttribute("message","No Matches!");
          request.setAttribute("status", status);
          request.getRequestDispatcher("GuestCancellation.jsp").forward(request, response);
        }
    }
        else{
          request.setAttribute("message","No Matches!");
          request.setAttribute("status", status);
          request.getRequestDispatcher("GuestCancellation.jsp").forward(request, response);
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
