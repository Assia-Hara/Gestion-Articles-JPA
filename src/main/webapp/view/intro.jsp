<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Vaporwave Store</title>
    <link href="${pageContext.request.contextPath}/static/css/intro.css" rel="stylesheet">
</head>
<body>
<div class="vaporwave-container">
    <h1>Welcome to my Store</h1>
    <p>Discover the finest collection of retro and aesthetic electronic items.</p>
    <button class="btn-vaporwave" onclick="location.href='articles.do'">Enter Store</button>
</div>
</body>
</html>
