<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Loại Phòng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Danh Sách Loại Phòng</h2>
        <a href="${pageContext.request.contextPath}/loaiphong?action=add" class="btn btn-success mb-3">Thêm Loại Phòng</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Mã Loại Phòng</th>
                    <th>Tên Loại Phòng</th>
                    <th>Mô Tả</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="loaiPhong" items="${loaiPhongList}">
                    <tr>
                        <td>${loaiPhong.maLoaiPhong}</td>
                        <td>${loaiPhong.tenLoaiPhong}</td>
                        <td>${loaiPhong.moTa}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/loaiphong?action=edit&maLoaiPhong=${loaiPhong.maLoaiPhong}" class="btn btn-primary btn-sm">Sửa</a>
                            <a href="${pageContext.request.contextPath}/loaiphong?action=delete&maLoaiPhong=${loaiPhong.maLoaiPhong}" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc chắn muốn xóa loại phòng này?');">Xóa</a>
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
