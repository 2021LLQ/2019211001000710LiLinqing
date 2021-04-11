<%--
  Created by IntelliJ IDEA.
  User: 尽快发挥未来空间
  Date: 2021/3/22
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
<form method="post" action="register">
    <span style="color: #FFA500"> New User Registration</span><br/><br/>
    <span style="color:#FFA500">Username</span> <input type="text" name="username" required="true" style="background-color: #EAEAAE"><br/><br/>
    <span style="color: #FFA500">Password</span> <input type="password" name="password" maxlength="8" style="background-color: #EAEAAE"><br/><br/>
    <span style="color: #FFA500">Email</span><input type="email" name="email" required="true"style="background-color: #EAEAAE"><br/><br/>
    <span style="color: #FFA500">Gender</span>
    <label for="1">
        <input type="radio" name="gender" value="male" id="1"/> <span style="color: #D2B48C">Male</span>
    </label>

    <label for="2">
        <input type="radio" name="gender" value="female" id="2"/> <span style="color: #D2B48C">Female</span>
    </label>
    <br/><br/>
    <span style="color: #FFA500">Date of birth(yyyy-mm-dd)</span><input type="date"name="birthdate"  pattern="yyyy-mm-dd" required="true"style="background-color: #EAEAAE"><br/><br/>
    <input type="submit" value="register"style="background-color: #EAEAAE">
</form>
<%@include file="footer.jsp"%>