/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.dao;

import edu.vesit.webhotel.bean.Staff;
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
public class staffDAO extends HttpServlet {
    public String getNewId()
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        String staffid=null;
        Integer a;
        DBConnect dbcon = new DBConnect();
        try {
            con = dbcon.makeDBCon();
            String sql = "select max(STAFFID) from STAFF";
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            a=Integer.parseInt(rs.getString(1));
            a=a+1;    
            staffid=a.toString();
            
           
            
        } catch (Exception e) {
            System.out.println("MFFFFFFexception is " + e);
        }
        
        return staffid;
    }
    
    public Boolean addStaff(Staff s)
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        Boolean st=false;
        DBConnect dbcon = new DBConnect();
        try {
            con = dbcon.makeDBCon();
            String sql = "insert into STAFF values('"+s.getStaffid()+"','"+s.getFirstname()+"','"+s.getLastname()+"','"+s.getGender()+"','"+s.getContactno()+"')";
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            String sql1 = "insert into LOGIN values('"+s.getStaffid()+"','"+s.getStaffid()+"')";
            System.out.println(sql);
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            st=true;
            
           
            
        } catch (Exception e) {
            System.out.println("MFFFFFFexception is " + e);
        }
        return st;
    }
     public Boolean removeStaff(String s)
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        Boolean st=false;
        DBConnect dbcon = new DBConnect();
        try {
            con = dbcon.makeDBCon();
            String sql0 = "select * from STAFF where STAFFID='"+s+"'";
            ps = con.prepareStatement(sql0);
            rs = ps.executeQuery();
            if(rs.next())
            {
            String sql = "delete from STAFF where STAFFID='"+s+"'";
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            String sql1 = "delete from LOGIN where USERID='"+s+"'";
            System.out.println(sql);
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            st=true;
            }
           
            
        } catch (Exception e) {
            System.out.println("MFFFFFFexception is " + e);
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
            out.println("<title>Servlet staffDAO</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet staffDAO at " + request.getContextPath() + "</h1>");
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
