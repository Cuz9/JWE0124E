<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Edit Khách Hàng</h2>
        <form action="${pageContext.request.contextPath}/khachhang?action=update" method="post">
            <input type="hidden" name="maKhachHang" value="${khachHang.maKhachHang}">

            <div class="mb-3">
                <label for="taiKhoan" class="form-label">Tài Khoản</label>
                <input type="text" class="form-control" id="taiKhoan" name="taiKhoan" value="${khachHang.taiKhoan}" required>
            </div>
            <div class="mb-3">
                <label for="matKhau" class="form-label">Mật Khẩu</label>
                <input type="password" class="form-control" id="matKhau" name="matKhau" value="${khachHang.matKhau}" required>
            </div>
            <div class="mb-3">
                <label for="tenKhachHang" class="form-label">Tên Khách Hàng</label>
                <input type="text" class="form-control" id="tenKhachHang" name="tenKhachHang" value="${khachHang.tenKhachHang}" required>
            </div>
            <div class="mb-3">
                <label for="gioiTinh" class="form-label">Giới Tính</label><br>
                <input type="radio" id="gioiTinhNam" name="gioiTinh" value="true" ${khachHang.gioiTinh ? 'checked' : ''}>
                <label for="gioiTinhNam">Nam</label>
                <input type="radio" id="gioiTinhNu" name="gioiTinh" value="false" ${!khachHang.gioiTinh ? 'checked' : ''}>
                <label for="gioiTinhNu">Nữ</label>
            </div>
            <div class="mb-3">
                <label for="cmnd" class="form-label">CMND</label>
                <input type="text" class="form-control" id="cmnd" name="cmnd" value="${khachHang.cmnd}" required>
            </div>
            <div class="mb-3">
                <label for="diaChi" class="form-label">Địa Chỉ</label>
                <input type="text" class="form-control" id="diaChi" name="diaChi" value="${khachHang.diaChi}" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${khachHang.email}" required>
            </div>
            <div class="mb-3">
                <label for="soDienThoai" class="form-label">Số Điện Thoại</label>
                <input type="text" class="form-control" id="soDienThoai" name="soDienThoai" value="${khachHang.soDienThoai}" required>
            </div>
            <button type="submit" class="btn btn-primary">Cập nhật</button>
            <a href="khachhang" class="btn btn-secondary ">Quay lại danh sách khách hàng</a>
            
        </form>
        <c:if test="${not empty error}">
            <p style="color: red;">${error}</p>
        </c:if>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
