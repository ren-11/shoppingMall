<%--
  Created by IntelliJ IDEA.
  User: 静召
  Date: 2020/2/3
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.xzy.model.*"%>
<%@ page import="com.xzy.model.CollectMap" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>

<head>

    <meta charset="utf-8" />

    <title></title>

</head>

<body>
<%!
    private PageDiv<CollectMap> pd;
%>
<%= pd=(PageDiv<CollectMap>)request.getAttribute("pd")%>

<h1>${user_name},您的收藏夹</h1>
<table border="1">
    <tr>

        <th>商品名</th>

        <th>图片</th>

        <th>描述</th>

        <th>收藏人数</th>

        <th>删除</th>

    </tr>


    <c:forEach items="<%=pd.getList()%>" var="d" varStatus="st">

        <tr>
            <td>${d.goods_name}</td>
            <td>${d.goods_pic}</td>
            <td>${d.goods_des}</td>
            <td>${d.col_num}</td>
            <td>
                <a href="/collect/delete?col_ID=${d.col_ID}">删除</a>
            </td>

        </tr>

    </c:forEach>

</table>

<div>
    <div class="pull-left">
        <nav>
            <ul class="pagination">
                <li>
                    <a href="pagelist?pageNo=<%=pd.getPageNo()-1<=1?1:pd.getPageNo()-1 %>" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <%
                    for(int i=pd.getStart();i<=pd.getEnd();i++)
                    {
                %>
                <li><a href="pagelist?pageNo=<%=i%>"><%=i %></a></li>
                <%
                    }
                %>
                <li>
                    <a href="pagelist?pageNo=<%=pd.getPageNo()+1>=pd.getTotalPage()?pd.getTotalPage():pd.getPageNo()+1 %>" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="pull-right">
        当前<%=pd.getPageNo() %>/<%=pd.getTotalPage() %>页，总共<%=pd.getTotalCount() %>条
    </div>
</div>
<%@include file="booter2.jsp" %>
<!--结束-->
</body>

</html>