<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Phong</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Edit Phong</h2>
        <form action="${pageContext.request.contextPath}/phong?action=update" method="post">
            <input type="hidden" name="maPhong" value="${phong.maPhong}">
            
            <div class="mb-3">
                <label for="maLoaiPhong" class="form-label">Mã Loại Phòng:</label>
                <select id="maLoaiPhong" name="maLoaiPhong" class="form-select">
                    <c:forEach var="maLoaiPhong" items="${listMaLoaiPhong}">
                        <c:choose>
                            <c:when test="${phong.maLoaiPhong eq maLoaiPhong}">
                                <option value="${maLoaiPhong}" selected>${maLoaiPhong}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${maLoaiPhong}">${maLoaiPhong}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            
            <div class="mb-3">
                <label for="tenPhong" class="form-label">Tên Phòng:</label>
                <input type="text" id="tenPhong" name="tenPhong" class="form-control" value="${phong.tenPhong}">
            </div>
            
            <div class="mb-3">
                <label for="hinhAnh" class="form-label">Hình Ảnh:</label>
                <input type="text" id="hinhAnh" name="hinhAnh" class="form-control" value="${phong.hinhAnh}">
            </div>
            
            <div class="mb-3">
                <label for="sucChua" class="form-label">Sức Chứa:</label>
                <input type="number" id="sucChua" name="sucChua" class="form-control" value="${phong.sucChua}">
            </div>
            
            <div class="mb-3">
                <label for="donGia" class="form-label">Đơn Giá:</label>
                <input type="number" id="donGia" name="donGia" class="form-control" value="${phong.donGia}">
            </div>
            
            <div class="mb-3">
                <label for="moTa" class="form-label">Mô Tả:</label>
                <textarea id="moTa" name="moTa" class="form-control">${phong.moTa}</textarea>
            </div>
            
            <div class="mb-3">
                <label class="form-check-label">Tình Trạng:</label><br>
                <div class="form-check form-check-inline">
                    <input type="radio" id="daDat" name="tinhTrang" class="form-check-input" value="false" ${!phong.tinhTrang ? 'checked' : ''}>
                    <label for="daDat" class="form-check-label">Đã đặt</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="radio" id="chuaDat" name="tinhTrang" class="form-check-input" value="true" ${phong.tinhTrang ? 'checked' : ''}>
                    <label for="chuaDat" class="form-check-label">Chưa đặt</label>
                </div>
            </div>
            
            <button type="submit" class="btn btn-primary">Cập nhật</button> 
            <a href="phong" class="btn btn-secondary">Quay lại danh sách phòng</a>
        </form>
        <c:if test="${not empty error}">
            <p style="color: red;">${error}</p>
        </c:if>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
