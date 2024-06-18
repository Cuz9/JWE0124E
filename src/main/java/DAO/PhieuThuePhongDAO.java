package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;
import model.PhieuThuePhong;

public class PhieuThuePhongDAO {
	public List<PhieuThuePhong> getAllPhieuThuePhong() {
		List<PhieuThuePhong> phieuThuePhongs = new ArrayList<>();
		String query = "SELECT * FROM PhieuThuePhong";
		try (Connection connection = MyConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				PhieuThuePhong phieuThuePhong = new PhieuThuePhong();
				phieuThuePhong.setMaPhieuThuePhong(resultSet.getString("MaPhieuThuePhong"));
				phieuThuePhong.setMaPhong(resultSet.getString("MaPhong"));
				phieuThuePhong.setMaKhachHang(resultSet.getString("MaKhachHang"));
				phieuThuePhong.setNgayDen(resultSet.getDate("NgayDen"));
				phieuThuePhong.setTienCoc(resultSet.getFloat("TienCoc"));
				phieuThuePhongs.add(phieuThuePhong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phieuThuePhongs;
	}
}
