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
public class enterBooking extends HttpServlet {

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
        Boolean type;
        bookingsDAO d=new bookingsDAO();
        detailsDAO objt=new detailsDAO();
        String checkin = request.getParameter("checkin");
        String checkout = request.getParameter("checkout");
        String phoneno = request.getParameter("phoneno");
        String choice = request.getParameter("type");
        

        System.out.println("your choice is "+choice);
        if(choice!=null)
        {
        String room =d.findRoom(choice);
        System.out.println("phone:"+phoneno);
        
        Booking bObj = new Booking();
        bObj.setCheckin(checkin);
        bObj.setCheckout(checkout);
        bObj.setPhoneno(phoneno);
        
        bObj.setRoom(room);
        
        Guest visitor=new Guest();
        visitor=objt.checkExisting(phoneno);
        if(visitor.getFullname()!=null && visitor.getIdnumber()!=null)
        {
                 Boolean dkn=d.bookingEnter(bObj);
        if(dkn==true)
        {
            request.setAttribute("message","Successfully Booked. Room no is "+bObj.getRoom());
        //  response.sendRedirect("Login.jsp");
            request.getRequestDispatcher("GuestBooking.jsp").forward(request, response);
            
        
        }
        else
        {
            request.setAttribute("message","Please enter all the booking details");
        //  response.sendRedirect("Login.jsp");
            request.getRequestDispatcher("GuestBooking.jsp").forward(request, response);
            
        }    
        }
        else
            {
            request.setAttribute("message","First enter your details.");
        //  response.sendRedirect("Login.jsp");
            request.getRequestDispatcher("GuestBooking.jsp").forward(request, response);
            
        }    
        
        }
    else
        {
            request.setAttribute("message","Please enter all the booking details");
        //  response.sendRedirect("Login.jsp");
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
