/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hmsrestweb;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.mycompany.controller.BedController;
import com.mycompany.dao.BedDao;
import com.mycompany.dao.DataConnect;
import com.mycompany.pojo.BedPojo;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/HMSAddBed")
public class BedRestWeb 
{
    @POST
//@Path("/regbed") 
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
      public Response register(@FormParam("bed_number") int bedno, @FormParam("type") String bedtype,
            @FormParam("des") String desc)
    {
       System.out.println("hiiibh");
        RegisterBed(bedno, bedtype, desc);  
        System.out.println("hiiibhbjhj222");
        try {
            java.net.URI location = new java.net.URI("http://localhost:8080/HMSystems/HMSAdmin/add_officialinfo.jsp");
            return Response.temporaryRedirect(location).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(BedRestWeb.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

       
    }
      
      @GET
      @Produces(MediaType.TEXT_PLAIN)
      public String yooo()
      {
          return "yoooooooooo";
      }
      
      
      
       public static void RegisterBed(int bedno, String bedtype, String desc) 
    {
             String flag = null;
                try 
                 {
                     BedPojo obj= new BedPojo();
                     obj.setBedid(bedno);
                     obj.setBedtype(bedtype);
                     obj.setDesc(desc);
                     
                     BedController object=new BedController();
                     flag=object.insertbed(obj);
                      System.out.print(flag);
            //return flag;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
       // return flag;
        
    }
}
