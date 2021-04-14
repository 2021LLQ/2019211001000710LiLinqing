package com.LiLinqing.week5.demo;

import com.LiLinqing.dao.UserDao;
import com.LiLinqing.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con, username, password);

            if (user != null) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }

        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}
        /*String sql="select * from usertable where username=? and password=?";
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs= pstmt.executeQuery();
            PrintWriter out=response.getWriter();
            if(rs.next()){

                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getDate("birthdate"));
                request.getRequestDispatcher("userinfo.jsp").forward(request,response);
            }else {

                request.setAttribute("message","Username or password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/
