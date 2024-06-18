package service;

import java.util.List;

import DAO.ChiTietDichVuDAO;
import model.ChiTietDichVu;

public class ChiTietDichVuService {
	private ChiTietDichVuDAO chiTietDichVuDAO;

	public ChiTietDichVuService() {
		chiTietDichVuDAO = new ChiTietDichVuDAO();
	}

	public List<ChiTietDichVu> getAllChiTietDichVu() {
		return chiTietDichVuDAO.getAllChiTietDichVu();
	}
}
