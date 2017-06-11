/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;
import com.mycompany.pojo.StaffPojo;
import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
     private static Map<Integer,StaffPojo >Profiles = new HashMap<>();
   
    public static Map<Integer, StaffPojo> getProfiles()
    {
        return Profiles;
    }
    
}
