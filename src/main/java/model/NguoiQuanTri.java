package model;

public class NguoiQuanTri {
	private String taiKhoan;
	private String matKhau;
	private String tenNguoiQuanTri;
	private boolean gioiTinh;
	private String cmnd;
	private String diaChi;
	private String email;
	private String soDienThoai;

	// Default constructor
	public NguoiQuanTri() {
	}

	// Parameterized constructor
	public NguoiQuanTri(String taiKhoan, String matKhau, String tenNguoiQuanTri, boolean gioiTinh, String cmnd,
			String diaChi, String email, String soDienThoai) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.tenNguoiQuanTri = tenNguoiQuanTri;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}

	// Getter and Setter methods
	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenNguoiQuanTri() {
		return tenNguoiQuanTri;
	}

	public void setTenNguoiQuanTri(String tenNguoiQuanTri) {
		this.tenNguoiQuanTri = tenNguoiQuanTri;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
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

	@Override
	public String toString() {
		return "NguoiQuanTri [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", tenNguoiQuanTri=" + tenNguoiQuanTri
				+ ", gioiTinh=" + gioiTinh + ", cmnd=" + cmnd + ", diaChi=" + diaChi + ", email=" + email
				+ ", soDienThoai=" + soDienThoai + "]";
	}
}
