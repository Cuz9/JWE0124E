package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;
import model.ChiTietDichVu;

public class ChiTietDichVuDAO {
	public List<ChiTietDichVu> getAllChiTietDichVu() {
		List<ChiTietDichVu> chiTietDichVus = new ArrayList<>();
		String query = "SELECT * FROM ChiTietDichVu";
		try (Connection connection = MyConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				ChiTietDichVu chiTietDichVu = new ChiTietDichVu();
				chiTietDichVu.setMaPhieuThuePhong(resultSet.getString("MaPhieuThuePhong"));
				chiTietDichVu.setMaDichVu(resultSet.getString("MaDichVu"));
				chiTietDichVu.setSoLuong(resultSet.getInt("SoLuong"));
				chiTietDichVus.add(chiTietDichVu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chiTietDichVus;
	}
}
