package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;
import model.LoaiPhong;

public class LoaiPhongDAO {
	public List<LoaiPhong> getAllLoaiPhong() {
		List<LoaiPhong> loaiPhongs = new ArrayList<>();
		String query = "SELECT * FROM LoaiPhong";
		try (Connection connection = MyConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				LoaiPhong loaiPhong = new LoaiPhong();
				loaiPhong.setMaLoaiPhong(resultSet.getString("MaLoaiPhong"));
				loaiPhong.setTenLoaiPhong(resultSet.getString("TenLoaiPhong"));
				loaiPhong.setMoTa(resultSet.getString("MoTa"));
				loaiPhongs.add(loaiPhong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loaiPhongs;
	}

	public List<String> getAllMaLoaiPhong() {
		List<String> listMaLoaiPhong = new ArrayList<>();
		String sql = "SELECT MaLoaiPhong FROM LoaiPhong";
		try (Connection conn = MyConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				listMaLoaiPhong.add(rs.getString("MaLoaiPhong"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMaLoaiPhong;
	}

	public boolean addLoaiPhong(LoaiPhong loaiPhong) {
		String sql = "INSERT INTO LoaiPhong (MaLoaiPhong, TenLoaiPhong, MoTa) VALUES (?, ?, ?)";
		try (Connection conn = MyConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, loaiPhong.getMaLoaiPhong());
			ps.setString(2, loaiPhong.getTenLoaiPhong());
			ps.setString(3, loaiPhong.getMoTa());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateLoaiPhong(LoaiPhong loaiPhong) {
		String sql = "UPDATE LoaiPhong SET TenLoaiPhong = ?, MoTa = ? WHERE MaLoaiPhong = ?";
		try (Connection conn = MyConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, loaiPhong.getTenLoaiPhong());
			ps.setString(2, loaiPhong.getMoTa());
			ps.setString(3, loaiPhong.getMaLoaiPhong());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteLoaiPhong(String maLoaiPhong) {
		String sql = "DELETE FROM LoaiPhong WHERE MaLoaiPhong = ?";
		try (Connection conn = MyConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, maLoaiPhong);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public LoaiPhong getLoaiPhongById(String maLoaiPhong) {
		String sql = "SELECT * FROM LoaiPhong WHERE MaLoaiPhong = ?";
		try (Connection conn = MyConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, maLoaiPhong);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					LoaiPhong lp = new LoaiPhong();
					lp.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
					lp.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
					lp.setMoTa(rs.getString("MoTa"));
					return lp;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
