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

@WebServlet(urlPatterns = {"/UserAccessController"})
public class UserAccessController extends HttpServlet {

    List<UserPojo> upp = new ArrayList();
    //ServletContext sc=getServletContext();
    // String vname=(String)sc.getAttribute("name");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String vname = request.getParameter("uname");
        System.out.print("hello..." + vname);
        System.out.println("Calls Controller");
        String[] module = request.getParameterValues("mname");
        String[] form = request.getParameterValues("fname");

        DataConnect dcc = new DataConnect();

        Connection conn = dcc.getConnect();

        List<UserPojo> upp = new ArrayList();
        System.out.print(module.length);
        for (int i = 0; i < module.length; i++) {

            System.out.println(module[i]);
            
            UserPojo up = new UserPojo();
            up.setModulename(module[i]);
            up.setUsername(vname);
            upp.add(up);

        }
          
        List<UserPojo> updatedForm = new ArrayList();
        System.out.print(form.length);
        for (int i = 0; i < form.length; i++) {

            System.out.println(form[i]);
            
            UserPojo up = new UserPojo();
            up.setFormname(form[i]);
            up.setUsername(vname);
            updatedForm.add(up);

        }
        
        userModuleMapDao.addUpdatedModule(upp);
        userModuleMapDao.addUpdatedForm(updatedForm);
        response.sendRedirect(request.getContextPath() + "/HMSAdmin/dashboard_admin.jsp");
        
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
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserAccessController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
