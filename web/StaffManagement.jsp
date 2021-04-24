<%-- 
    Document   : StaffManagement
    Created on : 28 Jun, 2018, 11:20:34 PM
    Author     : HP
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="edu.vesit.webhotel.bean.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="edu.vesit.webhotel.bean.Booking"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Management</title>
    </head>
    
    
    
    
     <body style=" background-color: #cccccc;
    background-image: linear-gradient(lightgoldenrodyellow,whitesmoke);" ><center>
      <img src="New folder\royalmarine.png" alt="hotellogo" height="250" width="300"> <br/>
       <p style="background-color:burlywood; font-family: Harlow Solid Italic, Times, serif; font-size: 30px;">Staff Management</p>
     </center>
       <% String message = request.getAttribute("message") == null ? "" : request.getAttribute("message").toString();
            System.out.println("message:" + message);%>
        <%if (message != null) {%>
        <p><font color="red" face="verdana" size="3"/><%=message%></p>  </font>
            <%}%>
        <%
            
            
                List<Staff> staffList = new ArrayList<Staff>();
                //staffList = (List<Staff>) request.getAttribute("bookedList");
               
       
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection con = null;
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "HOTEL", "hotel");
         
        PreparedStatement ps= null;
        ResultSet rs=null;
        String s="select STAFFID,FIRSTNAME,LASTNAME,GENDER,CONTACTNO from STAFF";
        ps=con.prepareStatement(s);
        rs=ps.executeQuery();
        while(rs.next())
        {
            Staff staff=new Staff();
            staff.setStaffid(rs.getString(1));
             staff.setFirstname(rs.getString(2));
              staff.setLastname(rs.getString(3));
               staff.setGender(rs.getString(4));
                staff.setContactno(rs.getString(5));
                staffList.add(staff);
        }
        
        } catch (Exception e) {
            System.out.println("Exception in creating connection:" + e.getMessage());
            e.printStackTrace();
        }

        %>
        <h3 style="border:2px solid burlywood; " >Staff Details</h3>
        <table border="5" cellspacing="5" bgcolor="white" width="50%">
            <tr>
                <th>StaffID</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Gender</th>
                 <th>Contact no</th>
            </tr>
            <% for (Staff Obj : staffList) {%> 
            <tr>
                
                <td><%=Obj.getStaffid()%></td>
                <td><%=Obj.getFirstname()%></td>
                <td><%=Obj.getLastname()%></td>
                <td><%=Obj.getGender()%></td>
                <td><%=Obj.getContactno()%></td>
                <% }%>
            </tr>
        </table>
        
        <h3 style="border:2px solid burlywood; " >Add Staff</h3>
        <form action="addStaff" method="POST">  
            <table>
                <tr><td>Enter First name<td>:<td><input type="text" name="firstname" value= ""/>
                <tr><td>Enter Last name<td>:<td> <input type="text" name="lastname" value=""/>
                <tr><td>Enter Gender<td>:<td> Male<input type="radio" name="gender" value="Male" />
            Female<input type="radio" name="gender" value="Female" />
                <tr><td>Enter Contact no<td>:<td><input type="text" name="contactno" value=""/>
                <tr><td colspan="3"><input type="submit" value="Add Staff"/>  
            </table> 
        </form> <br/><br/>
        
        
        <h3 style="border:2px solid burlywood; " >Remove Staff</h3>
        <form action="removeStaff" method="POST">  
            <input type="hidden" name="phoneno" value="<%=request.getAttribute("phoneno")%>"/>
            <table>
                <tr><td>Enter Staff ID<td>:<td><input type="text" name="staffid" value= ""/>
            
                <tr><td colspan="3"> <input type="submit" value="Remove Staff"/>  
            </table>
        </form> <br/><br/><br/><br/>
        
    </body>
</html>
