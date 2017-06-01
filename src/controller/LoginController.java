/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String username = request.getParameter("uname");
            String password = request.getParameter("password");
            System.out.println(username);
            System.out.println(password);
            if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {

                response.sendRedirect(request.getContextPath() + "/HMSAdmin/dashboard_admin.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/HMSAdmin/common_dashboard.jsp");
            }

        } catch (Exception e) {
            System.out.println("errrorrr" + e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
          processRequest(request, response);  
        }
        catch(Exception e)
        {
            System.out.println("caught here !");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
          processRequest(request, response);  
        }
        catch(Exception e)
        {
            System.out.println("caught here !");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
