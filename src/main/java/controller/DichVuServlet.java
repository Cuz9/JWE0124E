package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DichVu;
import service.DichVuService;

@WebServlet("/dichvu")
public class DichVuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DichVuService dichVuService = new DichVuService();

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
			deleteDichVu(request, response);
			break;
		default:
			displayAllDichVu(request, response);
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
			addDichVu(request, response);
			break;
		case "update":
			updateDichVu(request, response);
			break;
		default:
			displayAllDichVu(request, response);
			break;
		}
	}

	private void displayAllDichVu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DichVu> dichVuList = dichVuService.getAllDichVu();
		request.setAttribute("dichVuList", dichVuList);
		request.getRequestDispatcher("admin/dichvu/listdichvu.jsp").forward(request, response);
	}

	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("admin/dichvu/adddichvu.jsp").forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maDichVu = request.getParameter("maDichVu");
		DichVu dichVu = dichVuService.getDichVuById(maDichVu);
		request.setAttribute("dichVu", dichVu);
		request.getRequestDispatcher("admin/dichvu/editdichvu.jsp").forward(request, response);
	}

	private void addDichVu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maDichVu = request.getParameter("maDichVu");
		String tenDichVu = request.getParameter("tenDichVu");
		float giaTien = Float.parseFloat(request.getParameter("giaTien"));

		DichVu dichVu = new DichVu(maDichVu, tenDichVu, giaTien);
		if (dichVuService.addDichVu(dichVu)) {
			response.sendRedirect(request.getContextPath() + "/dichvu");
		} else {
			request.setAttribute("error", "Thêm dịch vụ thất bại");
			request.getRequestDispatcher("admin/dichvu/adddichvu.jsp").forward(request, response);
		}
	}

	private void updateDichVu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maDichVu = request.getParameter("maDichVu");
		String tenDichVu = request.getParameter("tenDichVu");
		float giaTien = Float.parseFloat(request.getParameter("giaTien"));

		DichVu dichVu = new DichVu(maDichVu, tenDichVu, giaTien);
		if (dichVuService.updateDichVu(dichVu)) {
			response.sendRedirect(request.getContextPath() + "/dichvu");
		} else {
			request.setAttribute("error", "Cập nhật dịch vụ thất bại");
			request.setAttribute("dichVu", dichVu);
			request.getRequestDispatcher("admin/dichvu/editdichvu.jsp").forward(request, response);
		}
	}

	private void deleteDichVu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maDichVu = request.getParameter("maDichVu");
		if (dichVuService.deleteDichVu(maDichVu)) {
			response.sendRedirect(request.getContextPath() + "/dichvu");
		} else {
			request.setAttribute("error", "Xóa dịch vụ thất bại");
			displayAllDichVu(request, response);
		}
	}
}
