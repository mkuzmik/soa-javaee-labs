<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
</head>
<body>
<c:import var="products" url="http://localhost:8080/lab3-apps/ex4/products.xml"/>
<x:parse xml = "${products}" var="output"/>

<x:forEach select="$output/products/product" var="item">
    Przedmiot: <x:out select="$item/name"/><br>
    Cena: <x:out select="$item/price"/><br>
    <form method="post" action="/lab3-apps/shop">
        <input type="hidden" name="id" value="<x:out select="$item/@id"/>"/>
        <input type="hidden" name="amount" value="1"/>
        <input type="hidden" name="source" value="shop"/>
        <input type="submit" value="Add to cart"/>
    </form><br><br>
</x:forEach>

<br>
<input type="button" onclick="window.location = 'shop';" value="Manage shopping cart"/>

</body>
</html>
