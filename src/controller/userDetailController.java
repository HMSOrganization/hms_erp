/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Pojo.ReportPojo;
import dao.moduleMapDao;
import Pojo.UserPojo;
import dao.DataConnect;
import dao.formMapDao;
import dao.ReportDao;
import dao.UserDao;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/userDetailController"})
public class userDetailController extends HttpServlet {

    UserPojo upp = new UserPojo();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String flag = request.getParameter("flag");
        System.out.println(flag + "-----------");
        String category = request.getParameter("cname");
        String password = request.getParameter("pass");
        String username = request.getParameter("name");
        if (flag.equalsIgnoreCase("insert")) {
            try {
                DataConnect dc = new DataConnect();

                Connection con = dc.getConnect();

                upp.setCategory(category);
                upp.setPassword(password);
                upp.setUname(username);
                UserDao.addUser(upp);
                searchModule(request, response);
                searchForm(request, response);
                searchReport(request, response);

            } catch (Exception e) {
                out.print("Connection error!" + e);
            }
            response.sendRedirect(request.getContextPath() + "/HMSAdmin/add_userAccess.jsp?uname=" + username + "");

            System.out.print(username);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ModuleController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void searchModule(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        List<UserPojo> listcheck = moduleMapDao.selectModule(upp);
        HttpSession session = request.getSession();
        session.setAttribute("listcheck", listcheck);
        System.out.println("Size---" + listcheck.size());
        List<UserPojo> listuncheck = moduleMapDao.UnselectModule(upp);
        HttpSession session1 = request.getSession();
        session1.setAttribute("listuncheck", listuncheck);

    }

    private void searchForm(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        List<UserPojo> listfcheck = formMapDao.selectForm(upp);
        HttpSession session1 = request.getSession();
        session1.setAttribute("listfcheck", listfcheck);
        List<UserPojo> listfuncheck = formMapDao.UnselectForm(upp);
        HttpSession session2 = request.getSession();
        session2.setAttribute("listfuncheck", listfuncheck);

    }

    private void searchReport(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        List<ReportPojo> list3 = ReportDao.viewReport();
        HttpSession session = request.getSession();
        session.setAttribute("list3", list3);
        System.out.println("Size---" + list3.size());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ModuleController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
