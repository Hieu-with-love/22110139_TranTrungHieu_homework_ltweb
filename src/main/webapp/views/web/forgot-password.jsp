<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 9/19/2024
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<html>
<head>
    <title>Forgot password Form</title>
  <style>
    * {box-sizing: border-box}

    /* Add padding to containers */
    .container {
      padding: 16px;
    }

    /* Full-width input fields */
    input[type=text], input[type=password] {
      width: 100%;
      padding: 15px;
      margin: 5px 0 22px 0;
      display: inline-block;
      border: none;
      background: #f1f1f1;
    }

    input[type=text]:focus, input[type=password]:focus {
      background-color: #ddd;
      outline: none;
    }

    /* Overwrite default styles of hr */
    hr {
      border: 1px solid #f1f1f1;
      margin-bottom: 25px;
    }

    /* Set a style for the submit/register button */
    .registerbtn {
      background-color: #04AA6D;
      color: white;
      padding: 16px 20px;
      margin: 8px 0;
      border: none;
      cursor: pointer;
      width: 100%;
      opacity: 0.9;
    }

    .registerbtn:hover {
      opacity:1;
    }

    /* Add a blue text color to links */
    a {
      color: dodgerblue;
    }

    /* Set a grey background color and center the text of the "sign in" section */
    .signin {
      background-color: #f1f1f1;
      text-align: center;
    }
  </style>
</head>
<body>
  <form action="forgot-password" class="container" method="post">
    <h1>Đây là form lấy lại mật khẩu</h1>
    <%-- Hiển thị thông báo lỗi nếu có --%>
    <c:if test="${not empty error}">
      <p style="color:red">${error}</p>
    </c:if>

    <%-- Hiển thị mật khẩu nếu tồn tại --%>
    <c:if test="${not empty password}">
      <p>Your password is: <strong>${password}</strong></p>
    </c:if>

    <div style="text-align: center;">
      <h3 style="text-align: center; margin: 2rem;">Nhập email để lấy lại mật khau</h3>
      <label for="username" style="margin-bottom: 20px;">Nhập user</label>
      <input class="container" id="username" name="username">

      <label for="email" style="margin-bottom: 20px;">Nhập email</label>
      <input class="container" id="email" name="email">

      <button style="border: #04AA6D;" class="registerbtn">Lấy lại mật khẩu</button>
    </div>
  </form>
</body>
</html>
