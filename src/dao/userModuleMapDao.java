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

public class userModuleMapDao {

    public static void addUpdatedModule(List<UserPojo> object) throws IOException, SQLException {

        //preparing some objects for connection 
        // "System.out.println" prints in the console; Normally used to trace the process
        int user_id;
        DataConnect dc = new DataConnect();
        Connection con = dc.getConnect();
        Statement stmt = null;
        ResultSet rst = null;
        int id;
        stmt = con.createStatement();
        //UserPojo up = new UserPojo();
        //up.setUsername(vname);
        //String uname = up.getUname();
        String uname = object.get(0).getUsername();
        System.out.println("Username :: " + uname);
        String queryid = "select user_id from tbl_user where user_name='" + uname + "'";
        rst = stmt.executeQuery(queryid);
        System.out.println(queryid);
        if (rst.next()) {
            user_id = rst.getInt(1);
            //List fname = new ArrayList();

            for (int i = 0; i < object.size(); i++) {
                UserPojo pojoObj = object.get(i);
                String mname = pojoObj.getModulename();
                System.out.println("module name : " + mname);
                String query = "select module_id from tbl_modules where module_name='" + mname + "'";
                rst = stmt.executeQuery(query);
                System.out.println(query);
                if (rst.next()) {
                    id = rst.getInt(1);
                    String queryText = "INSERT INTO tbl_user_module_mapping(user_id,module_id) VALUES(" + user_id + "," + id + ")";
                    int result = stmt.executeUpdate(queryText);
                    System.out.println("querytext");
                    System.out.println("Data Inserted");

                }

            }
        }

    }

    public static void addUpdatedForm(List<UserPojo> object) throws IOException, SQLException {

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
        String queryid = "select user_id from tbl_user where user_name='" + uname + "'";
        rst = stmt.executeQuery(queryid);
        System.out.println(queryid);
        if (rst.next()) {
            user_id = rst.getInt(1);
            

            for (int i = 0; i < object.size(); i++) {
                UserPojo pojoObj = object.get(i);
                String fname = pojoObj.getFormname();
                System.out.println("module name : " + fname);
                String query = "select form_id from tbl_forms where form_name='" + fname + "'";
                rst = stmt.executeQuery(query);
                System.out.println(query);
                if (rst.next()) {
                    id = rst.getInt(1);
                    String queryText = "INSERT INTO tbl_user_form_mapping(user_id,form_id) VALUES(" + user_id + "," + id + ")";
                    int result = stmt.executeUpdate(queryText);
                    System.out.println("querytext");
                    System.out.println("Data Inserted");

                }

            }
        }

    }

    
}
