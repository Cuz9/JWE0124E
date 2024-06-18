package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Phong;
import service.LoaiPhongService;
import service.PhongService;

@WebServlet("/phong")
public class PhongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhongService phongService = new PhongService();
	private LoaiPhongService loaiPhongService = new LoaiPhongService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("adminLoggedIn") == null) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}

		switch (action) {
		case "edit":
			showEditForm(request, response);
			break;
		case "delete":
			deletePhong(request, response);
			break;
		case "create":
			showCreateForm(request, response);
			break;
		default:
			listPhongs(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("adminLoggedIn") == null) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}

		switch (action) {
		case "create":
			createPhong(request, response);
			break;
		case "update":
			updatePhong(request, response);
			break;
		default:
			listPhongs(request, response);
			break;
		}
	}

	private void listPhongs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Phong> listPhongs = phongService.getAllPhongs();
		request.setAttribute("listPhongs", listPhongs);
		request.getRequestDispatcher("admin/phong/listphong.jsp").forward(request, response);
	}

	private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> listMaLoaiPhong = loaiPhongService.getAllMaLoaiPhong();
		request.setAttribute("listMaLoaiPhong", listMaLoaiPhong);
		request.getRequestDispatcher("admin/phong/addphong.jsp").forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maPhong = request.getParameter("maPhong");
		Phong phong = phongService.getPhongById(maPhong);
		request.setAttribute("phong", phong);
		List<String> listMaLoaiPhong = loaiPhongService.getAllMaLoaiPhong();
		request.setAttribute("listMaLoaiPhong", listMaLoaiPhong);
		request.getRequestDispatcher("admin/phong/editphong.jsp").forward(request, response);
	}

	private void createPhong(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maPhong = request.getParameter("maPhong");
		String maLoaiPhong = request.getParameter("maLoaiPhong");
		String tenPhong = request.getParameter("tenPhong");
		String hinhAnh = request.getParameter("hinhAnh");
		int sucChua = Integer.parseInt(request.getParameter("sucChua"));
		float donGia = Float.parseFloat(request.getParameter("donGia"));
		String moTa = request.getParameter("moTa");
		boolean tinhTrang = Boolean.parseBoolean(request.getParameter("tinhTrang"));

		Phong phong = new Phong(maPhong, maLoaiPhong, tenPhong, hinhAnh, sucChua, donGia, moTa, tinhTrang);

		if (phongService.createPhong(phong)) {
			response.sendRedirect(request.getContextPath() + "/phong");
		} else {
			request.setAttribute("error", "Thêm phòng thất bại");
			request.getRequestDispatcher("admin/phong/addphong.jsp").forward(request, response);
		}
	}

	private void updatePhong(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maPhong = request.getParameter("maPhong");
		String maLoaiPhong = request.getParameter("maLoaiPhong");
		String tenPhong = request.getParameter("tenPhong");
		String hinhAnh = request.getParameter("hinhAnh");
		int sucChua = Integer.parseInt(request.getParameter("sucChua"));
		float donGia = Float.parseFloat(request.getParameter("donGia"));
		String moTa = request.getParameter("moTa");
		boolean tinhTrang = Boolean.parseBoolean(request.getParameter("tinhTrang"));

		Phong phong = new Phong(maPhong, maLoaiPhong, tenPhong, hinhAnh, sucChua, donGia, moTa, tinhTrang);

		if (phongService.updatePhong(phong)) {
			response.sendRedirect(request.getContextPath() + "/phong");
		} else {
			request.setAttribute("error", "Cập nhật phòng thất bại");
			request.getRequestDispatcher("admin/phong/editphong.jsp").forward(request, response);
		}
	}

	private void deletePhong(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maPhong = request.getParameter("maPhong");

		if (phongService.deletePhong(maPhong)) {
			response.sendRedirect(request.getContextPath() + "/phong");
		} else {
			request.setAttribute("error", "Xóa phòng thất bại");
			request.getRequestDispatcher("admin/phong/listphong.jsp").forward(request, response);
		}
	}
}
