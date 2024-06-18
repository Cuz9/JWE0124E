package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;
import model.DichVu;

public class DichVuDAO {
	public List<DichVu> getAllDichVu() {
		List<DichVu> dichVus = new ArrayList<>();
		String query = "SELECT * FROM DichVu";
		try (Connection connection = MyConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				DichVu dichVu = new DichVu();
				dichVu.setMaDichVu(resultSet.getString("MaDichVu"));
				dichVu.setTenDichVu(resultSet.getString("TenDichVu"));
				dichVu.setGiaTien(resultSet.getFloat("GiaTien"));
				dichVus.add(dichVu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dichVus;
	}

	public DichVu getDichVuById(String maDichVu) {
		DichVu dichVu = null;
		String sql = "SELECT * FROM DichVu WHERE maDichVu = ?";
		try (Connection connection = MyConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, maDichVu);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					dichVu = new DichVu();
					dichVu.setMaDichVu(resultSet.getString("maDichVu"));
					dichVu.setTenDichVu(resultSet.getString("tenDichVu"));
					dichVu.setGiaTien(resultSet.getFloat("giaTien"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dichVu;
	}

	public boolean addDichVu(DichVu dichVu) {
		String sql = "INSERT INTO DichVu (maDichVu, tenDichVu, giaTien) VALUES (?, ?, ?)";
		try (Connection connection = MyConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, dichVu.getMaDichVu());
			preparedStatement.setString(2, dichVu.getTenDichVu());
			preparedStatement.setFloat(3, dichVu.getGiaTien());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateDichVu(DichVu dichVu) {
		String sql = "UPDATE DichVu SET tenDichVu = ?, giaTien = ? WHERE maDichVu = ?";
		try (Connection connection = MyConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, dichVu.getTenDichVu());
			preparedStatement.setFloat(2, dichVu.getGiaTien());
			preparedStatement.setString(3, dichVu.getMaDichVu());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteDichVu(String maDichVu) {
		String sql = "DELETE FROM DichVu WHERE maDichVu = ?";
		try (Connection connection = MyConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, maDichVu);
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
