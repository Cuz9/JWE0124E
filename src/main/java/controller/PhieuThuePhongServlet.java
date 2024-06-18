package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PhieuThuePhong;
import service.PhieuThuePhongService;

@WebServlet("/phieuthuephong")
public class PhieuThuePhongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhieuThuePhongService phieuThuePhongService = new PhieuThuePhongService();

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
		default:
			displayAllPhieuThuePhong(request, response);
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
		doGet(request, response);
	}

	private void displayAllPhieuThuePhong(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PhieuThuePhong> phieuThuePhongList = phieuThuePhongService.getAllPhieuThuePhong();
		request.setAttribute("phieuThuePhongList", phieuThuePhongList);
		request.getRequestDispatcher("admin/phieuthuephong/listphieuthuephong.jsp").forward(request, response);
	}
}
