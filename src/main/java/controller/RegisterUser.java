package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.KhachHang;
import service.KhachHangService;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/dangky")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private KhachHangService khachHangService = new KhachHangService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("user/registeruser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maKhachHang = request.getParameter("maKhachHang");
		String taiKhoan = request.getParameter("taiKhoan");
		String matKhau = request.getParameter("matKhau");
		String tenKhachHang = request.getParameter("tenKhachHang");
		String gioiTinhStr = request.getParameter("gioiTinh");
		boolean gioiTinh = "true".equals(gioiTinhStr);
		String cmnd = request.getParameter("cmnd");
		String diaChi = request.getParameter("diaChi");
		String email = request.getParameter("email");
		String soDienThoai = request.getParameter("soDienThoai");

		if (khachHangService.isMaKhachHangExists(maKhachHang)) {
			request.setAttribute("error", "Mã khách hàng đã tồn tại. Vui lòng chọn mã khách hàng khác.");
			request.getRequestDispatcher("user/registeruser.jsp").forward(request, response);
			return;
		}

		if (khachHangService.isTaiKhoanExists(taiKhoan)) {
			request.setAttribute("error", "Tài khoản đã tồn tại. Vui lòng chọn tài khoản khác.");
			request.getRequestDispatcher("user/registeruser.jsp").forward(request, response);
			return;
		}

		KhachHang khachHang = new KhachHang(maKhachHang, taiKhoan, matKhau, tenKhachHang, gioiTinh, cmnd, diaChi, email,
				soDienThoai);

		if (khachHangService.registerKhachHang(khachHang)) {
			response.sendRedirect("dangnhap");
		} else {
			request.setAttribute("error", "Đăng ký thất bại. Vui lòng kiểm tra lại thông tin.");
			request.getRequestDispatcher("user/registeruser.jsp").forward(request, response);
		}
	}
}
