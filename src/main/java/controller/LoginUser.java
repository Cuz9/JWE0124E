package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.KhachHang;
import service.KhachHangService;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/dangnhap")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachHangService khachHangService = new KhachHangService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("user/loginuser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String taiKhoan = request.getParameter("taiKhoan");
		String matKhau = request.getParameter("matKhau");

		KhachHang khachHang = khachHangService.loginKhachHang(taiKhoan, matKhau);
		if (khachHang != null) {
			HttpSession session = request.getSession();
			session.setAttribute("khachHang", khachHang);
			response.sendRedirect(request.getContextPath() + "/user/home.jsp");
		} else {
			request.setAttribute("error", "Đăng nhập thất bại");
			request.getRequestDispatcher("user/loginuser.jsp").forward(request, response);
		}
	}
}