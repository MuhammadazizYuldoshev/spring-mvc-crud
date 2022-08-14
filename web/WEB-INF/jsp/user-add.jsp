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
<form action="/users" method="post">
    <label>FIRST NAME:</label>
    <input type="text" name="firstname"/>
    <br>
    <label>LAST NAME:</label>
    <input type="text" name="lastname"/>
    <br>
    <label>PHONE NUMBER:</label>
    <input type="text" name="phonenumber"/>
    <br>
    <button type="submit" class="btn btn-outline-primary">SAVE</button>
    <a href="/" class="btn btn-outline-danger">BACK</a>
</form>
</body>
</html>
