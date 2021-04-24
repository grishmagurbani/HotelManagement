/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.dao;

import edu.vesit.webhotel.bean.Booking;
import edu.vesit.webhotel.bean.Guest;
import edu.vesit.webhotel.dbcon.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "guestDAO", urlPatterns = {"/guestDAO"})
public class guestDAO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public List<Booking> getBookings(Guest g)
    {
        boolean status = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        List<Booking> bookedList=new ArrayList<Booking>();
        DBConnect dbcon = new DBConnect();
        try {
            con = dbcon.makeDBCon();
            String s="select to_char(GUESTBOOKINGS.CHECKIN,'dd.mm.yy'),to_char(GUESTBOOKINGS.CHECKOUT,'dd.mm.yy'),GUESTBOOKINGS.ROOM,GUESTBOOKINGS.STATUS  from GUESTDETAILS join GUESTBOOKINGS on GUESTDETAILS.PHONENO=GUESTBOOKINGS.PHONENO where GUESTDETAILS.PHONENO="+g.getPhoneno()+" and GUESTDETAILS.FULLNAME='"+g.getFullname()+"' and GUESTDETAILS.IDNUMBER='"+g.getIdnumber()+"'";
            System.out.println(s);
            ps = con.prepareStatement(s);
            rs = ps.executeQuery();
            while (rs.next()) {
                Booking bObj=new Booking();
                bObj.setCheckin(rs.getString(1));
                bObj.setCheckout(rs.getString(2));
                bObj.setRoom(rs.getString(3));
                bObj.setStatus(rs.getString(4));
                bObj.setPhoneno(g.getPhoneno());
                bookedList.add(bObj);
                
                
            }
            
        } catch (Exception e) {
            System.out.println("MFFFFFFexception is " + e);
        }
        
        return bookedList;
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet guestDAO</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet guestDAO at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
