
package service;

import java.sql.SQLException;
import java.util.List;

import DAO.KhachHangDAO;
import model.KhachHang;

public class KhachHangService {
	private KhachHangDAO khachHangDAO;

	public KhachHangService() {
		this.khachHangDAO = new KhachHangDAO();
	}

	public List<KhachHang> getAllKhachHang() {
		try {
			return khachHangDAO.getAllKhachHang();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean registerKhachHang(KhachHang khachHang) {
		try {
			return khachHangDAO.registerKhachHang(khachHang);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public KhachHang loginKhachHang(String taiKhoan, String matKhau) {
		return khachHangDAO.loginKhachHang(taiKhoan, matKhau);
	}

	public boolean updateKhachHang(KhachHang khachHang) {
		return khachHangDAO.updateKhachHang(khachHang);
	}

	public KhachHang getKhachHangById(String maKhachHang) {
		return khachHangDAO.getKhachHangById(maKhachHang);
	}

	public boolean isMaKhachHangExists(String maKhachHang) {
		return khachHangDAO.isMaKhachHangExists(maKhachHang);
	}

	public boolean isTaiKhoanExists(String taiKhoan) {
		return khachHangDAO.isTaiKhoanExists(taiKhoan);
	}

}
