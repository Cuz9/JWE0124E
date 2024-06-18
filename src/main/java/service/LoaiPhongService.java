package service;

import java.util.List;

import DAO.LoaiPhongDAO;
import model.LoaiPhong;

public class LoaiPhongService {
	private LoaiPhongDAO loaiPhongDAO;

	public LoaiPhongService() {
		loaiPhongDAO = new LoaiPhongDAO();
	}

	public List<LoaiPhong> getAllLoaiPhong() {
		return loaiPhongDAO.getAllLoaiPhong();
	}

	public List<String> getAllMaLoaiPhong() {
		return loaiPhongDAO.getAllMaLoaiPhong();
	}

	public boolean addLoaiPhong(LoaiPhong loaiPhong) {
		return loaiPhongDAO.addLoaiPhong(loaiPhong);
	}

	public boolean updateLoaiPhong(LoaiPhong loaiPhong) {
		return loaiPhongDAO.updateLoaiPhong(loaiPhong);
	}

	public boolean deleteLoaiPhong(String maLoaiPhong) {
		return loaiPhongDAO.deleteLoaiPhong(maLoaiPhong);
	}

	public LoaiPhong getLoaiPhongById(String maLoaiPhong) {
		return loaiPhongDAO.getLoaiPhongById(maLoaiPhong);
	}
}
