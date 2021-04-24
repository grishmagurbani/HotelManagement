/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.servlets;

import edu.vesit.webhotel.bean.Staff;
import edu.vesit.webhotel.dao.staffDAO;
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
public class addStaff extends HttpServlet {

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
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String gender=request.getParameter("gender");
        System.out.println(gender);
        String contactno=request.getParameter("contactno");
        Boolean st;
        staffDAO sDAO=new staffDAO();
        String staffid=sDAO.getNewId();
        System.out.println(staffid);
        Staff staff=new Staff();
        staff.setFirstname(firstname);
        staff.setLastname(lastname);
        staff.setStaffid(staffid);
        staff.setGender(gender);
        staff.setContactno(contactno);
        if(!firstname.equals("") && gender!=null && !lastname.equals("")  && !contactno.equals("") )
        {
            System.out.println("inside if");
            st= sDAO.addStaff(staff);
        if(st)
        {
            request.setAttribute("message","Added Successfully. Staff ID is "+staffid);
            request.getRequestDispatcher("StaffManagement.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("message","Couldn't Add");
            request.getRequestDispatcher("StaffManagement.jsp").forward(request, response);
        }
        
    }
        else
        {
           request.setAttribute("message","Couldn't Add");
            request.getRequestDispatcher("StaffManagement.jsp").forward(request, response); 
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
