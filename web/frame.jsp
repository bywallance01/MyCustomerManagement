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
    <title>主页</title>
</head>
<frameset rows="20%,*">
    <frame src="<c:url value='/top.jsp'/>" name="top">
    <frame src="<c:url value='/welcome.jsp'/>" name = "main">
</frameset>
</html>
