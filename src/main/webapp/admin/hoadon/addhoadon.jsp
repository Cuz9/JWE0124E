<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo hóa đơn mới</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Tạo hóa đơn mới</h1>
        <form action="hoadon?action=create" method="post">
            <div class="mb-3">
                <label for="maHoaDon" class="form-label">Mã hóa đơn:</label>
                <input type="text" id="maHoaDon" name="maHoaDon" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="ngayThanhToan" class="form-label">Ngày thanh toán:</label>
                <input type="date" id="ngayThanhToan" name="ngayThanhToan" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="maPhieuThuePhong" class="form-label">Mã phiếu thuê phòng:</label>
                <select id="maPhieuThuePhong" name="maPhieuThuePhong" class="form-select" required>
                    <c:forEach items="${maPhieuThuePhongList}" var="maPhieuThuePhong">
                        <option value="${maPhieuThuePhong}">${maPhieuThuePhong}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Tạo hóa đơn</button>
            <a href="hoadon" class="btn btn-secondary">Quay lại danh sách hóa đơn</a>
        </form>
    </div>

    <!-- Bootstrap JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
