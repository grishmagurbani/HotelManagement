/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.dao;

import edu.vesit.webhotel.dbcon.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class loginDAO {
    
    public boolean validateLogin(String username,String password){
        boolean status=false;
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;          
        
        DBConnect dbcon = new DBConnect();
        try{
            con = dbcon.makeDBCon();
            String sql="select * from LOGIN where USERID='"+username+"' and PASSWD='"+password+"'";
            System.out.println(sql);
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
           if(rs.next())
           {
              status=true;
           }
                     
        }
        catch(Exception e)
        {
            System.out.println("exception is "+e);
        }
        
        return status;
    }
    
}
