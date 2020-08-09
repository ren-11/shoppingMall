<%--
  Created by IntelliJ IDEA.
  User: Venus
  Date: 2020/2/17
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${requestScope.msg}</h1>
<h1>${sessionScope.user.userName}</h1>
<h1>${sessionScope.user.userEmail}</h1>
<h1>${sessionScope.user.userPic}</h1>
</body>
</html>
