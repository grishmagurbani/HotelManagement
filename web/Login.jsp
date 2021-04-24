<%-- 
    Document   : Login
    Created on : Jun 27, 2018, 1:15:45 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <% String message = request.getAttribute("message") == null ? "" : request.getAttribute("message").toString();
            System.out.println("message:" + message);
        %>
    </head>
    
    
    
    
    <body style=" background-color: #cccccc;
    background-image: linear-gradient(lightgoldenrodyellow,whitesmoke);" ><center>
      <img src="New folder\royalmarine.png" alt="hotellogo" height="250" width="300"> 
       <p style="background-color:lightgrey; font-family: Harlow Solid Italic, Times, serif; font-size: 50px;">Welcome Employee</p>
       <br/> 
        <form action="loginValidate" method="POST">  
            <table>
                
                <tr><td>Enter UserID<td>:<td> <input type="text" name="uname" value="" onclick="this.value = ''" maxlength="16" size="20"/></tr>  
                <tr><td>Enter Password<td>:<td> <input type="password" name="pass"  value="" onclick="this.value = ''" maxlength="16" size="20"/></tr>
                <tr><td><td colspan="2"><input type="submit" value="LOGIN"/>  
             </table>
            <%if (message != null) {%>
            <p> <font color="red" face="verdana" size="3"/><%=message%></p>  
            <%}%>
            
        </form>  
    </center>
    </body>
</html>
