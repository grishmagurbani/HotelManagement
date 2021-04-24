<%-- 
    Document   : GuestCancellation
    Created on : 27 Jun, 2018, 2:01:53 PM
    Author     : HP
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.vesit.webhotel.bean.Booking"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancellation Page</title>
    </head>
    
    
    
    
    <body style=" background-color: #cccccc;
    background-image: linear-gradient(lightgoldenrodyellow,whitesmoke);" ><center>
      <img src="New folder\royalmarine.png" alt="hotellogo" height="250" width="300"> <br/>
       <p style="background-color:lightcoral; font-family: Harlow Solid Italic, Times, serif; font-size: 30px;">Cancel Booking</p>
    </center> 
       
       
       
        <h3 style="border:2px solid lightcoral; " >Identification</h3>
        <form action="checkBooking" method="POST">  
            <table>
                <tr><td>Enter Phoneno<td>:<td><input type="text" name="phoneno" value= ""/>
                <tr><td>Enter Fullname<td>:<td><input type="text" name="fullname" value="" />
                <tr><td>Enter Identity number<td>:<td><input type="text" name="idnumber" value=""/>
                <tr><td colspan="3"><input type="submit" value="Search"/>  
            </table>
        </form> <br/><br/>
        
       <% String message = request.getAttribute("message") == null ? "" : request.getAttribute("message").toString();%>
       <%if (message != null) {%>
        <p><font color="red" face="verdana" size="3"/><%=message%></p>  </font>
            <%}%>
            

        <%
            String status = request.getAttribute("status") == null ? "" : request.getAttribute("status").toString();
            if (status.equals("true")) {
                List<Booking> bookedList = new ArrayList<Booking>();
                bookedList = (List<Booking>) request.getAttribute("bookedList");

        %>
        
        
        <h3 style="border:2px solid lightcoral; " >Booking Details</h3>
        
        <table border="5" cellspacing="5" bgcolor="white" width="30%">
            <tr>
                <th>Checkin</th>
                <th>Checkout</th>
                <th>Room</th>
                <th>Status</th>
            </tr>
            <% for (Booking bookObj : bookedList) {%> 
            <tr>
                
                <td><%=bookObj.getCheckin()%></td>
                <td><%=bookObj.getCheckout()%></td>
                <td><%=bookObj.getRoom()%></td>
                <td><%=bookObj.getStatus()%></td>
               
                <% }%>
            </tr>
        </table>
           <br/> <br/><br/>
           <form action="cancelBooking" method="POST">  
               <table>
                   <tr><td>Enter Room Number<td>:<td><input type="text" name="room" value= ""/> </tr>       
              <input type="hidden" name="phoneno" value="<%=request.getAttribute("phoneno")%>"/>
              <tr><td colspan="3"><input type="submit" value="CANCEL BOOKING"/>  </tr>
           </table>
           </form> <br/><br/><br/><br/><br/><br/>
         
            
        <% }%>
        
        <br/><br/><br/><br/><br/><br/><br/><br/>
        
    </body>
</html>
