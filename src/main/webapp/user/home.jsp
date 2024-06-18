<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.KhachHang" %>
<%@ page import="java.util.Optional" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.*,java.util.*,javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Home Page</h2>
        <c:choose>
            <c:when test="${empty sessionScope.khachHang}">
                <a href="${pageContext.request.contextPath}/dangnhap" class="btn btn-primary">Đăng nhập</a>
            </c:when>
            <c:otherwise>
                <p>Xin chào, <c:out value="${sessionScope.khachHang.tenKhachHang}"/>!</p>
                <form action="${pageContext.request.contextPath}/dangxuat" method="post">
                    <button type="submit" class="btn btn-danger">Đăng xuất</button>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>