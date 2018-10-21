<%--
  Created by IntelliJ IDEA.
  Date: 2018/10/18
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>编号</td>
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>生日</td>
    </tr>
    <c:forEach items="${students}" var="s" varStatus="st">
        <tr>
            <td>${s.id}</td>
            <td>${s.student_id}</td>
            <td>${s.name}</td>
            <td>${s.age}</td>
            <td>${s.sex}</td>
            <td>${s.birthday}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
