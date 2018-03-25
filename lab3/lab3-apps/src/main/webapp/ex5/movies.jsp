<%@ page import="java.util.List" %>
<%@ page import="soa.mkuzmik.ex5.Movie" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<table>
    <tr>
        <th>Tytul</th>
        <th>Gatunek</th>
        <th>Rok</th>
        <th>Dochod</th>
    </tr>

<c:forEach items="${movies}" var="movie">
    <tr>
        <td>${movie.title}</td>
        <c:choose>
            <c:when test='${movie.category=="wojenny"}'>
                <td style="background-color: aqua">${movie.category}</td>
            </c:when>
            <c:otherwise>
                <td>${movie.category}</td>
            </c:otherwise>
        </c:choose>
        <td>${movie.year}</td>
        <td><fmt:formatNumber type="currency" currencySymbol="$" value="${movie.income}"/> </td>
    </tr>
</c:forEach>

</table>

</body>
</html>
