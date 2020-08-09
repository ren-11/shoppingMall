<%--
  Created by IntelliJ IDEA.
  User: 姚文
  Date: 2020/2/8
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="text-align: center">
        <form  action="${pageContext.request.contextPath}/user/sendpwdMsg" method="post">
            <p>注册电话：<input type="tel" name="phone"/></p>
            <p>验证码：<input type="text" name="code"/></p>
            <p>新密码<input type="password" name="user_pwd"></p>
            <p><input type="submit" value="发送验证码"/></p>
        </form>


        <form  action="${pageContext.request.contextPath}/user/ForGetPwd" method="post">
            <p>注册电话：<input type="tel" name="phone"/></p>
            <p>验证码：<input type="text" name="code"/></p>
            <p>新密码<input type="password" name="user_pwd"></p>
            <p><input type="submit" value="修改密码"/></p>
        </form>

        <h3>msg: ${requestScope.msg}!</h3>

    </div>

</body>
</html>
