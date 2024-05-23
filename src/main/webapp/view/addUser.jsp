<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Account</title>
    <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="wrapper fadeInDown">
        <div id="formContent">
            <div class="fadeIn first">
                <img src="${pageContext.request.contextPath}/static/images/login.png" id="icon" alt="User Icon" />
            </div>
            <p>
                <font color="red">${AccountCreationError}</font>
            </p>
            <form action="${pageContext.request.contextPath}/addUser.do" method="post">
                <input type="text" id="username" class="fadeIn second" name="username" placeholder="Username">
                <input type="password" id="password" class="fadeIn third" name="password" placeholder="Password">
                <input type="password" id="confirmPassword" class="fadeIn fourth" name="confirmPassword" placeholder="Confirm Password">
                <input type="submit" class="fadeIn fifth" value="Create Account">
            </form>
            <div id="formFooter">
                <a class="underlineHover" href="${pageContext.request.contextPath}/login.do">Back to Login</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
