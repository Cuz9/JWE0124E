<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách chi tiết dịch vụ</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Danh sách chi tiết dịch vụ</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Mã phiếu thuê phòng</th>
                    <th>Mã dịch vụ</th>
                    <th>Số lượng</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="chiTietDichVu" items="${chiTietDichVuList}">
                    <tr>
                        <td>${chiTietDichVu.maPhieuThuePhong}</td>
                        <td>${chiTietDichVu.maDichVu}</td>
                        <td>${chiTietDichVu.soLuong}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
		<a href="admin/dashboard.jsp" class="btn btn-secondary">Quay lại </a>
        
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
