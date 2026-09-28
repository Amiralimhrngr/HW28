<%--
  Created by IntelliJ IDEA.
  User: 110
  Date: 9/29/2026
  Time: 1:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="ir.maktabsharif.model.Order" %>

<!DOCTYPE html>
<html>
<head>
    <title>Order Result</title>
</head>

<body>

<h1>Order Result</h1>

<%
    Order order = (Order) request.getAttribute("order");
%>

<h3>Using JSP Expression:</h3>

<p> Customer: <%= order.getCustomerName() %></p>

<p> Product: <%= order.getProductName() %> </p>

<p> Total: <%= order.getTotalPrice() %> </p>

<h3>Using Expression Language:</h3>

<p> Customer: ${order.customerName} </p>

<p> Product: ${order.productName} </p>

<p> Product Price: ${order.productPrice} </p>

<p> Quantity: ${order.quantity} </p>

<p> Total Price:${order.totalPrice}</p>

<hr>
<a href="order">
    Create Another Order
</a>

<br>
<br>

<a href="latest-order">
    View Latest Order
</a>

</body>
</html>
