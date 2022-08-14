<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/12/2022
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%@include file="base.jsp"%>
</head>
<body>
<h1 class="text-center mb-3">UPDATE USER</h1>
<form action="/update" method="post">
    <input type="hidden" name="id" value="${user.id}"/>
    <label>FIRST NAME:</label>
    <input type="text" name="firstname" value="${user.firstname}"/>
    <br>
    <label>LAST NAME:</label>
    <input type="text" name="lastname" value="${user.lastname}"/>
    <br>
    <label>PHONE NUMBER:</label>
    <input type="text" name="phonenumber" value="${user.phonenumber}"/>
    <br>
    <button type="submit" class="btn btn-outline-warning">UPDATE</button>
    <a href="/" class="btn btn-outline-danger">BACK</a>
</form>
</body>
</html>
