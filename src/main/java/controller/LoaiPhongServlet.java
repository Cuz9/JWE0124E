package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoaiPhong;
import service.LoaiPhongService;

/**
 * Servlet implementation class LoaiPhongServlet
 */
@WebServlet("/loaiphong")
public class LoaiPhongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoaiPhongService loaiPhongService;

	public LoaiPhongServlet() {
		this.loaiPhongService = new LoaiPhongService();
	}

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
		case "add":
			showAddForm(request, response);
			break;
		case "edit":
			showEditForm(request, response);
			break;
		case "delete":
			deleteLoaiPhong(request, response);
			break;
		default:
			displayAllLoaiPhong(request, response);
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
		case "add":
			addLoaiPhong(request, response);
			break;
		case "edit":
			updateLoaiPhong(request, response);
			break;
		default:
			doGet(request, response);
			break;
		}
	}

	private void displayAllLoaiPhong(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<LoaiPhong> loaiPhongList = loaiPhongService.getAllLoaiPhong();
		request.setAttribute("loaiPhongList", loaiPhongList);
		request.getRequestDispatcher("admin/loaiphong/listloaiphong.jsp").forward(request, response);
	}

	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("admin/loaiphong/addloaiphong.jsp").forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maLoaiPhong = request.getParameter("maLoaiPhong");
		LoaiPhong loaiPhong = loaiPhongService.getLoaiPhongById(maLoaiPhong);
		request.setAttribute("loaiPhong", loaiPhong);
		request.getRequestDispatcher("admin/loaiphong/editloaiphong.jsp").forward(request, response);
	}

	private void addLoaiPhong(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maLoaiPhong = request.getParameter("maLoaiPhong");
		String tenLoaiPhong = request.getParameter("tenLoaiPhong");
		String moTa = request.getParameter("moTa");

		LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPhong, moTa);

		if (loaiPhongService.addLoaiPhong(loaiPhong)) {
			response.sendRedirect(request.getContextPath() + "/loaiphong");
		} else {
			request.setAttribute("error", "Thêm loại phòng thất bại");
			request.getRequestDispatcher("admin/loaiphong/addloaiphong.jsp").forward(request, response);
		}
	}

	private void updateLoaiPhong(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maLoaiPhong = request.getParameter("maLoaiPhong");
		String tenLoaiPhong = request.getParameter("tenLoaiPhong");
		String moTa = request.getParameter("moTa");

		LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPhong, moTa);

		if (loaiPhongService.updateLoaiPhong(loaiPhong)) {
			response.sendRedirect(request.getContextPath() + "/loaiphong");
		} else {
			request.setAttribute("error", "Cập nhật loại phòng thất bại");
			request.setAttribute("loaiPhong", loaiPhong);
			request.getRequestDispatcher("admin/loaiphong/editloaiphong.jsp").forward(request, response);
		}
	}

	private void deleteLoaiPhong(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maLoaiPhong = request.getParameter("maLoaiPhong");

		if (loaiPhongService.deleteLoaiPhong(maLoaiPhong)) {
			response.sendRedirect(request.getContextPath() + "/loaiphong");
		} else {
			request.setAttribute("error", "Xóa loại phòng thất bại");
			displayAllLoaiPhong(request, response);
		}
	}
}
