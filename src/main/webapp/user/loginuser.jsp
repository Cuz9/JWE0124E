<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Đăng Nhập</h1>
        <form action="dangnhap" method="post">
            <div class="mb-3">
                <label for="taiKhoan" class="form-label">Tài Khoản</label>
                <input type="text" class="form-control" id="taiKhoan" name="taiKhoan" required>
            </div>
            <div class="mb-3">
                <label for="matKhau" class="form-label">Mật Khẩu</label>
                <input type="password" class="form-control" id="matKhau" name="matKhau" required>
            </div>
            <button type="submit" class="btn btn-primary">Đăng Nhập</button>
 			<a href="dangky" class="btn btn-secondary">Bạn chưa có tài khoản? Đăng Ký</a>
            
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
