<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Phong</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Add Phong</h2>
        <form action="${pageContext.request.contextPath}/phong?action=create" method="post">
            <div class="mb-3">
                <label for="maPhong" class="form-label">Ma Phong:</label>
                <input type="text" class="form-control" id="maPhong" name="maPhong">
            </div>
            
            <div class="mb-3">
                <label for="maLoaiPhong" class="form-label">Ma Loai Phong:</label>
                <select class="form-select" id="maLoaiPhong" name="maLoaiPhong">
                    <c:forEach var="maLoaiPhong" items="${listMaLoaiPhong}">
                        <option value="${maLoaiPhong}">${maLoaiPhong}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="mb-3">
                <label for="tenPhong" class="form-label">Ten Phong:</label>
                <input type="text" class="form-control" id="tenPhong" name="tenPhong">
            </div>
            
            <div class="mb-3">
                <label for="hinhAnh" class="form-label">Hinh Anh:</label>
                <input type="file" class="form-control" id="hinhAnh" name="hinhAnh">
            </div>
            
            <div class="mb-3">
                <label for="sucChua" class="form-label">Suc Chua:</label>
                <input type="text" class="form-control" id="sucChua" name="sucChua">
            </div>
            
            <div class="mb-3">
                <label for="donGia" class="form-label">Don Gia:</label>
                <input type="text" class="form-control" id="donGia" name="donGia">
            </div>
            
            <div class="mb-3">
                <label for="moTa" class="form-label">Mo Ta:</label>
                <textarea class="form-control" id="moTa" name="moTa"></textarea>
            </div>
            
            <div class="mb-3">
                <label for="tinhTrang" class="form-label">Tình Trạng:</label><br>
                <div class="form-check">
                    <input class="form-check-input" type="radio" id="daDat" name="tinhTrang" value="true">
                    <label class="form-check-label" for="daDat">Đã đặt</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" id="chuaDat" name="tinhTrang" value="false">
                    <label class="form-check-label" for="chuaDat">Chưa đặt</label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Thêm</button>
            <a href="${pageContext.request.contextPath}/phong" class="btn btn-secondary">Quay lại danh sách phòng</a>
        </form>
        <c:if test="${not empty error}">
            <div class="alert alert-danger mt-3">${error}</div>
        </c:if>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
