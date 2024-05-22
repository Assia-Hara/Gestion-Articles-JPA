<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Article</title>
    <link href="${pageContext.request.contextPath}/static/css/pastel.css" rel="stylesheet">
</head>
<body>
<div class="container pastel-container">
    <h1>Add Article</h1>
    <form action="addArticle.do" method="post">
        <div>
            <label for="description">Description:</label>
            <input type="text" id="description" name="description" required>
        </div>
        <div>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required>
        </div>
        <div>
            <label for="price">Price:</label>
            <input type="number" step="0.01" id="price" name="price" required>
        </div>
        <button type="submit" class="btn-pastel">Add Article</button>
    </form>
    <button class="btn-pastel" onclick="window.history.back()">Go Back</button>
</div>
</body>
</html>
