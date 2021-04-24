<%--
  Created by IntelliJ IDEA.
  User: 尽快发挥未来空间
  Date: 2021/4/5
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(request.getAttribute("message")!=null){
        out.println(request.getAttribute("message"));
    }
%>
<%
    //read cookies
    Cookie[] allcookies=request.getCookies(); //give all cookies
    String username="",password="",rememberMeVal="";
    if(allcookies!=null) {
        for (Cookie c:allcookies) {
            if (c.getName().equals("cUsername")){
                username = c.getValue();
            }
            if (c.getName().equals("cPassword")){
                password = c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    <table>
        <tr> <td>Username:</td> <td><input type="text" name="username" value="<%=username%>" required><br/></td></tr>
        <tr> <td>password:</td> <td><input type="password" name="password" value="<%=password%>" required minlength="8"><br/></td></tr>
        <tr> <td></td><td><input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1") ?"checked":""%>checked/>RememberMe</td> </tr>
        <tr> <td></td><td><input type="submit" value="Login"/></td>  </tr>
    </table>
</form>
<%@include file="footer.jsp"%>
