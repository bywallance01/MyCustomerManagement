<%--
  Created by IntelliJ IDEA.
  User: Wallance
  Date: 2017/7/8
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base target="main"/>
    <title>top</title>
</head>
<body style="text-align: center">
 <h1>客户信息管理系统</h1>
 <a href="<c:url value='/add.jsp'/>">添加客户</a>
 <a href="<c:url value='/CustomerServlet?method=findAll'/>">查询客户</a>
 <a href="<c:url value='/query.jsp'/>">搜索客户</a>
</body>
</html>
