<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Article</title>
    <link href="${pageContext.request.contextPath}/static/css/pastel.css" rel="stylesheet">
</head>
<body>
<div class="container pastel-container">
    <h1>Article Details</h1>
    <p>ID: ${article.id}</p>
    <p>Description: ${article.description}</p>
    <p>Quantity: ${article.quantity}</p>
    <p>Price: ${article.price}</p>
    <a href="${pageContext.request.contextPath}/articles.do" class="btn-pastel">Go Back</a>
</div>
</body>
</html>
