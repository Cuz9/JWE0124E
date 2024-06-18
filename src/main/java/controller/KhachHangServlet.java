package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.KhachHang;
import service.KhachHangService;

/**
 * Servlet implementation class KhachHangServlet
 */
@WebServlet("/khachhang")
public class KhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachHangService khachHangService = new KhachHangService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KhachHangServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("adminLoggedIn") == null) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch (action) {
		case "edit":
			showEditForm(request, response);
			break;
		default:
			displayAllKhachHang(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("adminLoggedIn") == null) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}

		switch (action) {
		case "update":
			updateKhachHang(request, response);
			break;
		default:
			displayAllKhachHang(request, response);
			break;
		}
	}

	private void displayAllKhachHang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<KhachHang> khachHangList = khachHangService.getAllKhachHang();
		request.setAttribute("khachHangList", khachHangList);
		request.getRequestDispatcher("admin/khachhang/listkhachhang.jsp").forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maKhachHang = request.getParameter("maKhachHang");
		KhachHang khachHang = khachHangService.getKhachHangById(maKhachHang);
		request.setAttribute("khachHang", khachHang);
		request.getRequestDispatcher("admin/khachhang/editkhachhang.jsp").forward(request, response);
	}

	private void updateKhachHang(HttpServletRequest request, HttpServletResponse response)
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
		if (khachHangService.updateKhachHang(khachHang)) {
			response.sendRedirect(request.getContextPath() + "/khachhang");
		} else {
			request.setAttribute("error", "Cập nhật khách hàng thất bại");
			request.setAttribute("khachHang", khachHang);
			request.getRequestDispatcher("admin/khachhang/editkhachhang.jsp").forward(request, response);
		}
	}
}
