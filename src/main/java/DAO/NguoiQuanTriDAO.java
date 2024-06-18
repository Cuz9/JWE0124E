package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.MyConnection;
import model.NguoiQuanTri;

public class NguoiQuanTriDAO {
	public NguoiQuanTri login(String taiKhoan, String matKhau) {
		Connection conn = MyConnection.getConnection();
		String sql = "SELECT * FROM NguoiQuanTri WHERE TaiKhoan = ? AND MatKhau = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, taiKhoan);
			ps.setString(2, matKhau);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				NguoiQuanTri admin = new NguoiQuanTri();
				admin.setTaiKhoan(rs.getString("TaiKhoan"));
				admin.setMatKhau(rs.getString("MatKhau"));
				admin.setTenNguoiQuanTri(rs.getString("TenNguoiQuanTri"));
				admin.setGioiTinh(rs.getBoolean("GioiTinh"));
				admin.setCmnd(rs.getString("CMND"));
				admin.setDiaChi(rs.getString("DiaChi"));
				admin.setEmail(rs.getString("Email"));
				admin.setSoDienThoai(rs.getString("SoDienThoai"));
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
