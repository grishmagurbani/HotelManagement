<%-- 
    Document   : GuestBooking
    Created on : 27 Jun, 2018, 1:59:33 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--

-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking room</title>
    </head>
    
    
    <body style=" background-color: #cccccc;
    background-image: linear-gradient(lightgoldenrodyellow,whitesmoke);" ><center>
      <img src="New folder\royalmarine.png" alt="hotellogo" height="250" width="300"> <br/>
       <p style="background-color:lightcoral; font-family: Harlow Solid Italic, Times, serif; font-size: 30px;">Book Room</p>
    </center>       
       
       <h3 style="border:2px solid lightcoral; " >Phone Number</h3>
        <form action="searchDetails" method="GET">
            <table>
                <tr>
                <td>
            Enter Phone no</td>
                <td>:</td>
                <td><input type="text" name="phoneno" value="<%=request.getAttribute("phoneno")==null?"":request.getAttribute("phoneno")%>" /></td> 
                <td><input type="submit" value="Search"/>  </td>
                </tr>
            </table>
        </form>  
        <% String message = request.getAttribute("message") == null ? "" : request.getAttribute("message").toString();
            System.out.println("message:" + message);
            String fullname = request.getAttribute("fullname") == null ? "" : request.getAttribute("fullname").toString();
            String email = request.getAttribute("email") == null ? "" : request.getAttribute("email").toString();
            String idproof = request.getAttribute("idproof") == null ? "" : request.getAttribute("idproof").toString();
            String idnumber = request.getAttribute("idnumber") == null ? "" : request.getAttribute("idnumber").toString();
            
        %>
        <%if (message != null) {%>
        <p><font color="red" face="verdana" size="3"/><%=message%></p>  </font>
            <%}%>
        
        
        
        <h3 style="border:2px solid lightcoral; " >Personal Details</h3>
        <form action="enterDetails" method="POST">  
            <table>
                
            <input type="hidden" name="phoneno" value="<%=request.getAttribute("phoneno")%>"/>
            <tr>
                <td>Enter Full name</td><td>:</td><td><input type="text" name="fullname" value= "<%=fullname%>"/></td></tr>
            <tr><td>Enter Email</td><td>:</td><td> <input type="text" name="email" value="<%=email%>"/></td></tr>
            <tr><td>Enter Identity Proof</td><td>:</td><td><input type="text" name="idproof" value="<%=idproof%>" /></td></tr>
            <tr><td>Enter Identity Number</td><td>:</td><td><input type="text" name="idnumber" value="<%=idnumber%>"/></td></tr>
            <tr><td colspan="4"><input type="submit" value="Enter"/></td></tr>  
            </table>
        </form> <br/>
        
        
       
        <h3 style="border:2px solid lightcoral; " >Booking Details</h3>    
        <form action="enterBooking" method="POST">  
            <input type="hidden" name="phoneno" value="<%=request.getAttribute("phoneno")%>"/>
            <table>
                <tr><td>Enter Check-in</td><td>:</td><td><input type="text" name="checkin" onclick="this.value = ''" value= "dd/mm/yy" /></td></tr>
                <tr><td>Enter Check-out</td><td>:</td> <td><input type="text" name="checkout" onclick="this.value = ''" value="dd/mm/yy"/></td></tr>
            <tr><td>Enter Type</td><td>:</td><td> AC<input type="radio" name="type" value="AC"/>
                    NON-AC<input type="radio" name="type" value="NON-AC"/></td></tr>
            <tr><td colspan="3"><input type="submit" value="Book"/></tr>
            </table>
        </form> 
       
     <br/><br/><br/><br/><br/><br/>
    </align>
</body>
</html>
