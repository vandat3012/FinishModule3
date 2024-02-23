<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 21/02/2024
  Time: 9:55 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>

<table class="table" border="1px">
    <thead>
    <h1 align="center" class="">LIST ASSIGNMENT</h1>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">NAME</th>
        <th scope="col">DATE</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Phone</th>
        <th scope="col">ClassRoom</th>

    </tr>
    </thead>
<c:forEach items="${dtoStudent}" var="d" >
        <tbody>
        <tr>
            <th>${d.id}</th>
            <th>${d.name}</th>
            <th>${d.dates}</th>
            <th>${d.email}</th>
            <th>${d.address}</th>
            <th>${d.phone}</th>
            <th>${d.nameC}</th>
            <td>
                <a class="btn btn-danger" href="/student?action=edit&id=${d.id}" role="button">Edit</a>
            </td>
            <td>
                <a class="btn btn-danger" href="/student?action=delete&id=${d.id}" role="button">Delete</a>
            </td>
        </tr>
        </tbody>
</c:forEach>

</table>
<div class="col-5" >
        <form class="d-flex" role="search" action="/student" method="post">
            <input name="action" value="find" hidden="">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="name">
            <button class="btn btn-danger" type="submit">Find</button>
        </form>
    <a class="btn btn-danger" href="/student?action=create" role="button">Create New Assignment</a>
<%--    <a class="btn btn-danger" href="/assignment?action=sort" role="button">Sort By Name Author</a>--%>
<%--    <a class="btn btn-danger" href="/assignment" role="button">Return After Sort</a>--%>
</div>

</body>
</html>
