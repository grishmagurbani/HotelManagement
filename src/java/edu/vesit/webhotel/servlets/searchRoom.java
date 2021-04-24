/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.servlets;

import edu.vesit.webhotel.bean.Room;
import edu.vesit.webhotel.dao.roomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class searchRoom extends HttpServlet {

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
        request.setAttribute("clear","false");
        String roomno=request.getParameter("roomno");
        roomDAO rDAO=new roomDAO();
        Room r= rDAO.checkRoom(roomno);
        System.out.println("outside found room");
        if(r.getRtype()!=null && r.getRoomno()!=null && r.getStatus()!=null)
        {
            System.out.println("in found room");
           request.setAttribute("message","Room Found.");
           request.setAttribute("roomno",roomno);
           request.setAttribute("status",r.getStatus().equals("AVA") ? "Available":"Not Available");
           request.setAttribute("roomtype",r.getRtype()); 
           if(!r.getStatus().equals("AVA"))
           {
              Room r1=new Room();
              r1=rDAO.checkOccupant(roomno);
              request.setAttribute("occupiedby",r1.getOccupiedby());
              request.setAttribute("phoneno",r1.getPhoneno());
              request.setAttribute("checkin",r1.getCheckin());
              request.setAttribute("checkout",r1.getCheckout());
              request.getRequestDispatcher("RoomManagement.jsp").forward(request, response);
           }
           else
           {
              request.setAttribute("occupiedby","--");
              request.setAttribute("phoneno","--");
              request.setAttribute("checkin","--");
              request.setAttribute("checkout","--");
              request.getRequestDispatcher("RoomManagement.jsp").forward(request, response);
           }
           
           
           
           
           
           
           
        }
        else
        {
           request.setAttribute("message","No Such Room.");
           request.getRequestDispatcher("RoomManagement.jsp").forward(request, response);
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
