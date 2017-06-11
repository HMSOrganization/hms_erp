
package com.mycompany.dao;
import java.sql.*;
import com.mycompany.pojo.BedPojo;
public class BedDao {
     public String addbed(Connection connection, BedPojo pojoObj) 
    {
       
        Statement smt = null;

        try 
        {

            int id = pojoObj.getBedid();
            String type = pojoObj.getBedtype();
            String desc= pojoObj.getDesc();
            String sql = "insert into user_bed(`id`,`type`,`desc`) values ('" + id + "','" + type + "','" + desc + "')";
            System.out.println(sql);
            smt = connection.createStatement();
            int status = smt.executeUpdate(sql);
           if(status==1)
           {
               return "done";
           }
         
        }
        catch (Exception e) 
        {
            System.out.println("ddd" + e.getMessage());
        }
     return "done";       
    }
    
}
