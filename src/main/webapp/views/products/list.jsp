<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Product List</h2>
<div>
    <form action="/products">
        <input type="hidden" name="action" value="index">
        <b>Tìm kiếm: </b>
        <input type="text" name="key" value="${key}" placeholder="Nhập từ khóa tìm kiếm">
        <button>Tìm</button>
    </form>
</div>
<p><a href="views/products/add.jsp">Thêm sản phẩm</a></p>
<table border="1" cellpadding="5" cellspacing="0" width="80%" >
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Manufacturer</th>
        <th>Batch</th>
        <th>Quantity</th>
        <th>Product Status</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="pro">
        <tr>
            <td>${pro.productId}</td>
            <td>${pro.productName}</td>
            <td>${pro.manufacturer}</td>
            <td>${pro.batch}</td>
            <td>${pro.quantity}</td>
            <td>
                <c:choose>
                    <c:when test="${pro.productStatus eq 'true'}">Hoạt động</c:when>
                    <c:when test="${pro.productStatus eq 'false'}">Không hoạt động</c:when>
                </c:choose>
            </td>
            <td>
                <a href="/products?action=edit&id=${pro.productId}">Sửa</a>
                <a href="/products?action=remove&id=${pro.productId}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:forEach begin="1" end="${total}" varStatus="loop">
    <c:if test="${currentPage == loop.index}">
        <a href="/products?action=index&key=${key}&currentPage=${loop.index}">${loop.index}</a>
    </c:if>
    <c:if test="${currentPage != loop.index}">
        <a href="/products?action=index&key=${key}&currentPage=${loop.index}">${loop.index}</a>
    </c:if>
</c:forEach>
</body>
</html>
