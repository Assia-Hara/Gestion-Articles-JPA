<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Article</title>
    <link href="${pageContext.request.contextPath}/static/css/pastel.css" rel="stylesheet">
</head>
<body>
<div class="container pastel-container">
    <h1>Edit Article</h1>
    <form action="editArticle.do" method="post">
        <input type="hidden" name="id" value="${article.id}">
        <div>
            <label for="description">Description:</label>
            <input type="text" id="description" name="description" value="${article.description}" required>
        </div>
        <div>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" value="${article.quantity}" required>
        </div>
        <div>
            <label for="price">Price:</label>
            <input type="number" step="0.01" id="price" name="price" value="${article.price}" required>
        </div>
        <button type="submit" class="btn-pastel">Save Changes</button>
    </form>
    <button class="btn-pastel" onclick="window.history.back()">Go Back</button>
</div>
</body>
</html>
