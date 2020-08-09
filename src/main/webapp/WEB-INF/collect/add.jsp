<%--
  Created by IntelliJ IDEA.
  User: 静召
  Date: 2020/2/4
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>

    <meta charset="UTF-8">

    <title>添加页面</title>

</head>

<body>



<form method="post" action="/collect/add">
    <table border="1">
        <tr>

            <td>商品id</td>

            <td>

                <input type="text" name="goods_id" />

            </td>

        </tr>

        <tr>

            <td>收藏人数</td>

            <td>

                <input type="text" name="col_num" />

            </td>

        </tr>
        <tr>

            <td>收藏号</td>

            <td>

                <input type="text" name="col_ID" />

            </td>

        </tr>

        <tr>

            <td>用户id</td>

            <td>

                <input type="text" name="user_ID" />

            </td>

        </tr>

        <tr>
            <td>

                <input type="submit" value="提交" />

            </td>
            <td>

                <a href="/collect/list">返回</a>
            </td>


        </tr>





    </table>



</form>

</body>

</html>

