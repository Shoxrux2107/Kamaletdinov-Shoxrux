<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/24/2022
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EmployeeList</title>
</head>
<body>
<a href="/emp/get-form">Add employee</a>

<c:forEach items="${listEmp}" var="list">
    <h1>${list.name}</h1>
    <h1>${list.email}</h1>
    <h1>${list.biography}</h1>
    <h1>${list.profession_id}</h1>
    <h1>${list.department_id}</h1>


    <a href="/emp/edit/${list.id}">Edit</a>
    <a href="/emp/delete/${list.id}">Delete</a>
</c:forEach>




</body>
</html>
