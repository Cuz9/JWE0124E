package service;

import java.util.List;

import DAO.PhieuThuePhongDAO;
import model.PhieuThuePhong;

public class PhieuThuePhongService {
	private PhieuThuePhongDAO phieuThuePhongDAO;

	public PhieuThuePhongService() {
		phieuThuePhongDAO = new PhieuThuePhongDAO();
	}

	public List<PhieuThuePhong> getAllPhieuThuePhong() {
		return phieuThuePhongDAO.getAllPhieuThuePhong();
	}
}
