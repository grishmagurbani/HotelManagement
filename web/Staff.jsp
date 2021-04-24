<%-- 
    Document   : Staff
    Created on : 27 Jun, 2018, 10:52:02 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Page</title>
    </head>
    
        <body style=" background-color: #cccccc;
    background-image: linear-gradient(lightgoldenrodyellow,whitesmoke);" ><center>
      <img src="New folder\royalmarine.png" alt="hotellogo" height="250" width="300"> 
       <p style="background-color:lightblue; font-family: Harlow Solid Italic, Times, serif; font-size: 50px;">Welcome Staff</p>
       
       <!--
       <h1 style="border:2px solid lightblue; " >Visitor Management</h1>
       <form action="VisitorManagement.jsp">    
            <input type="submit" value="For details regarding bookings, click here..."/>  <br/><br/>
        </form>  
        
        <h1 style="border:2px solid lightblue; " >Room Management</h1>
        <form action="RoomManagement.jsp">    
            <input type="submit" value="For details regarding rooms, click here..."/>  <br/>
        </form>-->
       
    <div class="container text-center  ">
    <h2><strong></strong></h2>
    <div class="row">
        <div class="col-sm-4">
            <a href="http://localhost:8080/WebHotel/VisitorManagement.jsp"><img src="New folder\visitor.png" height="200" width="200" class="img-circle" id="icon"></a>
            <h3><strong>VISITOR MANAGEMENT</strong></h3>
        </div>
        <div class="col-sm-4">
            <a href="http://localhost:8080/WebHotel/RoomManagement.jsp"><img src="New folder\room.png" height="160" width="160" class="img-circle" id="icon"></a>
            <h3><strong>ROOM MANAGEMENT</strong></h3>
        </div>
        
       
    </div>
</div>

    <br/><br/> <br/>     <br/><br/> <br/>     <br/><br/> <br/>
    </center>
    </body>
   
</html>
