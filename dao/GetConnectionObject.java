package com.mycompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER-PC
 */
public class GetConnectionObject {
    
    Connection con;
    private  final String URL="jdbc:mysql://localhost:";
    private  final String DATABASENAME="hospital_management";
    private  final String PORT="3306";
    private  final String DRIVER="com.mysql.jdbc.Driver";
    private  final String UNAME="root";
    private  final String UPASS="";

    public  Connection getConnectionObject() throws SQLException{
        try {
            Class.forName(DRIVER);
            con=DriverManager.getConnection(URL+PORT+"/"+DATABASENAME,UNAME,UPASS);
            return con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetConnectionObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
