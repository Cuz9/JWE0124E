<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách phòng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
    .center-align {
        text-align: center;
        vertical-align: middle;
    }
</style>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Danh sách phòng</h2>
        <div class="mb-3">
            <a href="${pageContext.request.contextPath}/phong?action=create" class="btn btn-primary">Thêm phòng mới</a>
        </div>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Mã phòng</th>
                    <th>Mã loại phòng</th>
                    <th>Tên phòng</th>
                    <th>Hình ảnh</th>
                    <th>Sức chứa</th>
                    <th>Đơn giá</th>
                    <th>Mô tả</th>
                    <th>Tình trạng</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
			    <c:forEach var="phong" items="${listPhongs}">
			        <tr>
			            <td class="center-align">${phong.maPhong}</td>
			            <td class="center-align">${phong.maLoaiPhong}</td>
			            <td class="center-align">${phong.tenPhong}</td>
			            <td class="center-align">
			                <img src="${phong.hinhAnh}" alt="Hình ảnh phòng" style="width: 100px; height: 100px;">
			            </td>
			            <td class="center-align">${phong.sucChua}</td>
			            <td class="center-align">${phong.donGia}</td>
			            <td class="center-align">${phong.moTa}</td>
			            <td class="center-align">${phong.tinhTrang ? "Có sẵn" : "Đã đặt"}</td>
			            <td class="center-align">
			                <a href="${pageContext.request.contextPath}/phong?action=edit&maPhong=${phong.maPhong}" class="btn btn-warning btn-sm">Sửa</a>
			                <a href="${pageContext.request.contextPath}/phong?action=delete&maPhong=${phong.maPhong}" class="btn btn-danger btn-sm">Xóa</a>
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
