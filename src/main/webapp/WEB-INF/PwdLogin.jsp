<%--
  Created by IntelliJ IDEA.
  User: 姚文
  Date: 2020/2/7
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户密码登录页面</title>
</head>
<body>
    <div style="text-align: center;">
        <form action="${pageContext.request.contextPath}/user/PwdLogin" method="post">
            <p>用户名<input type="text" name="user_name"/></p>
            <p>密码<input type="password" name="user_pwd"/></p>
            <input type="submit" value="登录">
            <a href="${pageContext.request.contextPath}/user/toRegister">新用户？点这注册新账户</a>
            <a href="${pageContext.request.contextPath}/user/toForGetPwd">忘记密码</a><br/>
            <a href="${pageContext.request.contextPath}/user/toLogin">验证码登录</a>
        </form>

    </div>
</body>
</html>
