<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh Sửa Loại Phòng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Chỉnh Sửa Loại Phòng</h2>
        <form action="${pageContext.request.contextPath}/loaiphong?action=edit" method="post">
            <input type="hidden" name="maLoaiPhong" value="${loaiPhong.maLoaiPhong}">
            <div class="mb-3">
                <label for="tenLoaiPhong" class="form-label">Tên Loại Phòng:</label>
                <input type="text" id="tenLoaiPhong" name="tenLoaiPhong" class="form-control" value="${loaiPhong.tenLoaiPhong}" required>
            </div>
            <div class="mb-3">
                <label for="moTa" class="form-label">Mô Tả:</label>
                <textarea id="moTa" name="moTa" class="form-control">${loaiPhong.moTa}</textarea>
            </div>
            <button type="submit" class="btn btn-primary">Cập Nhật</button>
            <a href="loaiphong" class="btn btn-secondary">Quay lại danh sách loại phòng</a>
            
        </form>
        <c:if test="${not empty error}">
            <p style="color: red;">${error}</p>
        </c:if>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
