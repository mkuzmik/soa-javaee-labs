<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
</head>
<body>
<c:import var="products" url="http://localhost:8080/lab3-apps/ex4/products.xml"/>
<x:parse xml = "${products}" var="output"/>

<c:forEach items="${cart}" var="product">
    <c:set var="idSelector" value="@id=${product.key}"/>
    Name: <x:out select="$output/products/product[$idSelector]/name"/><br>
    Price: <x:out select="$output/products/product[$idSelector]/price"/><br>
    <form method="post" action="/lab3-apps/shop">
        <input type="hidden" name="id" value="${product.key}"/>
        Amount: <input type="text" name="amount" value="${product.value}"/> <br>
        <input type="hidden" name="source" value="cart"/>
        <input type="submit" value="Set amount"/>
    </form>
    <form method="post" action="/lab3-apps/shop">
        <input type="hidden" name="id" value="${product.key}"/>
        <input type="hidden" name="amount" value="0"/>
        <input type="hidden" name="source" value="cart"/>
        <input type="submit" value="Remove product"/>
    </form><br>
    <br><br>
</c:forEach>

</body>
</html>
