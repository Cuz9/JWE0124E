
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;
import model.KhachHang;

public class KhachHangDAO {
	private Connection connection;

	public KhachHangDAO() {
		connection = MyConnection.getConnection();
	}

	public boolean registerKhachHang(KhachHang khachHang) throws SQLException {
		String sql = "INSERT INTO KhachHang(maKhachHang, taiKhoan, matKhau, tenKhachHang, gioiTinh, cmnd, diaChi, email, soDienThoai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = MyConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, khachHang.getMaKhachHang());
			ps.setString(2, khachHang.getTaiKhoan());
			ps.setString(3, khachHang.getMatKhau());
			ps.setString(4, khachHang.getTenKhachHang());
			ps.setBoolean(5, khachHang.getGioiTinh());
			ps.setString(6, khachHang.getCmnd());
			ps.setString(7, khachHang.getDiaChi());
			ps.setString(8, khachHang.getEmail());
			ps.setString(9, khachHang.getSoDienThoai());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<KhachHang> getAllKhachHang() throws SQLException {
		List<KhachHang> khachHangList = new ArrayList<>();
		String query = "SELECT * FROM KhachHang";
		try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
			while (resultSet.next()) {
				KhachHang khachHang = new KhachHang(resultSet.getString("MaKhachHang"), resultSet.getString("TaiKhoan"),
						resultSet.getString("MatKhau"), resultSet.getString("TenKhachHang"),
						resultSet.getBoolean("GioiTinh"), resultSet.getString("CMND"), resultSet.getString("DiaChi"),
						resultSet.getString("Email"), resultSet.getString("SoDienThoai"));
				khachHangList.add(khachHang);
			}
		}
		return khachHangList;
	}

	public KhachHang loginKhachHang(String taiKhoan, String matKhau) {
		String sql = "SELECT * FROM KhachHang WHERE taiKhoan = ? AND matKhau = ?";
		try (Connection conn = MyConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, taiKhoan);
			ps.setString(2, matKhau);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new KhachHang(rs.getString("maKhachHang"), rs.getString("taiKhoan"), rs.getString("matKhau"),
							rs.getString("tenKhachHang"), rs.getBoolean("gioiTinh"), rs.getString("cmnd"),
							rs.getString("diaChi"), rs.getString("email"), rs.getString("soDienThoai"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateKhachHang(KhachHang khachHang) {
		String sql = "UPDATE KhachHang SET TaiKhoan = ?, MatKhau = ?, TenKhachHang = ?, GioiTinh = ?, CMND = ?, DiaChi = ?, Email = ?, SoDienThoai = ? WHERE MaKhachHang = ?";
		try (Connection conn = MyConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, khachHang.getTaiKhoan());
			ps.setString(2, khachHang.getMatKhau());
			ps.setString(3, khachHang.getTenKhachHang());
			ps.setBoolean(4, khachHang.getGioiTinh());
			ps.setString(5, khachHang.getCmnd());
			ps.setString(6, khachHang.getDiaChi());
			ps.setString(7, khachHang.getEmail());
			ps.setString(8, khachHang.getSoDienThoai());
			ps.setString(9, khachHang.getMaKhachHang());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public KhachHang getKhachHangById(String maKhachHang) {
		String sql = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";
		try (Connection conn = MyConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, maKhachHang);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					KhachHang kh = new KhachHang();
					kh.setMaKhachHang(rs.getString("MaKhachHang"));
					kh.setTaiKhoan(rs.getString("TaiKhoan"));
					kh.setMatKhau(rs.getString("MatKhau"));
					kh.setTenKhachHang(rs.getString("TenKhachHang"));
					kh.setGioiTinh(rs.getBoolean("GioiTinh"));
					kh.setCmnd(rs.getString("CMND"));
					kh.setDiaChi(rs.getString("DiaChi"));
					kh.setEmail(rs.getString("Email"));
					kh.setSoDienThoai(rs.getString("SoDienThoai"));
					return kh;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
