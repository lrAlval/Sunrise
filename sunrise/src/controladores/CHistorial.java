package controladores;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import libs.Read;
import modelos.Historial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daos.HistorialDao;

@WebServlet("/CHistorial")
public class CHistorial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	List<Historial> lstHistorial = new ArrayList<Historial>();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private HistorialDao historialDao;

	public CHistorial() {
		historialDao = new HistorialDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String action = req.getParameter("action");

		res.setContentType("application/json");

		switch (action) {
		case "list":
			Listado(req, res);
			break;
		case "create":
		case "update":
			upsert(req, res, action);
			break;
		case "delete":
			Delete(req, res);
			break;
		}

	}

	void Listado(HttpServletRequest req, HttpServletResponse res)
			throws IOException {

		int startPageIndex = Integer.parseInt(req.getParameter("jtStartIndex"));
		int recordsPerPage = Integer.parseInt(req.getParameter("jtPageSize"));

		lstHistorial = historialDao.getAllRooms(startPageIndex, recordsPerPage);
		// lstHistorial=historialDao.getAllRooms();

		System.out.print("saliendo de lista" + lstHistorial.size());

		int total = historialDao.getTotalRecordCount();

		// Return in the format required by jTable plugin
		JSONROOT.put("Result", "OK");
		JSONROOT.put("Records", lstHistorial);
		JSONROOT.put("TotalRecordCount", total);

		// Convert Java Object to Json
		String jsonArray = gson.toJson(JSONROOT);

		res.getWriter().print(jsonArray);
	}

	void upsert(HttpServletRequest req, HttpServletResponse res, String action)
			throws IOException {
		Historial h = new Historial();

		if (req.getParameter("IdHistorial") != null) {
			int IdHistorial = Integer.parseInt(req.getParameter("IdHistorial"));
			h.setIdHistorial(IdHistorial);
		}

		// IDHab, IDHabTipo, IdCamaTipo, Precio, IdEstado, Notas
		if (req.getParameter("IdEmp") != null) {
			int IdEmp = Integer.parseInt(req.getParameter("IdEmp"));
			h.setIdEmp(IdEmp);
		}
		if (req.getParameter("IdCliente") != null) {
			int IdCliente = Integer.parseInt(req.getParameter("IdCliente"));
			h.setIdCliente(IdCliente);
		}
		if (req.getParameter("IdHabitacion") != null) {
			int IdHabitacion = Integer.parseInt(req.getParameter("IdHabitacion"));
			h.setIdHabitacion(IdHabitacion);
		}
		if (req.getParameter("FechaEstadia") != null) {
			String FechaEstadia = req.getParameter("FechaEstadia");
			h.setFechaEstadia(FechaEstadia);
		}
		if (req.getParameter("CargoPorHabitacion") != null) {
			double CargoPorHabitacion = Double.parseDouble(req.getParameter("CargoPorHabitacion"));
			h.setCargoPorHabitacion(CargoPorHabitacion);
		}

		if (req.getParameter("CargoPorTelefono") != null) {
			double CargoPorTelefono = Double.parseDouble(req.getParameter("CargoPorTelefono"));
			h.setCargoPorTelefono(CargoPorTelefono);
		}

		if (req.getParameter("Notas") != null) {
			String Notas = req.getParameter("Notas");
			h.setNotas(Notas);
		}

		if (action.equals("create")) {
			historialDao.addHistorial(h);
			lstHistorial.add(h);
		} else if (action.equals("update")) {
			try {
				historialDao.updateHistorial(h);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		// Return in the format required by jTable plugin
		JSONROOT.put("Result", "OK");
		JSONROOT.put("Record", h);

		// Convert Java Object to Json
		String jsonArray = gson.toJson(JSONROOT);
		res.getWriter().print(jsonArray);
	}

	void Delete(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		// Delete record
		if (req.getParameter("IdHistorial") != null) {
			String IdHistorial = (String) req.getParameter("IdHistorial");
			historialDao.deleteHistorial(Integer.parseInt(IdHistorial));

			// Return in the format required by jTable plugin
			JSONROOT.put("Result", "OK");

			// Convert Java Object to Json
			String jsonArray = gson.toJson(JSONROOT);
			res.getWriter().print(jsonArray);
		}
	}

}
