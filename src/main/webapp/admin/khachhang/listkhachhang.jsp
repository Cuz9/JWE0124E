<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Danh sách khách hàng</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Mã Khách Hàng</th>
                    <th>Tài Khoản</th>
                    <th>Tên Khách Hàng</th>
                    <th>Giới Tính</th>
                    <th>CMND</th>
                    <th>Địa Chỉ</th>
                    <th>Email</th>
                    <th>Số Điện Thoại</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="khachHang" items="${khachHangList}">
                    <tr>
                        <td>${khachHang.maKhachHang}</td>
                        <td>${khachHang.taiKhoan}</td>
                        <td>${khachHang.tenKhachHang}</td>
                        <td>${khachHang.gioiTinh ? "Nam" : "Nữ"}</td>
                        <td>${khachHang.cmnd}</td>
                        <td>${khachHang.diaChi}</td>
                        <td>${khachHang.email}</td>
                        <td>${khachHang.soDienThoai}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/khachhang?action=edit&maKhachHang=${khachHang.maKhachHang}" class="btn btn-primary">Sửa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
		<a href="admin/dashboard.jsp" class="btn btn-secondary">Quay lại </a>
        
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
