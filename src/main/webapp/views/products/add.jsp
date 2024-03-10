<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>page 1</title>
    <style>
        th {text-align: left}
    </style>
</head>
<body>
    <h2>Add Product</h2>
    <form action="/products?action=add"  method="post">
        <input type="hidden" name="action" value="postAdd">
        <table>
            <tr>
                <th>Product ID:</th>
                <td><input type="text" name="productId"><br></td>
            </tr>
            <tr>
                <th>Product Name:</th>
                <td><input type="text" name="productName"><br></td>
            </tr>
            <tr>
                <th>Manufacturer:</th>
                <td><input type="text" name="manufacturer"><br></td>
            </tr>
            <tr>
                <th>Batch:</th>
                <td><input type="number" name="batch"><br></td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td><input type="number" name="quantity"><br></td>
            </tr>
            <tr>
                <th>Product Status:</th>
                <td><input type="checkbox" name="productStatus" value="true"><br></td>
            </tr>
        </table>
        <p>
            <a href="products?action=index">Back</a>
        </p>
        <input type="submit" value="Add">


    </form>

</body>
</html>
