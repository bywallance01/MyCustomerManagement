<%--
  Created by IntelliJ IDEA.
  User: Wallance
  Date: 2017/7/8
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
   <h3 align="center">查询客户</h3>
   <form action="<c:url value='/CustomerServlet'/>" method="get">
       <input type="hidden" name="method" value="query">
       <table border="0" align="center" width="40%" style="margin-left: 100px">
           <tr>
               <td width="100px">客户名称</td>
               <td id="40%">
                   <input type="text" name="name"/>
               </td>
           </tr>
           <tr>
               <td>客户性别</td>
               <td>
                   <select name="gender">
                       <option value="male">男</option>
                       <option value="female">女</option>
                   </select>
               </td>
           </tr>
           <tr>
               <td>手机号码</td>
               <td>
                   <input type="text" name="phone"/>
               </td>
           </tr>
           <tr>
               <td>邮箱</td>
               <td>
                   <input type="text" name="email"/>
               </td>
           </tr>
           <tr>
               <td>&nbsp;</td>
               <td>
                   <input type="submit" value="查找"/>
                   <input type="reset" value="重置" />
               </td>
           </tr>
       </table>
   </form>
</body>
</html>
