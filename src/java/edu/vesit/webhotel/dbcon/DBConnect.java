/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vesit.webhotel.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class DBConnect {

    public Connection makeDBCon() {
        Connection con = null;
       
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "HOTEL", "hotel");
        } catch (Exception e) {
            System.out.println("Exception in creating connection:" + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}
