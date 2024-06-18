package model;

import java.sql.Date;

public class HoaDon {
	private String maHoaDon;
	private Date ngayThanhToan;
	private String maPhieuThuePhong;
	private float tongTien;

	public HoaDon() {
	}

	public HoaDon(String maHoaDon, Date ngayThanhToan, String maPhieuThuePhong, float tongTien) {
		this.maHoaDon = maHoaDon;
		this.ngayThanhToan = ngayThanhToan;
		this.maPhieuThuePhong = maPhieuThuePhong;
		this.tongTien = tongTien;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public String getMaPhieuThuePhong() {
		return maPhieuThuePhong;
	}

	public void setMaPhieuThuePhong(String maPhieuThuePhong) {
		this.maPhieuThuePhong = maPhieuThuePhong;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayThanhToan=" + ngayThanhToan + ", maPhieuThuePhong="
				+ maPhieuThuePhong + ", tongTien=" + tongTien + "]";
	}
}
