/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.pojo.BedPojo;
import com.mycompany.dao.BedDao;
import com.mycompany.dao.DataConnect;
import java.sql.Connection;

/**
 *
 * @author Ritu
 */
public class BedController {
     String status = null;

    public String insertbed(BedPojo pojo) throws Exception
    {
        try
        {
            DataConnect database = new DataConnect();
            Connection connection = database.getConnect();
            //create a object of dao class
            BedDao daoObj = new BedDao();
            //calling a method of dao class to add user with a connection and pojo object
           status= daoObj.addbed(connection, pojo);
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
