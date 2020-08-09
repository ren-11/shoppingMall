<%--
  Created by IntelliJ IDEA.
  User: 姚文
  Date: 2020/2/7
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="text-align: center">
        <form action="${pageContext.request.contextPath}/user/sendloginMsg" method="post" >
            手机号:<input type="text" name="phone"/><br/>
            <input type="submit" value="获取验证码"/><br/>
            验证码:<input type="text" name="code"/><br/>
            <input type="submit" value="登录"/><br/>

        </form>
        <form action="${pageContext.request.contextPath}/user/login" method="post">
            手机号:<input type="text" name="phone"/><br/>
            验证码:<input type="text" name="code"/><br/>
            <input type="submit" value="登录"/><br/>

            <a href="${pageContext.request.contextPath}/user/toRegister">新用户？点这注册新账户</a>
            <a href="${pageContext.request.contextPath}/user/toForGetPwd">忘记密码</a><br/>
            <a href="${pageContext.request.contextPath}/user/toPwdLogin">密码登录</a>
        </form>
    </div>
</body>
</html>
