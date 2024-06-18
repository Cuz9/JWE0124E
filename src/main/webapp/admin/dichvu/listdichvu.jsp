<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách dịch vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script>
    function confirmDelete(maDichVu) {
        if (confirm("Bạn có chắc chắn muốn xóa dịch vụ: " + maDichVu + "?")) {
            window.location.href = "dichvu?action=delete&maDichVu=" + maDichVu;
        }
    }
</script>
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Danh Sách Dịch Vụ</h2>
        <a href="dichvu?action=add" class="btn btn-primary mb-3">Thêm Dịch Vụ</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Mã Dịch Vụ</th>
                    <th>Tên Dịch Vụ</th>
                    <th>Giá Tiền</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dichVu" items="${dichVuList}">
                    <tr>
                        <td>${dichVu.maDichVu}</td>
                        <td>${dichVu.tenDichVu}</td>
                        <td>${dichVu.giaTien}</td>
                        <td>
                            <a href="dichvu?action=edit&maDichVu=${dichVu.maDichVu}" class="btn btn-warning">Sửa</a>
                            <button onclick="confirmDelete('${dichVu.maDichVu}')" class="btn btn-danger">Xóa</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <a href="admin/dashboard.jsp" class="btn btn-secondary">Quay lại </a>
        
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
