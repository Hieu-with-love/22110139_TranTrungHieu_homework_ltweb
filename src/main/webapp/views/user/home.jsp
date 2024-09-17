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
</head>
<body>
    <h1>Đây là trang user</h1>
    <c:choose>
        <c:when test="${sessionScope.account == null}">
            <div class="col-sm-6">
                <ul class="list-inline right-topbar pull-right">
                    <li><a href="${pageContext.request.contextPath }/login">Đăng nhập</a>
                        | <a href="${pageContext.request.contextPath }/register">Đăng ký</a></li>
                    <li><i class="search fa fa-search search-button"></i></li>
                </ul>
            </div>
        </c:when>
        <c:otherwise>
            <div class="col-sm-6">
                <ul class="list-inline right-topbar pull-right">
                    <li><a href="${pageContext.request.contextPath
                                    }/member/myaccount">${sessionScope.account.fullname}</a> | <a
                            href="${pageContext.request.contextPath }/logout">Đăng Xuất</a></li>
                    <li><i class="search fa fa-search search-button"></i></li>
                </ul>
            </div>
        </c:otherwise></c:choose>
</body>
</html>