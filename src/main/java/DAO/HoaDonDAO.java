package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;
import model.ChiTietHoaDon;
import model.HoaDon;

public class HoaDonDAO {

	public List<HoaDon> getAllHoaDon() {
		List<HoaDon> hoaDons = new ArrayList<>();
		String query = "SELECT * FROM HoaDon";
		try (Connection connection = MyConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(resultSet.getString("MaHoaDon"));
				hoaDon.setNgayThanhToan(resultSet.getDate("NgayThanhToan"));
				hoaDon.setMaPhieuThuePhong(resultSet.getString("MaPhieuThuePhong"));
				hoaDon.setTongTien(resultSet.getFloat("TongTien"));
				hoaDons.add(hoaDon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hoaDons;
	}

	public List<String> getAvailablePhieuThuePhong() {
		List<String> maPhieuThuePhongList = new ArrayList<>();
		String query = "SELECT MaPhieuThuePhong FROM PhieuThuePhong WHERE MaPhieuThuePhong NOT IN (SELECT MaPhieuThuePhong FROM HoaDon)";
		try (Connection connection = MyConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				maPhieuThuePhongList.add(resultSet.getString("MaPhieuThuePhong"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maPhieuThuePhongList;
	}

	public boolean createHoaDon(HoaDon hoaDon) {
		String query = "INSERT INTO HoaDon (MaHoaDon, NgayThanhToan, MaPhieuThuePhong, TongTien) "
				+ "VALUES (?, ?, ?, ?)";

		try (Connection connection = MyConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, hoaDon.getMaHoaDon());
			preparedStatement.setDate(2, new Date(hoaDon.getNgayThanhToan().getTime()));
			preparedStatement.setString(3, hoaDon.getMaPhieuThuePhong());
			preparedStatement.setFloat(4, hoaDon.getTongTien());

			int rowsInserted = preparedStatement.executeUpdate();
			return rowsInserted > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public float calculateTongTien(String maPhieuThuePhong, Date ngayThanhToan) {
		float tongTien = 0.0f;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String queryPhieuThue = "SELECT NgayDen, TienCoc, MaPhong FROM PhieuThuePhong WHERE MaPhieuThuePhong = ?";
			connection = MyConnection.getConnection();
			preparedStatement = connection.prepareStatement(queryPhieuThue);
			preparedStatement.setString(1, maPhieuThuePhong);
			resultSet = preparedStatement.executeQuery();

			Date ngayDen = null;
			float tienCoc = 0.0f;
			String maPhong = null;
			if (resultSet.next()) {
				ngayDen = resultSet.getDate("NgayDen");
				tienCoc = resultSet.getFloat("TienCoc");
				maPhong = resultSet.getString("MaPhong");
			}

			long soNgayThue = daysBetween(ngayDen, ngayThanhToan);

			float donGia = getDonGiaFromPhong(maPhong);

			float tongTienDichVu = calculateTongTienDichVu(maPhieuThuePhong);

			tongTien = (donGia * soNgayThue) + tongTienDichVu - tienCoc;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tongTien;
	}

	// Phương thức lấy đơn giá từ Phong dựa trên MaPhong
	private float getDonGiaFromPhong(String maPhong) {
		float donGia = 0.0f;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// Query để lấy đơn giá từ bảng Phong
			String query = "SELECT DonGia FROM Phong WHERE MaPhong = ?";
			connection = MyConnection.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, maPhong);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				donGia = resultSet.getFloat("DonGia");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return donGia;
	}

	private float calculateTongTienDichVu(String maPhieuThuePhong) {
		float tongTienDichVu = 0.0f;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String query = "SELECT SUM(GiaTien * SoLuong) AS TongTien FROM ChiTietDichVu "
					+ "INNER JOIN DichVu ON ChiTietDichVu.MaDichVu = DichVu.MaDichVu "
					+ "WHERE ChiTietDichVu.MaPhieuThuePhong = ?";
			connection = MyConnection.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, maPhieuThuePhong);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				tongTienDichVu = resultSet.getFloat("TongTien");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tongTienDichVu;
	}

	private long daysBetween(Date ngayDen, Date ngayThanhToan) {
		long diff = ngayThanhToan.getTime() - ngayDen.getTime();
		return diff / (24 * 60 * 60 * 1000); // Chia để lấy số ngày
	}

	public ChiTietHoaDon getChiTietHoaDon(String maHoaDon) {
		ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
		String query = "SELECT hd.MaHoaDon, kh.TenKhachHang, kh.CMND, kh.DiaChi,"
				+ " kh.Email, kh.SoDienThoai, pthp.NgayDen, hd.NgayThanhToan, p.TenPhong, p.DonGia, pthp.TienCoc, hd.TongTien "
				+ " FROM hoadon hd JOIN phieuthuephong pthp ON hd.MaPhieuThuePhong = pthp.MaPhieuThuePhong "
				+ " JOIN khachhang kh ON pthp.MaKhachHang = kh.MaKhachHang "
				+ "JOIN phong p ON pthp.MaPhong = p.MaPhong WHERE hd.MaHoaDon = ?";

		try (Connection connection = MyConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, maHoaDon);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				chiTietHoaDon.setMaHoaDon(resultSet.getString("MaHoaDon"));
				chiTietHoaDon.setTenKhachHang(resultSet.getString("TenKhachHang"));
				chiTietHoaDon.setCmnd(resultSet.getString("CMND"));
				chiTietHoaDon.setDiaChi(resultSet.getString("DiaChi"));
				chiTietHoaDon.setEmail(resultSet.getString("Email"));
				chiTietHoaDon.setSoDienThoai(resultSet.getString("SoDienThoai"));
				chiTietHoaDon.setNgayDen(resultSet.getDate("NgayDen"));
				chiTietHoaDon.setNgayThanhToan(resultSet.getDate("NgayThanhToan"));
				chiTietHoaDon.setTenPhong(resultSet.getString("TenPhong"));
				chiTietHoaDon.setDonGia(resultSet.getFloat("DonGia"));
				chiTietHoaDon.setTienCoc(resultSet.getFloat("TienCoc"));
				chiTietHoaDon.setTongTien(resultSet.getFloat("TongTien"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return chiTietHoaDon;
	}

}
