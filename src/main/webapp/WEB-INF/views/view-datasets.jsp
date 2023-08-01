<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>View Books</title>
    <link href="<c:url value="common.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Natco Code</th>
        <th>created by</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.name}</td>
            <td>${book.natcoCode}</td>
            <td>${book.createdBy}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>