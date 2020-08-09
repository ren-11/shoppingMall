<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
//查询显示
<table align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>goods_id</td>
        <td>图片</td>
    </tr>
    <c:forEach items="${lunbotulist}" var="c" varStatus="user1">
        <tr>
            <td>${c.bigpicId}</td>
            <td>${c.goodsId}</td>
            <td><img src="${c.bigpic}" ></td>
        </tr>
    </c:forEach>
</table>
