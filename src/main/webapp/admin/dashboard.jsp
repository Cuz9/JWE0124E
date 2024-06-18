<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Admin Dashboard</h2>
        <p>Chào mừng, <c:out value="${adminUsername}"/>!</p>
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Đăng xuất</a>

        <div class="row mt-3">
            <div class="col-md-4 mb-3">
                <a href="${pageContext.request.contextPath}/loaiphong" class="btn btn-primary btn-lg btn-block">Quản lý Loại Phòng</a>
            </div>
            <div class="col-md-4 mb-3">
                <a href="${pageContext.request.contextPath}/phong" class="btn btn-primary btn-lg btn-block">Quản lý Phòng</a>
            </div>
            <div class="col-md-4 mb-3">
                <a href="${pageContext.request.contextPath}/khachhang" class="btn btn-primary btn-lg btn-block">Quản lý Khách Hàng</a>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-md-4 mb-3">
                <a href="${pageContext.request.contextPath}/hoadon" class="btn btn-primary btn-lg btn-block">Quản lý Hóa Đơn</a>
            </div>
            <div class="col-md-4 mb-3">
                <a href="${pageContext.request.contextPath}/dichvu" class="btn btn-primary btn-lg btn-block">Quản lý Dịch Vụ</a>
            </div>
            <div class="col-md-4 mb-3">
                <a href="${pageContext.request.contextPath}/chitietdichvu" class="btn btn-primary btn-lg btn-block">Quản lý Chi Tiết Dịch Vụ</a>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-md-4 mb-3">
                <a href="${pageContext.request.contextPath}/phieuthuephong" class="btn btn-primary btn-lg btn-block">Quản lý Phiếu Thuê Phòng</a>
            </div>
            <!-- Add more buttons as needed for other functionalities -->
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>