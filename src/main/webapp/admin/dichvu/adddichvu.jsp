<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Dịch Vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Thêm Dịch Vụ</h2>
        <form action="${pageContext.request.contextPath}/dichvu?action=add" method="post">
            <div class="mb-3">
                <label for="maDichVu" class="form-label">Mã Dịch Vụ:</label>
                <input type="text" class="form-control" id="maDichVu" name="maDichVu" required>
            </div>
            <div class="mb-3">
                <label for="tenDichVu" class="form-label">Tên Dịch Vụ:</label>
                <input type="text" class="form-control" id="tenDichVu" name="tenDichVu" required>
            </div>
            <div class="mb-3">
                <label for="giaTien" class="form-label">Giá Tiền:</label>
                <input type="number" class="form-control" id="giaTien" name="giaTien" required>
            </div>
            <button type="submit" class="btn btn-primary">Thêm</button>
            <a href="dichvu" class="btn btn-secondary">Quay lại danh sách dịch vụ</a>
        </form>
        <c:if test="${not empty error}">
            <p class="text-danger mt-3">${error}</p>
        </c:if>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
