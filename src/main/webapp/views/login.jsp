<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 9/17/2024
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
    <style>
        /* Bordered form */
        form {
            border: 3px solid #f1f1f1;
        }

        /* Full-width inputs */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        /* Set a style for all buttons */
        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        /* Add a hover effect for buttons */
        button:hover {
            opacity: 0.8;
        }

        /* Extra style for the cancel button (red) */
        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        /* Center the avatar image inside this container */
        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
        }

        /* Avatar image */
        img.avatar {
            width: 40%;
            border-radius: 50%;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
        }

        /* The "Forgot password" text */
        span.psw {
            float: right;
            padding-top: 16px;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }
            .cancelbtn {
                width: 100%;
            }
        }
    </style>
</head>
<body>
<form action="/webapp_war/login" method="post">
    <div class="imgcontainer">
        <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <h2>Tạo tài khoản mới</h2>
        <c:if test="${alert !=null}">
            <h3 class="alert alertdanger">${alert}</h3>
        </c:if>
        <label for="username"><b>Username</b></label>
        <input id="username" type="text" placeholder="Enter Username" name="username">

        <label for="password"><b>Password</b></label>
        <input id="password" type="password" placeholder="Enter Password" name="password">

        <button type="submit">Login</button>
        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
</form>

</body>
</html>