<%--
  Created by IntelliJ IDEA.
  User: 姚文
  Date: 2020/2/8
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="text-align: center">
        <form  action="${pageContext.request.contextPath}/user/sendRegisterMsg" method="post">
            <p>用户名：<input type="text" name="user_name"/></p>
            <p>邮箱：<input type="email" name="email"></p>
            <p>注册电话：<input type="tel" name="phone"/></p>
            <p>验证码：<input type="text" name="code"></p>
            <p><input type="submit" value="发送注册码"/></p>
        </form>

        <form  action="${pageContext.request.contextPath}/user/Register" method="post">
            <p>用户名：<input type="text" name="user_name"/></p>
            <p>邮箱：<input type="email" name="email"></p>
            <p>密码：<input type="password" name="user_pwd"></p>
            <p>注册电话：<input type="tel" name="phone"/></p>
            <p>验证码：<input type="text" name="code"></p>
            <p>用户生日：<input type="date" name="user_birth"></p>
            <p>用户姓名：<input type="text" name="user_real_name"></p>
            <p>性别： 男<input type="radio" name="user_sex" value="M" checked>女<input type="radio" name="user_sex" value="F"></p>
            <p><input type="submit" value="注册"/></p>
        </form>

        <h3>msg: ${requestScope.msg}!</h3>

    </div>
</body>
</html>
