package service;

import DAO.NguoiQuanTriDAO;
import model.NguoiQuanTri;

public class NguoiQuanTriService {
	private NguoiQuanTriDAO nguoiQuanTriDAO = new NguoiQuanTriDAO();

	public NguoiQuanTri login(String taiKhoan, String matKhau) {
		return nguoiQuanTriDAO.login(taiKhoan, matKhau);
	}
}
