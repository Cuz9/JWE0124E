package model;

public class Phong {
	private String maPhong;
	private String maLoaiPhong;
	private String tenPhong;
	private String hinhAnh;
	private int sucChua;
	private float donGia;
	private String moTa;
	private boolean tinhTrang;

	public Phong() {
	}

	public Phong(String maPhong, String maLoaiPhong, String tenPhong, String hinhAnh, int sucChua, float donGia,
			String moTa, boolean tinhTrang) {
		this.maPhong = maPhong;
		this.maLoaiPhong = maLoaiPhong;
		this.tenPhong = tenPhong;
		this.hinhAnh = hinhAnh;
		this.sucChua = sucChua;
		this.donGia = donGia;
		this.moTa = moTa;
		this.tinhTrang = tinhTrang;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", maLoaiPhong=" + maLoaiPhong + ", tenPhong=" + tenPhong + ", hinhAnh="
				+ hinhAnh + ", sucChua=" + sucChua + ", donGia=" + donGia + ", moTa=" + moTa + ", tinhTrang="
				+ tinhTrang + "]";
	}
}
