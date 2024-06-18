package model;

import java.sql.Date;

public class ChiTietHoaDon {
	private String maHoaDon;
	private String tenKhachHang;
	private String cmnd;
	private String diaChi;
	private String email;
	private String soDienThoai;
	private String tenPhong;
	private float donGia;
	private Date ngayDen;
	private Date ngayThanhToan;
	private float tienCoc;
	private float tongTien;

	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(String maHoaDon, String tenKhachHang, String cmnd, String diaChi, String email,
			String soDienThoai, String tenPhong, float donGia, Date ngayDen, Date ngayThanhToan, float tienCoc,
			float tongTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.tenKhachHang = tenKhachHang;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tenPhong = tenPhong;
		this.donGia = donGia;
		this.ngayDen = ngayDen;
		this.ngayThanhToan = ngayThanhToan;
		this.tienCoc = tienCoc;

		this.tongTien = tongTien;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public Date getNgayDen() {
		return ngayDen;
	}

	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}

	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public float getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(float tienCoc) {
		this.tienCoc = tienCoc;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [maHoaDon=" + maHoaDon + ", tenKhachHang=" + tenKhachHang + ", cmnd=" + cmnd + ", diaChi="
				+ diaChi + ", email=" + email + ", soDienThoai=" + soDienThoai + ", tenPhong=" + tenPhong + ", donGia="
				+ donGia + ", ngayDen=" + ngayDen + ", ngayThanhToan=" + ngayThanhToan + ", tienCoc=" + tienCoc
				+ ", tongTien=" + tongTien + "]";
	}

}
