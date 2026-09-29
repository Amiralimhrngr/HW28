<%--
  Created by IntelliJ IDEA.
  User: 110
  Date: 9/29/2026
  Time: 2:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Latest Order</title>
</head>

<body>

<h1>Latest Order</h1>

<p>
    Customer: ${order.customerName}
</p>

<p>
    Product: ${order.productName}
</p>

<p>
    Product Price: ${order.productPrice}
</p>

<p>
    Quantity: ${order.quantity}
</p>

<p>
    Total Price: ${order.totalPrice}
</p>

<hr>

<a href="order">
    Create Another Order
</a>

</body>
</html>
