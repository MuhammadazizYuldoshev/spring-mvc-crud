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
    <div style="margin-top: 30px; margin-bottom: 400px; margin-right: 400px; margin-left: 400px">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="exampleInputEmail1">FIRST NAME</label>
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"  name="firstname" value="${user.firstname}"/>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">LAST NAME</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="lastname" value="${user.lastname}"/>
        </div>
        <div class="form-group">
            <label for="exampleInputPhonenumber1">PHONE NUMBER</label>
            <input type="text" class="form-control" id="exampleInputPhonenumber1"  name="phonenumber" value="${user.phonenumber}"/>
        </div>
        <div style="text-align: center">
        <button type="submit" class="btn btn-outline-warning">UPDATE</button>
        <a href="/" class="btn btn-outline-danger">BACK</a>
        </div>
    </div>

</form>
</body>
</html>
