<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách phiếu thuê phòng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Danh sách phiếu thuê phòng</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Mã phiếu thuê phòng</th>
                    <th>Mã phòng</th>
                    <th>Mã khách hàng</th>
                    <th>Ngày đến</th>
                    <th>Tiền cọc</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="phieuThuePhong" items="${phieuThuePhongList}">
                    <tr>
                        <td>${phieuThuePhong.maPhieuThuePhong}</td>
                        <td>${phieuThuePhong.maPhong}</td>
                        <td>${phieuThuePhong.maKhachHang}</td>
                        <td>${phieuThuePhong.ngayDen}</td>
                        <td>${phieuThuePhong.tienCoc}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
		<a href="admin/dashboard.jsp" class="btn btn-secondary">Quay lại </a>  
    </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>
