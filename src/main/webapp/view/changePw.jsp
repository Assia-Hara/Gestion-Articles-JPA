<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
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
                <font color="red">${error}</font>
            </p>
            <!-- Change Password Form -->
            <form action="${pageContext.request.contextPath}/changePw.do" method="post">
                <input type="password" id="currentPassword" class="fadeIn second" name="currentPassword" placeholder="Current Password">
                <input type="password" id="newPassword" class="fadeIn third" name="newPassword" placeholder="New Password">
                <input type="password" id="confirmPassword" class="fadeIn fourth" name="confirmPassword" placeholder="Confirm New Password">
                <input type="submit" class="fadeIn fifth" value="Change Password">
            </form>
            <div id="formFooter">
                <a class="underlineHover" href="${pageContext.request.contextPath}/articles.do">Back to Home</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
