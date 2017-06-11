/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;
import com.mycompany.pojo.EmployeeLeaveReportPOJO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ACER-PC
 */
public class EmployeeLeaveReportDAO {
     GetConnectionObject ob = new GetConnectionObject();
    Connection con=null;
    Statement stm=null;
//
//    public LeaveTypeDAO() {
//        try {
//            this.con = ob.getConnectionObject();
//        } catch (SQLException ex) {
//            Logger.getLogger(LeaveTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public int insertLeave(EmployeeLeaveReportPOJO leave){
        int status=0;
        try {
            con=ob.getConnectionObject();
            String query="insert into leave_report(`category`,`employeename`,`leavename`,`leavetype`,`requestdate`,`leavefrom`,`leavetill`,`openbalance`,`totalleavedate`,`closingbalance`,`approvedon`,`approvedby`) values('"+leave.getCategory()+"','"+leave.getEmployeename()+"','"+leave.getLeavename()+"','"+leave.getLeavetype()+"','"+leave.getRequestdate()+"','"+leave.getLeavefrom()+"','"+leave.getLeavetill()+"','"+leave.getOpenbalance()+"','"+leave.getTotalleavedate()+"','"+leave.getClosingbalance()+"','"+leave.getApprovedon()+"','"+leave.getApprovedby()+"')";
            stm = con.createStatement();
            status = stm.executeUpdate(query);
            System.out.println("Status"+status);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeLeaveReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    } 
}

