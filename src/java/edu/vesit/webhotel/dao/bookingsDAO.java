/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.dao;

import edu.vesit.webhotel.bean.Booking;
import edu.vesit.webhotel.dbcon.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class bookingsDAO extends HttpServlet {
    public String findRoom(String type)
    {
        Connection con=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String roomno = null;
        Boolean got=false;  
        DBConnect dbcon = new DBConnect();
        if(type.equals("AC"))
        {
        try {
            con = dbcon.makeDBCon();
            String s = "select ROOMNO from ROOMS where STATUS='AVA' and RTYPE='AC'" ;
            System.out.println(s);
            ps=con.prepareStatement(s);
            rs=ps.executeQuery();
            while(rs.next() && !got)
            {
                roomno=rs.getString(1);
                got=true;
            }
        }
        catch(Exception e)
        {
            System.out.println("YOUR EXCEPTION IS "+e);
        }
        }
        else
        {
            try {
            con = dbcon.makeDBCon();
            String s = "select ROOMNO from ROOMS where STATUS='AVA' and RTYPE='NONAC'" ;
            System.out.println(s);
            ps=con.prepareStatement(s);
            rs=ps.executeQuery();
            while(rs.next() && !got)
            {
                roomno=rs.getString(1);
                got=true;
            }
        }
        catch(Exception e)
        {
            System.out.println("YOUR EXCEPTION IS "+e);
        }
        
        }
        return roomno;
    }
    
    
    
    public boolean bookingEnter(Booking o) {
        Boolean st=false;
        Connection con=null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        
        DBConnect dbcon = new DBConnect();
        
        try {
            con = dbcon.makeDBCon();
            String s = "insert into GUESTBOOKINGS values(to_date('"+o.getCheckin()+"','dd/mm/yy'),to_date('"+o.getCheckout()+"','dd/mm/yy'),'"+o.getRoom()+"','BOOKED',"+o.getPhoneno()+")" ;
            System.out.println(s);
            ps=con.prepareStatement(s);
            rs=ps.executeQuery();
            String s1="update ROOMS set STATUS='NOTAVA' where ROOMNO='"+o.getRoom()+"'";
            System.out.println(s1);
            ps=con.prepareStatement(s1);
            rs=ps.executeQuery();
            
            
            
            st=true;
        }
        catch(Exception e)
        {
            System.out.println("YOUR EXCEPTION IS "+e);
        }
        return st;
   }
    public Boolean roomCheckin(String phoneno,String roomno)
    {
        Boolean st=false;
        Connection con=null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        
        DBConnect dbcon = new DBConnect();
        try {
            con = dbcon.makeDBCon();
            String s = "select * from GUESTBOOKINGS where PHONENO="+phoneno+" and ROOM='"+roomno+"' and STATUS='BOOKED'" ;
            System.out.println(s);
            ps=con.prepareStatement(s);
            rs=ps.executeQuery();
            if(rs.next())
            {
               
            
            String s1="update GUESTBOOKINGS set STATUS='CHECKED_IN' where ROOM='"+roomno+"' and PHONENO="+phoneno+" and STATUS='BOOKED'";
            System.out.println(s1);
            ps=con.prepareStatement(s1);
            rs=ps.executeQuery();
          
            st=true;
            
            
            
            }
            else
            {
                return false; 
            }
        }
        catch(Exception e)
        {
            System.out.println("YOUR EXCEPTION IS "+e);
        }
        return st;
   
    }
    
    public boolean roomCheckout(String phoneno,String roomno)
    {
        
        Boolean st=false;
        Connection con=null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        
        DBConnect dbcon = new DBConnect();
        
        try {
            con = dbcon.makeDBCon();
            String s = "select * from GUESTBOOKINGS where PHONENO="+phoneno+" and ROOM='"+roomno+"' and STATUS='CHECKED_IN'" ;
            System.out.println(s);
            ps=con.prepareStatement(s);
            rs=ps.executeQuery();
            if(rs.next())
            {
               
            
            String s1="update GUESTBOOKINGS set STATUS='CHECKED_OUT' where ROOM='"+roomno+"' and PHONENO="+phoneno+" and STATUS='CHECKED_IN'";
            System.out.println(s1);
            ps=con.prepareStatement(s1);
            rs=ps.executeQuery();
            String s2="update ROOMS set STATUS='AVA' where ROOMNO='"+roomno+"'";
            System.out.println(s2);
            ps=con.prepareStatement(s2);
            rs=ps.executeQuery();
            st=true;
            
            
            
            }
            else
            {
                return false; 
            }
        }
        catch(Exception e)
        {
            System.out.println("YOUR EXCEPTION IS "+e);
        }
        return st;
   
        
    }
    public boolean bookingCancel(String phoneno,String room)
    {
        Boolean st=false;
        Connection con=null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        
        DBConnect dbcon = new DBConnect();
        
        try {
            con = dbcon.makeDBCon();
            String s = "select * from GUESTBOOKINGS where PHONENO="+phoneno+" and ROOM='"+room+"' and STATUS='BOOKED'" ;
            System.out.println(s);
            ps=con.prepareStatement(s);
            rs=ps.executeQuery();
            if(rs.next())
            {
               
            
            String s1="update GUESTBOOKINGS set STATUS='CANCELLED' where ROOM='"+room+"' and PHONENO="+phoneno+" and STATUS='BOOKED'";
            System.out.println(s1);
            ps=con.prepareStatement(s1);
            rs=ps.executeQuery();
            String s2="update ROOMS set STATUS='AVA' where ROOMNO='"+room+"'";
            System.out.println(s2);
            ps=con.prepareStatement(s2);
            rs=ps.executeQuery();
            st=true;
            
            
            
            }
            else
            {
                return false; 
            }
        }
        catch(Exception e)
        {
            System.out.println("YOUR EXCEPTION IS "+e);
        }
        return st;
   
    }
    
    public boolean recordsClear(String phoneno)
    {
        Boolean st=false;
        Connection con=null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        
        DBConnect dbcon = new DBConnect();
        
        try {
            con = dbcon.makeDBCon();
            String s = "select * from GUESTBOOKINGS where PHONENO="+phoneno+" and (STATUS='CANCELLED' or STATUS='CHECKED_OUT')" ;
            System.out.println(s);
            ps=con.prepareStatement(s);
            rs=ps.executeQuery();
            if(rs.next())
            {
               
            
            String s1="delete from GUESTBOOKINGS where PHONENO="+phoneno+" and (STATUS='CHECKED_OUT' or STATUS='CANCELLED')";
            System.out.println(s1);
            ps=con.prepareStatement(s1);
            rs=ps.executeQuery();
            st=true;
            
            
            
            }
            else
            {
                return false; 
            }
        }
        catch(Exception e)
        {
            System.out.println("YOUR EXCEPTION IS "+e);
        }
        return st;
   
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
            out.println("<title>Servlet bookingsDAO</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet bookingsDAO at " + request.getContextPath() + "</h1>");
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
