<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
    <div class="container mt-5">
        <h2>Đăng ký</h2>
        <form action="dangky" method="post">
            <div class="mb-3">
                <label for="maKhachHang" class="form-label">Mã khách hàng</label>
                <input type="text" class="form-control" id="maKhachHang" name="maKhachHang">
            </div>
            <div class="mb-3">
                <label for="taiKhoan" class="form-label">Tài khoản</label>
                <input type="text" class="form-control" id="taiKhoan" name="taiKhoan">
            </div>
            <div class="mb-3">
                <label for="matKhau" class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" id="matKhau" name="matKhau">
            </div>
            <div class="mb-3">
                <label for="tenKhachHang" class="form-label">Tên khách hàng</label>
                <input type="text" class="form-control" id="tenKhachHang" name="tenKhachHang">
            </div>
            <div class="mb-3">
                <label for="gioiTinh" class="form-label">Giới tính</label><br>
                <input type="radio" id="nam" name="gioiTinh" value="true">
                <label for="nam">Nam</label>
                <input type="radio" id="nu" name="gioiTinh" value="false">
                <label for="nu">Nữ</label>
            </div>
            <div class="mb-3">
                <label for="cmnd" class="form-label">CMND</label>
                <input type="text" class="form-control" id="cmnd" name="cmnd">
            </div>
            <div class="mb-3">
                <label for="diaChi" class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" id="diaChi" name="diaChi">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email">
            </div>
            <div class="mb-3">
                <label for="soDienThoai" class="form-label">Số điện thoại</label>
                <input type="text" class="form-control" id="soDienThoai" name="soDienThoai">
            </div>
            <button type="submit" class="btn btn-primary">Đăng ký</button>
            <a href="dangnhap" class="btn btn-secondary">Bạn đã có tài khoản? Đăng nhập</a>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
