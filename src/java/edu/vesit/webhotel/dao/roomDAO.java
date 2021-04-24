/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.dao;

import edu.vesit.webhotel.bean.Room;
import edu.vesit.webhotel.dbcon.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "roomDAO", urlPatterns = {"/roomDAO"})
public class roomDAO extends HttpServlet {
    
    public Room checkRoom(String roomno)
    {
        Room r=new Room();
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;          
        
        DBConnect dbcon = new DBConnect();
        try {
            con = dbcon.makeDBCon();
            String sql = "select ROOMNO,RTYPE,STATUS from ROOMS where ROOMNO='"+roomno+"'";
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                r.setRtype(rs.getString(2));
                r.setStatus(rs.getString(3));
                r.setRoomno(rs.getString(1));
                
                
            }
            
            
        } catch (Exception e) {
            System.out.println("MFFFFFFexception is " + e);
        }
        
        return r;
        
        
    }
    
    public Room checkOccupant(String roomno)
    {
        Room r=new Room();
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;          
        DBConnect dbcon = new DBConnect();
        r.setRoomno(roomno);
        try {
            con = dbcon.makeDBCon();
            String sql="select GUESTDETAILS.FULLNAME,GUESTBOOKINGS.PHONENO,to_char(GUESTBOOKINGS.CHECKIN,'dd.mm.yyyy'),to_char(GUESTBOOKINGS.CHECKOUT,'dd.mm.yyyy') from GUESTDETAILS join GUESTBOOKINGS on GUESTDETAILS.PHONENO=GUESTBOOKINGS.PHONENO where (GUESTBOOKINGS.STATUS='BOOKED' or GUESTBOOKINGS.STATUS='CHECKED_IN') and GUESTBOOKINGS.ROOM='"+roomno+"'";
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                r.setOccupiedby(rs.getString(1));
                r.setPhoneno(rs.getString(2));
                r.setCheckin(rs.getString(3));
                r.setCheckout(rs.getString(4));
                
                
            }
            
            
        } catch (Exception e) {
            System.out.println("MFFFFFFexception is " + e);
        }
        
        return r;
    }
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet roomDAO</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet roomDAO at " + request.getContextPath() + "</h1>");
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
