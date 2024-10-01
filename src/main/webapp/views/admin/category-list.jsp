<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/1/2024
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<a href="<c:url value="/admin/category/add"/>">Add Category</a>
<table>
  <tr>
    <th>STT</th>
    <th>Category Name</th>
    <th>Image</th>
    <th>Status</th>
    <th>Action</th>
  </tr>
  <c:forEach items="${categoryList}" var="cate" varStatus="STT" >
    <tr class="odd gradeX">
      <td>${STT.index+1 }</td>
      <c:url value="/image?fname=${cate.icon }" var="imgUrl"></c:url>
      <td><img height="150" width="200" src="${imgUrl}" /></td>
      <td>${cate.name }</td>
      <td><a href="<c:url value='/admin/category/edit?id=${cate.id }'/>"
             class="center">Sửa</a>
        | <a href="<c:url value='/admin/category/delete?id=${cate.id }'/>"
             class="center">Xóa</a></td>
    </tr>
  </c:forEach>
</table>