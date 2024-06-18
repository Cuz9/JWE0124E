<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Welcome to Home Page</h2>
        
        <!-- Kiểm tra nếu đã đăng nhập -->
        <c:if test="${not empty sessionScope.customer}">
            <p>Xin chào, <c:out value="${sessionScope.customer.tenKhachHang}"/>!</p>
            <p>Email: <c:out value="${sessionScope.customer.email}"/></p>
            
            <!-- Hiển thị danh sách các phòng -->
            <h3>Danh sách các phòng</h3>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Mã Phòng</th>
                        <th>Tên Phòng</th>
                        <th>Sức Chứa</th>
                        <th>Đơn Giá</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="phong" items="${listPhong}">
                        <tr>
                            <td><c:out value="${phong.maPhong}"/></td>
                            <td><c:out value="${phong.tenPhong}"/></td>
                            <td><c:out value="${phong.sucChua}"/></td>
                            <td><c:out value="${phong.donGia}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </div>
    
    <!-- Script Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>