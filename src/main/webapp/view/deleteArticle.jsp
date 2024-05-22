<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Article</title>
    <link href="${pageContext.request.contextPath}/static/css/pastel.css" rel="stylesheet">
</head>
<body>
<div class="container pastel-container">
    <h1>Delete Article</h1>
    <p>Are you sure you want to delete this article?</p>
    <form action="deleteArticle.do" method="post">
        <input type="hidden" name="id" value="${articleId}">
        <button type="submit" class="btn-pastel">Yes, Delete</button>
    </form>
    <button class="btn-pastel" onclick="window.history.back()">Cancel</button>
</div>
</body>
</html>
