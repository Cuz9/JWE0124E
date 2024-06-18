<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách hóa đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Danh sách hóa đơn</h1>
        <a href="hoadon?action=create" class="btn btn-primary mb-3">Tạo hóa đơn mới</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">Mã hóa đơn</th>
                    <th scope="col">Ngày thanh toán</th>
                    <th scope="col">Mã phiếu thuê phòng</th>
                    <th scope="col">Tổng tiền</th>
                    <th scope="col">Chi tiết</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${hoaDonList}" var="hoaDon">
                    <tr>
                        <td>${hoaDon.maHoaDon}</td>
                        <td>${hoaDon.ngayThanhToan}</td>
                        <td>${hoaDon.maPhieuThuePhong}</td>
                        <td>${hoaDon.tongTien}</td>
                        <td><a href="hoadon?action=detail&maHoaDon=${hoaDon.maHoaDon}" class="btn btn-primary">Xem chi tiết</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="admin/dashboard.jsp" class="btn btn-secondary">Quay lại </a>
        
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
