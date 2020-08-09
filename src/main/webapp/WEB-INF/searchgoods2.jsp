<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <td>name</td>
        <td>价格</td>
        <td>描述</td>
        <td>商家</td>
        <td>图片</td>
    </tr>
    <c:forEach items="${goodslist}" var="c" varStatus="user1">
        <tr>
            <td>${c.goodsId}</td>
            <td>${c.goodsName}</td>
            <td>${c.goodsPrice}</td>
            <td>${c.goodsDes}</td>
            <td>${c.seller_name}</td>
        </tr>
    </c:forEach>
</table>
<a href="/goods/searchkey">搜索记录</a>
<a href="/goods/searchkeydel">清除搜索记录</a>

<%--分页显示--%>
<div style="text-align:center">
    <a href="?start=0">首页</a>
    <a href="?start=${page.start-page.count<0?0:page.start-page.count}">上一页</a>
    <a href="?start=${page.start+page.count>page.end?page.end:page.start+page.count }">下一页</a>
    <a href="?start=${page.end}">末页</a>
</div>


</body>
</html>
