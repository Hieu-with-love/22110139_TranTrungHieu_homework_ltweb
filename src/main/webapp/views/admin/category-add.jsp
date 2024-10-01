<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/1/2024
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form action="<c:url value="/admin/category/insert"/>" method="post">
  <label for="name">Category Name</label><br>
  <input type="text" id="name" name="name"><br>
  <label for="image">Link image:</label><br>
  <input type="text" id="image" name="image"><br><br>
  <label>Status</label><br>
  <input type="radio" id="act" name="status" value="1">
  <label for="act">Hoạt động</label><br>
  <input type="radio" id="unact" name="status" value="0">
  <label for="unact">Khoá</label>
  <br>

  <input type="submit" value="Submit">

</form>
