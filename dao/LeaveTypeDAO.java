package com.mycompany.dao;

import com.mycompany.pojo.LeaveTypePOJO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER-PC
 */
public class LeaveTypeDAO {
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
    
    public int insertLeave(LeaveTypePOJO leave){
        int status=0;
        try {
            con=ob.getConnectionObject();
            String query="insert into leave_type(`category`,`leavetype`,`leaveno`,`duration`) values('"+leave.getCategory()+"','"+leave.getLeavetype()+"','"+leave.getLeaveno()+"','"+leave.getDuration()+"')";
            stm = con.createStatement();
            status = stm.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(LeaveTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    } 
}
