/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hmsrestweb;

import com.mycompany.dao.LeaveTypeDAO;
import com.mycompany.pojo.LeaveTypePOJO;
import java.awt.PageAttributes;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ACER-PC
 */
@Path("/leaveType")
public class LeaveType {
    @POST
    @Path("/Add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addLaveType(@FormParam("category")String category,
            @FormParam("leavetype")String leavetype,
            @FormParam("leaveno")int leaveno,
            @FormParam("duration")String duration){
        java.net.URI location = null;
        try {
            System.out.println("duration");
            LeaveTypePOJO leave = new LeaveTypePOJO();
            leave.setCategory(category);
            leave.setLeavetype(leavetype);
            leave.setLeaveno(leaveno);
            leave.setDuration(duration);
            
            LeaveTypeDAO leaveDAO = new LeaveTypeDAO();
            leaveDAO.insertLeave(leave);
            location = new java.net.URI("http://localhost:8082/Hospital_Management_System/HMSAdmin/leaveType.jsp");
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(LeaveType.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.temporaryRedirect(location).build();
    }
    
    @GET
    @Path("/Here")
    public String Test(){
        return "Got here";
    }
    
}
