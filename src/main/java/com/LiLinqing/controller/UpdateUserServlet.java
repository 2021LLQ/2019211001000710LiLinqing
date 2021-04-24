package com.LiLinqing.controller;

import com.LiLinqing.dao.UserDao;
import com.LiLinqing.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 1:forward to WEB-INF/views/updateUser.jsp
        //TODO 2:create one jsp page - update user
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }
    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Id= Integer.parseInt(request.getParameter("Id"));
        String Username=request.getParameter("Username");
        String password=request.getParameter("password");
        String Email=request.getParameter("Email");
        String Gender=request.getParameter("Gender");
        String  Birthdate=request.getParameter("Birthdate");
        User user=new User();
        user.setId(Id);
        user.setUsername(Username);
        user.setPassword(password);
        user.setEmail(Email);
        user.setGender(Gender);
        user.setBirthdate(Birthdate);
        UserDao userDao=new UserDao();
        try {
            userDao.updateUser(con,user);
            HttpSession session=request.getSession();
            session.setMaxInactiveInterval(10);
            session.setAttribute("user",user);
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Id= Integer.parseInt(request.getParameter("id"));
        String Username=request.getParameter("username");
        String password=request.getParameter("password");
        String Email=request.getParameter("email");
        String Gender=request.getParameter("gender");
        String Birthdate=request.getParameter("birthdate");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        User user=new User();
        user.setId(Id);
        user.setUsername(Username);
        user.setPassword(password);
        user.setEmail(Email);
        user.setGender(Gender);
        user.setBirthdate(Birthdate);
        UserDao userDao=new UserDao();
        Connection con = (Connection) getServletContext().getAttribute("con");
        try {
            if(userDao.updateUser(con,user)!=0) {
                User user1=userDao.findByUsernamePassword(con,Username,password);
                HttpSession session=request.getSession();
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user1);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
}
