<%--
  Created by IntelliJ IDEA.
  User: 静召
  Date: 2020/2/3
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>

    <meta charset="utf-8" />

    <title></title>

</head>

<body>


<h1>${user_name},您的收藏夹</h1>
<table border="1">
    <tr>

        <th>商品名</th>

        <th>图片</th>

        <th>描述</th>

        <th>收藏人数</th>

        <th>删除</th>

    </tr>




    <c:forEach items="${ls}" var="d" varStatus="st">

        <tr>
            <td>${d.goods_name}</td>
            <td>${d.goods_pic}</td>
            <td>${d.goods_des}</td>
            <td>${d.col_num}</td>
            <td>
                <a href="/collect/delete?colId=${d.col_ID}">删除</a>
            </td>

        </tr>

    </c:forEach>

</table>



</body>

</html>