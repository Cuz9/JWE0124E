package model;

public class ChiTietDichVu {
	private String maPhieuThuePhong;
	private String maDichVu;
	private int soLuong;

	// Default constructor
	public ChiTietDichVu() {
	}

	// Parameterized constructor
	public ChiTietDichVu(String maPhieuThuePhong, String maDichVu, int soLuong) {
		this.maPhieuThuePhong = maPhieuThuePhong;
		this.maDichVu = maDichVu;
		this.soLuong = soLuong;
	}

	// Getter and Setter methods
	public String getMaPhieuThuePhong() {
		return maPhieuThuePhong;
	}

	public void setMaPhieuThuePhong(String maPhieuThuePhong) {
		this.maPhieuThuePhong = maPhieuThuePhong;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
}