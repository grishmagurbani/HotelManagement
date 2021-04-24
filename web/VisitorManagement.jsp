<%-- 
    Document   : VisitorManagement
    Created on : 28 Jun, 2018, 9:07:26 PM
    Author     : HP
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="edu.vesit.webhotel.bean.Booking"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitor Management</title>
        
        <script>
            function button1Click() {            

                document.formID.action = "checkinRoom";
                document.formID.submit();
            }
            function button2Click() {
               
                document.formID.action = "checkoutRoom";
                document.formID.submit();
            }
            function button3Click() {
                
                document.formID.action = "cancelRoom";
                document.formID.submit();
            }
            function button4Click() {
                
                document.formID.action = "clearRecords";
                document.formID.submit();
            }

        </script>
    </head>
    
    
    
    
     <body style=" background-color: #cccccc;
    background-image: linear-gradient(lightgoldenrodyellow,whitesmoke);" ><center>
      <img src="New folder\royalmarine.png" alt="hotellogo" height="250" width="300"> <br/>
       <p style="background-color:lightblue; font-family: Harlow Solid Italic, Times, serif; font-size: 30px;">Visitor Management</p>
     </center>
     
       <h3 style="border:2px solid lightblue; " >Phone Number</h3>
       <form action="getBooking" method="POST">  
           <table>
               <tr><td>Enter Phone no<td>:<td><input type="text" name="phoneno" value= ""/>
               <tr><td colspan="3"><input type="submit" value="Search"/>  
           </table>
        </form> <br/><br/>
         <% String message = request.getAttribute("message") == null ? "" : request.getAttribute("message").toString();
         System.out.println("message:" + message);
         %>
       <%if (message != null) {%>
        <p><font color="red" face="verdana" size="3"/><%=message%></p>  </font>
            <%}%>
            
         
        
        
          <%
            String status = request.getAttribute("status") == null ? "" : request.getAttribute("status").toString();
            String fullname = request.getAttribute("fullname") == null ? "" : request.getAttribute("fullname").toString();
            String email = request.getAttribute("email") == null ? "" : request.getAttribute("email").toString();
            String idproof = request.getAttribute("idproof") == null ? "" : request.getAttribute("idproof").toString();
            String idnumber = request.getAttribute("idnumber") == null ? "" : request.getAttribute("idnumber").toString();
            //String idnumber = request.getAttribute("idnumber") == null ? "" : request.getAttribute("idnumber").toString();
            String roomno = request.getAttribute("roomno") == null ? "" : request.getAttribute("roomno").toString();
            System.out.println("identity:" + idnumber);
       
            if (status.equals("true")) {
                List<Booking> bookedList = new ArrayList<Booking>();
                bookedList = (List<Booking>) request.getAttribute("bookedList");

        %>
        
         <h3 style="border:2px solid lightblue; " >Booking Details</h3>
        <form action="" method="">  
            <input type="hidden" name="phoneno" value="<%=request.getAttribute("phoneno")%>"/>
            Full Name:<input type="text" name="fullname" value= "<%=fullname%>"/>
            Email: <input type="text" name="email" value="<%=email%>"/>
            ID number:<input type="text" name="idnumber" value="<%=idnumber%>" />
        </form> <br/><br/>
        
        
        <table border="5" cellspacing="5" bgcolor="white" width="40%">
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
           
           <!--here-->
          
        <form id="formID" name="formID" method="POST">
            <input type="hidden" name="phoneno" value="<%=request.getAttribute("phoneno")%>"/>
            Enter Room no:<input type="text" name="roomno" value="" /><br/><br/>
            <input type="submit" name="button1" id="submitButton" value="CHECKIN" onclick="button1Click()">
            <input type="submit" name="button2" id="submitButton" value="CHECKOUT"  onclick="button2Click()">
            <input type="submit" name="button3" id="submitButton" value="CANCEL BOOKING"  onclick="button3Click()">
            <input type="submit" name="button4" id="submitButton" value="CLEAR RECORDS"  onclick="button4Click()">
        </form><br/><br/>
           
           
           <br/><br/><br/><br/><br/><br/>
           
         <% }%>
    </body>
</html>
