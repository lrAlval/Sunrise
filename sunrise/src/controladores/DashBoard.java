package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DashBoardDao;

@WebServlet("/DashBoard")
public class DashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DashBoardDao dao;

	public DashBoard() {
		dao = new DashBoardDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String action = req.getParameter("info");
		res.setContentType("application/json");

		switch (action) {
			case "Pagos":    res.getWriter().print(dao.getPagos());    break;
			case "Reservas": res.getWriter().print(dao.getReservas()); break;
			case "Estadias": res.getWriter().print(dao.getEstadias()); break;
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

	}

}
