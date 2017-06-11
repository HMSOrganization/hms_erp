
package com.mycompany.dao;

import java.sql.*;

public class DataConnect {
     Connection con=null;
    public Connection getConnect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e)
        {
            System.out.println("driver error");
        }
        
        
        try
        {
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","");
           return con;
        }catch(Exception e)
        {
            System.out.println("driver error");
        }
        return con;
    }
    
}
