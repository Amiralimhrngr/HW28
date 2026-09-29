<%--
  Created by IntelliJ IDEA.
  User: 110
  Date: 9/29/2026
  Time: 1:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create Order</title>
</head>

<body>

<h1>Create New Order</h1>

<form method="post" action="order">

    <label>Customer Name:</label>

    <input type="text" name="customerName" value="${customerName}" required>

    <br><br>

    <label>Product Name:</label>

    <input type="text" name="productName" required>

    <br><br>

    <label>Product Price:</label>

    <input type="number" name="productPrice" step="0.01" min="0" required>

    <br><br>

    <label>Quantity:</label>

    <input type="number" name="quantity" min="1" required>

    <br><br>

    <button type="submit"> Submit Order</button>

</form>

<br>

<a href="latest-order"> View Latest Order </a>

</body>
</html>
