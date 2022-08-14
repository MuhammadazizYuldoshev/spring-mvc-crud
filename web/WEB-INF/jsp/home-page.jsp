<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 8/14/2022
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <%@include file="base.jsp"%>
</head>
<body>

<div class="container mt-3">
    <div class="row">
        <div class="col-md-12">
            <h1 CLASS="text-center mb-3">USER LIST</h1>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">FirstName</th>
                    <th scope="col">LastName</th>
                    <th scope="col">PhoneNumber</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                <tr>
                    <td class="font-weight-bold"><i class="fa-solid fa-id-badge"></i> ${user.id}</td>
                    <td class="font-weight-bold"><i class="fa-solid fa-user"></i> ${user.firstname}</td>
                    <td class="font-weight-bold"><i class="fa-solid fa-user"></i> ${user.lastname}</td>
                    <td class="font-weight-bold"><i class="fa-solid fa-phone"></i> ${user.phonenumber}</td>
                    <td>
                        <a href="/delete/${user.id}"><i class="fa-solid fa-user-xmark text-danger" style="font-size: 25px"></i></a>
                        <a href="/update/${user.id}"><i class="fa-solid fa-pen-to-square text-primary" style="font-size: 25px"></i></a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="container text-center">

                <a href="/add" class="btn btn-outline-success">ADD USER</a>

            </div>
        </div>
    </div>
</div>

</body>
</html>
