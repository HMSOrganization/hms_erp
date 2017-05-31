/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Pojo.FormPojo;
import Pojo.UserPojo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ritu
 */
public class userModuleMapDao {

    public static void addModule(List<UserPojo> object) throws IOException, SQLException {

        //preparing some objects for connection 
        // "System.out.println" prints in the console; Normally used to trace the process
        int user_id;
        DataConnect dc = new DataConnect();
        Connection con = dc.getConnect();
        Statement stmt = null;
        ResultSet rst = null;
        int id;
        stmt = con.createStatement();
        String uname = object.get(0).getUsername();
        System.out.println("Username :: " + uname);
        String queryid = "select user_id from tbl_user where user_name=" + uname + "";
        if (rst.next()) {
            user_id = rst.getInt(1);
            List fname = new ArrayList();

            for (int i = 0; object != null; i++) {
                UserPojo mname = object.get(i);
                String query = "select module_id from tbl_modules where module_name=" + mname + "";
                if (rst.next()) {
                    id = rst.getInt(1);
                    String queryText = "INSERT INTO user_module_mapping(user_id,module_id) VALUES('" + user_id + "','" + id + "')";
                }

            }
        }

        
    }
}
