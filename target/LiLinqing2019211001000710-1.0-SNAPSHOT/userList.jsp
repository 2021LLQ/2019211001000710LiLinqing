<%@ page import="javax.naming.spi.DirStateFactory" %>
<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: 尽快发挥未来空间
  Date: 2021/4/11
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<h1>User List</h1>
<table border=1>
    <tr><td>ID</td><td>username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthdate</td></tr>
    <%
        ResultSet rs= (ResultSet) request.getAttribute("rsname");
        if(rs==null){
    %>
    <tr><td>No Data !!!</td></tr>
    <%}else{
        while(rs.next()){
            int id=rs.getInt("id");
            String Username=rs.getString("username");
            String Password1=rs.getString("password");
            String Email=rs.getString("email");
            String Gender=rs.getString("gender");
            String Birthdate=rs.getString("birthdate");

            out.println("<tr><td>"+id+"</td><td>"+Username+"</td><td>"+Password1+"</td><td>"+Email+"</td><td>"+Gender+"</td><td>"+Birthdate+"</td></tr>");}
    }
    %>
</table>
<%@include file="footer.jsp"%>
