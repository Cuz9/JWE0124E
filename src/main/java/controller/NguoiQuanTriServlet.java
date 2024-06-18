package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.NguoiQuanTri;
import service.NguoiQuanTriService;

/**
 * Servlet implementation class NguoiQuanTriServlet
 */
@WebServlet("/admin")
public class NguoiQuanTriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NguoiQuanTriService nguoiQuanTriService = new NguoiQuanTriService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch (action) {
		default:
			showLoginForm(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("login".equals(action)) {
			login(request, response);
		} else {
			doGet(request, response);
		}
	}

	private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("admin/login.jsp").forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String taiKhoan = request.getParameter("taiKhoan");
		String matKhau = request.getParameter("matKhau");
		NguoiQuanTri admin = nguoiQuanTriService.login(taiKhoan, matKhau);
		if (admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("adminLoggedIn", true);
			session.setAttribute("adminUsername", taiKhoan);

			response.sendRedirect("admin/dashboard.jsp");
		} else {
			request.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);
		}
	}
}
