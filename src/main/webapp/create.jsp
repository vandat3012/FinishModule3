<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 21/02/2024
  Time: 9:49 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div class="row justify-content-center mt-4">
<form class="col-md-6" method="post">
    <h1 align="center" class="">Create New</h1>
    <div class="form-group">
        <label for="exampleInputAge">Name</label>
        <input type="text" name="name" class="form-control" id="exampleInputAge">
    </div>
    <div class="form-group">
        <label for="exampleInputAddress">Email</label>
        <input type="text" name="email"  class="form-control" id="exampleInputAddress">
    </div>
    <div class="form-group">
        <label for="exampleInputAddres">date</label>
        <input type="text" name="date"  class="form-control" id="exampleInputAddres">
    </div>
    <div class="form-group">
        <label for="exampleInputAddr">Address</label>
        <input type="text" name="address"  class="form-control" id="exampleInputAddr">
    </div>
    <div class="form-group">
        <label for="exampleInputAddre">phone</label>
        <input type="text" name="phone"  class="form-control" id="exampleInputAddre">
    </div>

    <div class="form-group">
        <label class="form-select">Class</label>
        <select name="idC" class="form-select" aria-label="Default select example">
            <c:forEach items="${classes}" var="c" >
                <option value="${c.id}">${c.nameC}</option>
            </c:forEach>
        </select>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>
