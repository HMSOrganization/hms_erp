/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Pojo.UserPojo;
import dao.DataConnect;
import dao.moduleMapDao;
import dao.userModuleMapDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

/**
 *
 * @author Ritu
 */

public class UserAccessController extends HttpServlet {
 List<UserPojo> upp = new ArrayList();
     ServletContext sc=getServletContext();
       String vname=(String)sc.getAttribute("name");
        
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.print(vname);
        System.out.println("Calls Controller");
          String []module = request.getParameterValues("mname");
       
        System.out.print(module.length);
         for(int i = 0;i<module.length;i++)
        {
           
                 System.out.println(module[i]);
            
           
        }
        
        
       System.out.println("Username : "+vname);
     
        
                DataConnect dcc = new DataConnect();

                Connection conn = dcc.getConnect();

              List<UserPojo> upp= new ArrayList();
             
               UserPojo up=new UserPojo();
               up.setUsername(vname);
               upp.add(up);
                userModuleMapDao.addModule(upp);
              //  search(request, response);
                  response.sendRedirect(request.getContextPath() + "/HMSAdmin/dashboard_admin.jsp");
        //response.sendRedirect("");
    }
     
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserAccessController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }

    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserAccessController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    
}

  
