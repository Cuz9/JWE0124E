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
		Boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
		String cmnd = request.getParameter("cmnd");
		String diaChi = request.getParameter("diaChi");
		String email = request.getParameter("email");
		String soDienThoai = request.getParameter("soDienThoai");

		KhachHang khachHang = new KhachHang(maKhachHang, taiKhoan, matKhau, tenKhachHang, gioiTinh, cmnd, diaChi, email,
				soDienThoai);
		if (khachHangService.registerKhachHang(khachHang)) {
			response.sendRedirect("dangnhap?action=login");
		} else {
			request.setAttribute("error", "Đăng ký thất bại");
			request.getRequestDispatcher("user/registeruser.jsp").forward(request, response);
		}
	}
}
