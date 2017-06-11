
package com.mycompany.controller;

import com.mycompany.dao.StaffDao;
import com.mycompany.dao.DataConnect;
import com.mycompany.pojo.StaffPojo;
import java.sql.Connection;

/**
 *
 * @author Ritu
 * 
 */
public class StaffController {
    String status = null;

    public String insertDoctor(StaffPojo pojo) throws Exception
    {
        try
        {
            DataConnect database = new DataConnect();
            Connection connection = database.getConnect();
            //create a object of dao class
            StaffDao daoObj = new StaffDao();
            //calling a method of dao class to add user with a connection and pojo object
           status= daoObj.adddoctor(connection, pojo);
            //done will returned by dao here in ststus.....
            //it will return status to webservice
          return status;

        } catch (Exception e) 
        {
            System.out.println("cccc" + e.getMessage());
            return null;
        }

    }
     public String insertDoctorinfo(StaffPojo pojo) throws Exception
    {
        try
        {
            DataConnect database = new DataConnect();
            Connection connection = database.getConnect();
            //create a object of dao class
            StaffDao daoObj = new StaffDao();
            //calling a method of dao class to add user with a connection and pojo object
           status= daoObj.adddoctorinfo(connection, pojo);
            //done will returned by dao here in ststus.....
            //it will return status to webservice
          return status;

        } catch (Exception e) 
        {
            System.out.println("cccc" + e.getMessage());
            return null;
        }

      
    }
    
}
