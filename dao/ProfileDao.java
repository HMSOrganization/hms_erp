
package com.mycompany.dao;

import com.mycompany.dao.DatabaseClass;
import com.mycompany.pojo.StaffPojo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;

public class ProfileDao {
    //create a object of Database class to insert dynamic data through map
    private static Map<Integer,StaffPojo> profiles = DatabaseClass.getProfiles();
     public ProfileDao()
    {
           
    }
    
    public List<StaffPojo> getStaffProfile() 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","");
            Statement stmt = con.createStatement();
             String sql = "SELECT * from tbl_staff_dr_nurse_registration where name='Krishnakant'";
             System.out.println(sql);
             ResultSet rst = stmt.executeQuery(sql);
       
        if(rst.next())
        {
            profiles.put(1, new StaffPojo(rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getLong(8),rst.getString(9),rst.getString(10),rst.getString(11),rst.getString(12),rst.getString(13),rst.getString(14),rst.getString(15),rst.getInt(16)));
            System.out.println("ffffffffffffffffffffffff");
        }
      
        }
        catch(Exception e)
        {
                    System.out.println(e);
        }
        return new ArrayList<StaffPojo>(profiles.values());
    }
    
    
}
