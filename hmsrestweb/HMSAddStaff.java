/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hmsrestweb;

import com.mycompany.controller.StaffController;
import com.mycompany.pojo.StaffPojo;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ritu
 * This Service add staff registration data of doctor and nurse into database .
 */
@Path("/HMSStaff")
public class HMSAddStaff {
    //this method add general information of staff
 @POST
 @Path("/AddDoctor")
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
      public Response Reg(@FormParam("name") String name, @FormParam("gender") String gender,
            @FormParam("ms") String marrital_status, @FormParam("dob") String dob, @FormParam("address") String address,
            @FormParam("phone_no") long phone_no, @FormParam("dept") String dept, @FormParam("email") String email,
            @FormParam("pwd") String pwd)
    {
       System.out.println("hiiibh");
       String username= Register(name,gender,marrital_status,dob,address,phone_no,dept,email,pwd);  
        System.out.println("hiiibhbjhj222");
        try {
            java.net.URI location = new java.net.URI("http://localhost:8080/HMS/HMSAdmin/add_academicinfo.jsp?uname="+username+"");
            return Response.temporaryRedirect(location).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(BedRestWeb.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
      
      //this method add acadamic information of staff
    @POST
    @Path("/AddDoctorAcadamic/{uname}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
      public Response registeracadamic(@PathParam("uname") String name,@FormParam("qua") String qua, @FormParam("uniname") String uniname,
            @FormParam("msub") String msub, @FormParam("osub") String osub, @FormParam("py") int passingYear)
    {
       System.out.println(name);
        RegisterDoctorinfo(name,qua,uniname,msub,osub,passingYear);  
        System.out.println("hiiibhbjhj222");
        try {
            java.net.URI location = new java.net.URI("http://localhost:8080/HMS/DashboardController?flag=a");
            return Response.temporaryRedirect(location).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(BedRestWeb.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

       
    }
        public static String Register( String name, String gender,String marrital_status, String dob, String address, long phone_no,
               String dept,  String email, String pwd) 
    {
             String flag = null;
                try 
                 {
                     StaffPojo obj= new StaffPojo();
                     obj.setName(name);
                     obj.setGender(gender);
                     obj.setMarrital_status(marrital_status);
                     obj.setDob(dob);
                     obj.setAddress(address);
                     obj.setPhone_no(phone_no);
                     obj.setDept(dept);
                     obj.setEmail(email);
                     obj.setPwd(pwd);
                     StaffController object=new StaffController();
                     flag=object.insertDoctor(obj);
                      System.out.print(flag);
            //return flag;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
        
    }
       
    public static void RegisterDoctorinfo( String name, String qua,String uniname, String msub, String osub, int passingyear)
    {
             String flag = null;
                try 
                 {
                     StaffPojo obj= new StaffPojo();
                     obj.setName(name);
                     obj.setQualification(qua);
                     obj.setUniname(uniname);
                     obj.setMainSub(msub);
                     obj.setOtherSub(osub);
                     obj.setPassingYear(passingyear);
                     
                     StaffController object=new StaffController();
                     flag=object.insertDoctorinfo(obj);
                      System.out.print(flag);
            //return flag;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        
    }





  
      
}
