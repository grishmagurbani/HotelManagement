/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.dao;

import edu.vesit.webhotel.bean.Guest;
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
public class detailsDAO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public Guest checkExisting(String phoneno) {
        boolean status = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        
        DBConnect dbcon = new DBConnect();
        
        Guest guestObj = new Guest();
        
        try {
            con = dbcon.makeDBCon();
            String sql = "select FULLNAME,EMAIL,IDPROOF,IDNUMBER from GUESTDETAILS where PHONENO=" + phoneno;
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                guestObj.setFullname(rs.getString(1));
                guestObj.setEmail(rs.getString(2));
                guestObj.setIdproof(rs.getString(3));
                guestObj.setIdnumber(rs.getString(4));
                
                
            }
            guestObj.setPhoneno(phoneno);
            
        } catch (Exception e) {
            System.out.println("MFFFFFFexception is " + e);
        }
        
        return guestObj;
    }
    
    
    
   public boolean enterNew(Guest o) {
        Boolean st=false;
        Connection con=null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        
        DBConnect dbcon = new DBConnect();
        
        try {
            con = dbcon.makeDBCon();
            String sql = "insert into GUESTDETAILS values('"+o.getFullname()+"',"+o.getPhoneno()+",'"+o.getEmail()+"','"+o.getIdproof()+"','"+o.getIdnumber()+"')";
            System.out.println(sql);
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            st=true;
        }
        catch(Exception e)
        {
            System.out.println("YOUR EXCEPTION IS "+e);
        }
        return st;
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
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }
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
