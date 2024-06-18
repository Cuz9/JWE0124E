<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Admin Login</h2>
        <form action="admin?action=login" method="post">
            <div class="mb-3">
                <label for="taiKhoan" class="form-label">Tài khoản</label>
                <input type="text" class="form-control" id="taiKhoan" name="taiKhoan" required>
            </div>
            <div class="mb-3">
                <label for="matKhau" class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" id="matKhau" name="matKhau" required>
            </div>
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
            <c:if test="${not empty error}">
                <div class="alert alert-danger mt-3">${error}</div>
            </c:if>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
