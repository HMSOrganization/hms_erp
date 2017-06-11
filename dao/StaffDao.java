
package com.mycompany.dao;

import com.mycompany.pojo.StaffPojo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Ritu
 * this class provide database connection and perform CRUD operations.
 */
public class StaffDao {
    
    //this method used to add general info of user
    public String adddoctor(Connection connection, StaffPojo pojoObj) 
    {
       String name = pojoObj.getName();
        String cat;
        Statement smt = null;
        ResultSet rst=null;
        try 
        {
          int id;
            int cat_id;
            String sqlid="select user_id,category_name from tbl_user where user_name='"+name+"'";
            Statement stmt=connection.createStatement();
            rst=stmt.executeQuery(sqlid);
            if(rst.next())
            {
               id=rst.getInt(1);
               
              cat=rst.getString(2);
               if(cat.equals("Doctor"))
               {
                  cat_id=2; 
               }
               else
               {
                   cat_id=3;
               }
            
            String gender= pojoObj.getGender();
            String ms=pojoObj.getMarrital_status();
            String dob=pojoObj.getDob();
            String add=pojoObj.getAddress();
            long phno=pojoObj.getPhone_no();
            String dept=pojoObj.getDept();
            String email=pojoObj.getEmail();
            String pwd=pojoObj.getPwd();
            
            String sql = "insert into tbl_staff_dr_nurse_registration(`user_id`,`category_id`,`name`,`gender`,`marital_status`,`date_of_birth`,`address`,`phone_no`,`department`,`email`,`password`) values ('" + id + "','" + cat_id+ "','" + name+ "','" + gender + "','" + ms + "','" + dob + "','" + add + "','" + phno + "','" + dept + "','" + email + "','" + pwd + "')";
            System.out.println(sql);
            smt = connection.createStatement();
            smt.executeUpdate(sql);
           
         
         }
        }
             catch (Exception e) 
             {
            System.out.println("ddd" + e.getMessage());
                 }
             return name;  
        
    }
    //this method is used to store acadamic information.
     public String adddoctorinfo(Connection connection, StaffPojo pojoObj) 
    {
      
        Statement smt = null;
        ResultSet rst=null;
        try 
        {
          
            String name = pojoObj.getName();
            String qua= pojoObj.getQualification();
            String uniname=pojoObj.getUniname();
            String msub=pojoObj.getMainSub();
            String osub=pojoObj.getOtherSub();
            int py=pojoObj.getPassingYear();
            
            
            String sql ="UPDATE `tbl_staff_dr_nurse_registration` SET `qualification` = '"+qua+"',`university_name` = '"+uniname+"',`main_subject` = '"+msub+"',`other_subject` = '"+osub+"',`passing_year` = '"+py+"' WHERE `name` ='"+name+"' ";
            System.out.println(sql);
            smt = connection.createStatement();
            smt.executeUpdate(sql);
          
         
         
        }
             catch (Exception e) 
             {
            System.out.println("ddd" + e.getMessage());
                 }
             return null;  
        
    }
   
    
    
}
