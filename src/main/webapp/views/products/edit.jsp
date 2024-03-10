
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        th {text-align: left}
    </style>
</head>
<body>
<h2>Edit Product</h2>
<form action="/products?action=edit" method="post">
    <input type="hidden" name="productId" value="${product.productId}">
    <table>
        <tr>
            <th>Product ID:</th>
            <td>${product.productId}</td>
        </tr>
        <tr>
            <th>Product Name:</th>
            <td><input type="text" name="productName" value="${product.productName}"><br></td>
        </tr>
        <tr>
            <th>Manufacturer:</th>
            <td><input type="text" name="manufacturer" value="${product.manufacturer}"><br></td>
        </tr>
        <tr>
            <th>Batch:</th>
            <td><input type="number" name="batch" value="${product.batch}"><br></td>
        </tr>
        <tr>
            <th>Quantity:</th>
            <td><input type="number" name="quantity" value="${product.quantity}"><br></td>
        </tr>
        <tr>
            <th>Product Status:</th>
            <td><input type="checkbox" name="productStatus" value="true" ${product.productStatus ? 'checked' : ''}><br></td>
        </tr>
    </table>
    <p>
        <a href="products?action=index">Back</a>
    </p>
    <input type="submit" value="Save">
</form>
</body>
</html>
