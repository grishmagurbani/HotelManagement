<%-- 
    Document   : RoomManagement
    Created on : Jun 28, 2018, 7:52:41 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Room Management</title>
    </head>
    
    
    
     <body style=" background-color: #cccccc;
    background-image: linear-gradient(lightgoldenrodyellow,whitesmoke);" ><center>
      <img src="New folder\royalmarine.png" alt="hotellogo" height="250" width="300"> <br/>
       <p style="background-color:lightblue; font-family: Harlow Solid Italic, Times, serif; font-size: 30px;">Room Management</p>
     </center>
     
        <h3 style="border:2px solid lightblue; " >Room Number</h3>
        <form action="searchRoom" method="GET">  
            <table> 
                <tr><td>Enter Room no<td>:<td><input type="text" name="roomno" value="<%=request.getAttribute("roomno")==null?"":request.getAttribute("roomno")%>" /> 
                <tr><td colspan="3"><input type="submit" value="Search"/>  
        </form>  
            
             
            <% String message = request.getAttribute("message") == null ? "" : request.getAttribute("message").toString();
            System.out.println("message:" + message);
            String roomtype = request.getAttribute("roomtype") == null ? "" : request.getAttribute("roomtype").toString();
            String status = request.getAttribute("status") == null ? "" : request.getAttribute("status").toString();
            String occupiedby = request.getAttribute("occupiedby") == null ? "" : request.getAttribute("occupiedby").toString();
            String phoneno = request.getAttribute("phoneno") == null ? "" : request.getAttribute("phoneno").toString();
            String checkin = request.getAttribute("checkin") == null ? "" : request.getAttribute("checkin").toString();
            String checkout = request.getAttribute("checkout") == null ? "" : request.getAttribute("checkout").toString();

        %>
        
        
        <%if (message != null) {%>
            <p><font color="red" face="verdana" size="3"/><%=message%></p>  </font>
            <%}%>
        
        <h3 style="border:2px solid lightblue; " >Room Details</h3>
        <form action="clearRoom" method="GET">  
            <input type="hidden" name="roomno" value="<%=request.getAttribute("roomno")%>"/>
            <table>
                <tr><td>Room Type<td>:<td><input type="text" name="roomtype" value= "<%= roomtype%>"/>
                <tr><td>Status<td>:<td> <input type="text" name="status" value="<%= status%>"/>
                <tr><td>Occupied By<td>:<td><input type="text" name="occupiedby" value="<%=occupiedby%>" />
                <tr><td>Phone No<td>:<td><input type="text" name="phoneno" value="<%=phoneno%>"/>
                <tr><td>Check-in Date<td>:<td><input type="text" name="checkin" value="<%=checkin%>"/>
                <tr><td>Check-out Date<td>:<td><input type="text" name="checkout" value="<%=checkout%>"/>
                <tr><td colspan="3"><input type="submit" value="Clear"/>   
            </table>
        </form> <br/><br/>
    </body>
</html>
