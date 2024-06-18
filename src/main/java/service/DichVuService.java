package service;

import java.util.List;

import DAO.DichVuDAO;
import model.DichVu;

public class DichVuService {
	private DichVuDAO dichVuDAO;

	public DichVuService() {
		dichVuDAO = new DichVuDAO();
	}

	public List<DichVu> getAllDichVu() {
		return dichVuDAO.getAllDichVu();
	}

	public DichVu getDichVuById(String maDichVu) {
		return dichVuDAO.getDichVuById(maDichVu);
	}

	public boolean addDichVu(DichVu dichVu) {
		return dichVuDAO.addDichVu(dichVu);
	}

	public boolean updateDichVu(DichVu dichVu) {
		return dichVuDAO.updateDichVu(dichVu);
	}

	public boolean deleteDichVu(String maDichVu) {
		return dichVuDAO.deleteDichVu(maDichVu);
	}
}
