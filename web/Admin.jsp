<%-- 
    Document   : Admin
    Created on : 27 Jun, 2018, 1:27:14 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Page</title>
    </head>
    
    
     <body style=" background-color: #cccccc;
    background-image: linear-gradient(lightgoldenrodyellow,whitesmoke);" ><center>
      <img src="New folder\royalmarine.png" alt="hotellogo" height="250" width="300"> 
       <p style="background-color:burlywood; font-family: Harlow Solid Italic, Times, serif; font-size: 50px;">Welcome Manager</p>
       
       <!--
       <h1 style="border:2px solid burlywood; " >Staff Management</h1>
        <form action="StaffManagement.jsp">    
            <input type="submit" value="Click here for details about Staff"/>  <br/><br/>
        </form>  
       
       <h1 style="border:2px solid burlywood; " >Visitor Management</h1>
        <form action="VisitorManagement.jsp">    
            <input type="submit" value="Click here for details about Visitors"/>  <br/><br/>
        </form>  
       
        <h1 style="border:2px solid burlywood; " >Room Management</h1>
        <form action="RoomManagement.jsp">    
            <input type="submit" value="Click here for details about Rooms"/>  <br/><br/>
        </form>-->
       
       
        <div class="container text-center  ">
    <h2><strong></strong></h2>
    <div class="row">
        <div class="col-sm-4">
            <a href="http://localhost:8080/WebHotel/StaffManagement.jsp"><img src="New folder\staffs.png" height="200" width="200" class="img-circle" id="icon"></a>
            <h3><strong>STAFF MANAGEMENT</strong></h3>
        </div>
        
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

        <br/><br/><br/><br/>
    </center>
    </body>
</html>
