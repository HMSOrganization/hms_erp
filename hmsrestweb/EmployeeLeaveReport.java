/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hmsrestweb;
import com.mycompany.dao.EmployeeLeaveReportDAO;
import com.mycompany.pojo.EmployeeLeaveReportPOJO;
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
@Path("/leaveReport")
public class EmployeeLeaveReport {
    @POST
    @Path("/Add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addLaveType(@FormParam("category")String category,
            @FormParam("employeename")String employeename,
            @FormParam("leavename")String leavename,
            @FormParam("leavetype")String leavetype,
            @FormParam("requestdate")String requestdate,
            @FormParam("leavefrom")String leavefrom,
            @FormParam("leavetill")String leavetill,
            @FormParam("openbalance")int openbalance,
            @FormParam("totalleavedate")int totalleavedate,
             @FormParam("closingbalance")int closingbalance,
            @FormParam("approvedon")String approvedon,
            @FormParam("approvedby")String approvedby){
        java.net.URI location = null;
        try {
            //System.out.println("duration");
            EmployeeLeaveReportPOJO leave = new EmployeeLeaveReportPOJO();
            leave.setCategory(category);
            leave.setEmployeename(employeename);
            leave.setLeavename(leavename);
            leave.setLeavetype(leavetype);
            leave.setRequestdate(requestdate);
            leave.setLeavefrom(leavefrom);
            leave.setLeavetill(leavetill);
            leave.setOpenbalance(openbalance);
            leave.setTotalleavedate(totalleavedate);
            leave.setClosingbalance(closingbalance);
            leave.setApprovedon(approvedon);
            leave.setApprovedby(approvedby);
            
            EmployeeLeaveReportDAO leaveDAO = new EmployeeLeaveReportDAO();
            leaveDAO.insertLeave(leave);
            location = new java.net.URI("http://localhost:8082/Hospital_Management_System/HMSAdmin/employeeleavereport.jsp");
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(LeaveType.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.temporaryRedirect(location).build();
    }
    
    @GET
    @Path("/Add")
    public String Test(){
        return "Got here";
    }
    
}
