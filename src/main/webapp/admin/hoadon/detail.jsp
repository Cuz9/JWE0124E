<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết hóa đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Chi tiết hóa đơn</h1>
        <div class="row mb-3">
            <div class="col-md-6">
                <p><strong>Mã hóa đơn:</strong> ${chiTietHoaDon.maHoaDon}</p>
                <p><strong>Tên khách hàng:</strong> ${chiTietHoaDon.tenKhachHang}</p>
                <p><strong>CMND:</strong> ${chiTietHoaDon.cmnd}</p>
                <p><strong>Địa chỉ:</strong> ${chiTietHoaDon.diaChi}</p>
                <p><strong>Email:</strong> ${chiTietHoaDon.email}</p>
                <p><strong>Số điện thoại:</strong> ${chiTietHoaDon.soDienThoai}</p>
            </div>
            <div class="col-md-6">
                <p><strong>Tên phòng:</strong> ${chiTietHoaDon.tenPhong}</p>
                <p><strong>Đơn giá:</strong> ${chiTietHoaDon.donGia} VNĐ</p>
                <p><strong>Ngày đến:</strong> ${chiTietHoaDon.ngayDen}</p>
                <p><strong>Ngày thanh toán:</strong> ${chiTietHoaDon.ngayThanhToan}</p>
                <p><strong>Tiền cọc:</strong> ${chiTietHoaDon.tienCoc} VNĐ</p>
                <p><strong>Tổng tiền:</strong> ${chiTietHoaDon.tongTien} VNĐ</p>
            </div>
        </div>
        <a href="hoadon" class="btn btn-secondary">Quay lại danh sách hóa đơn</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
