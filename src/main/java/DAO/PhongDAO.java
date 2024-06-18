package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;
import model.Phong;

public class PhongDAO {
	private Connection connection;

	public PhongDAO() {
		connection = MyConnection.getConnection();
	}

	public List<Phong> getAllPhongs() {
		List<Phong> listPhongs = new ArrayList<>();
		String query = "SELECT * FROM phong";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Phong phong = new Phong();
				phong.setMaPhong(rs.getString("maPhong"));
				phong.setMaLoaiPhong(rs.getString("maLoaiPhong"));
				phong.setTenPhong(rs.getString("tenPhong"));
				phong.setHinhAnh(rs.getString("hinhAnh"));
				phong.setSucChua(rs.getInt("sucChua"));
				phong.setDonGia(rs.getFloat("donGia"));
				phong.setMoTa(rs.getString("moTa"));
				phong.setTinhTrang(rs.getBoolean("tinhTrang"));
				listPhongs.add(phong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPhongs;
	}

	public Phong getPhongById(String maPhong) {
		Phong phong = null;
		String query = "SELECT * FROM phong WHERE maPhong = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, maPhong);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				phong = new Phong();
				phong.setMaPhong(rs.getString("maPhong"));
				phong.setMaLoaiPhong(rs.getString("maLoaiPhong"));
				phong.setTenPhong(rs.getString("tenPhong"));
				phong.setHinhAnh(rs.getString("hinhAnh"));
				phong.setSucChua(rs.getInt("sucChua"));
				phong.setDonGia(rs.getFloat("donGia"));
				phong.setMoTa(rs.getString("moTa"));
				phong.setTinhTrang(rs.getBoolean("tinhTrang"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phong;
	}

	public boolean createPhong(Phong phong) {
		String query = "INSERT INTO phong (maPhong, maLoaiPhong, tenPhong, hinhAnh, sucChua, donGia, moTa, tinhTrang)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, phong.getMaPhong());
			preparedStatement.setString(2, phong.getMaLoaiPhong());
			preparedStatement.setString(3, phong.getTenPhong());
			preparedStatement.setString(4, phong.getHinhAnh());
			preparedStatement.setInt(5, phong.getSucChua());
			preparedStatement.setFloat(6, phong.getDonGia());
			preparedStatement.setString(7, phong.getMoTa());
			preparedStatement.setBoolean(8, phong.isTinhTrang());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatePhong(Phong phong) {
		String query = "UPDATE phong SET maLoaiPhong = ?, tenPhong = ?, hinhAnh = ?, sucChua = ?,"
				+ " donGia = ?, moTa = ?, tinhTrang = ? WHERE maPhong = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, phong.getMaLoaiPhong());
			preparedStatement.setString(2, phong.getTenPhong());
			preparedStatement.setString(3, phong.getHinhAnh());
			preparedStatement.setInt(4, phong.getSucChua());
			preparedStatement.setFloat(5, phong.getDonGia());
			preparedStatement.setString(6, phong.getMoTa());
			preparedStatement.setBoolean(7, phong.isTinhTrang());
			preparedStatement.setString(8, phong.getMaPhong());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePhong(String maPhong) {
		String query = "DELETE FROM phong WHERE maPhong = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, maPhong);

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
