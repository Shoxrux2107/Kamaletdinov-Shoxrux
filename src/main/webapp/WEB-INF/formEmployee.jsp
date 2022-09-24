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
    <title>Add employee</title>
</head>
<body>
<label for="name">Name</label>
<input name="name" type="text" id="name">
<hr>
<label for="email">Email</label>
<input name="email" type="text" id="email">
<hr>

<label for="biography">Biography</label>
<input name="biography" type="text" id="biography">
<hr>

<label for="profession">Profession</label>
<select name="profession_id" id="profession">
<c:forEach items="${prof}" var="list">
    <option value="${list.id}" >${list.name}</option>
</c:forEach>
</select>

<hr>

<label for="department">Profession</label>
<select name="profession_id" id="department">
    <c:forEach items="${depart}" var="listD">
        <option value="${listD.id}" >${listD.name}</option>
    </c:forEach>
</select>



<hr>
 <button type="submit"> Saqlash </button>

</body>
</html>
