<%--
  Created by IntelliJ IDEA.
  User: 姚文
  Date: 2020/2/7
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="align-content: center">
        <h1>登录成功 ${requestScope.msg}!</h1>
        <h1>hello ${sessionScope.user.userName}!</h1>
    </div>
    <h1>多表联查获取商家信息</h1>
    <%--搜索--%>
    <form action="/goods/search2" method="post">
        搜索框：<input type="text" name="key">
        <input type="submit" value="搜索">
    </form>

    <br>

    <a href="/lunbotu">轮播图</a>
</body>
</html>
