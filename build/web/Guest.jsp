<%-- 
    Document   : Guest
    Created on : Jun 27, 2018, 1:15:37 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guest Page</title>
    </head>
  <body style=" background-color: #cccccc;
    background-image: linear-gradient(lightgoldenrodyellow,whitesmoke);" > <center>
      <img src="New folder\royalmarine.png" alt="hotellogo" height="250" width="300"> <br/>
       <p style="background-color:lightcoral; font-family: Harlow Solid Italic, Times, serif; font-size: 50px;">Welcome Guest</p>
       
        
        <!--
        <h1 style="border:2px solid lightcoral; " >To Book a Room, Click Below...</h1>
       <form action="GuestBooking.jsp">    
            <input type="submit" value="   Book Room   "/>  <br/><br/>
        </form>  
        <h1 style="border:2px solid lightcoral; " >To Cancel a Booking, Click Below...</h1>
        <form action="GuestCancellation.jsp">    
            <input type="submit" value="Cancel Booking"/>  <br/>
        </form> 
        -->
    <div class="container text-center  ">
    <h2><strong></strong></h2>
    <div class="row">
        <div class="col-sm-4">
            <a href="http://localhost:8080/WebHotel/GuestBooking.jsp"><img src="New folder\book.png" height="200" width="200" class="img-circle" id="icon"></a>
            <h3><strong>BOOK ROOM</strong></h3>
        </div>
        <div class="col-sm-4">
            <a href="http://localhost:8080/WebHotel/GuestCancellation.jsp"><img src="New folder\cancel.png" height="160" width="160" class="img-circle" id="icon"></a>
            <h3><strong>CANCEL BOOKING</strong></h3>
        </div>
        
       
    </div>
</div>

    </center>  
    </body>
</html>
