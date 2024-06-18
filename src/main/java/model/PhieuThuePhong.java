package model;

import java.sql.Date;

public class PhieuThuePhong {
	private String maPhieuThuePhong;
	private String maPhong;
	private String maKhachHang;
	private Date ngayDen;
	private float tienCoc;

	public PhieuThuePhong() {
	}

	public PhieuThuePhong(String maPhieuThuePhong, String maPhong, String maKhachHang, Date ngayDen, float tienCoc) {
		this.maPhieuThuePhong = maPhieuThuePhong;
		this.maPhong = maPhong;
		this.maKhachHang = maKhachHang;
		this.ngayDen = ngayDen;
		this.tienCoc = tienCoc;
	}

	public String getMaPhieuThuePhong() {
		return maPhieuThuePhong;
	}

	public void setMaPhieuThuePhong(String maPhieuThuePhong) {
		this.maPhieuThuePhong = maPhieuThuePhong;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public Date getNgayDen() {
		return ngayDen;
	}

	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}

	public float getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(float tienCoc) {
		this.tienCoc = tienCoc;
	}

	@Override
	public String toString() {
		return "PhieuThuePhong [maPhieuThuePhong=" + maPhieuThuePhong + ", maPhong=" + maPhong + ", maKhachHang="
				+ maKhachHang + ", ngayDen=" + ngayDen + ", tienCoc=" + tienCoc + "]";
	}
}
