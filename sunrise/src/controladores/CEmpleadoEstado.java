package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.EmpleadoEstado;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daos.EmpleadoEstadoDao;

@WebServlet("/CEmpleadoEstado")
public class CEmpleadoEstado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	List<EmpleadoEstado> lstEmpleadoEstado = new ArrayList<EmpleadoEstado>();
	private EmpleadoEstadoDao empleadoEstadoDao;

	public CEmpleadoEstado() {
		empleadoEstadoDao = new EmpleadoEstadoDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		
		//String action = (String) req.getParameter("action");
		String relacion = (String) req.getParameter("relacion");
		
		Listado(req, res, relacion);

	}

	void Listado(HttpServletRequest req, HttpServletResponse res,
			String relacion) {

		// Fetch Data from User Table
		try {
			System.out.print("entrando a listado" + "\n");
			if (relacion.equals("Hijo")) {
				System.out.print("entrando a if hijo" + "\n");
				// Fetch Data from Student Table

				lstEmpleadoEstado = empleadoEstadoDao.getAllEmpleadoEstado();
				// lstHabitacion=Habitaciondao.getAllRooms();
				System.out.print("saliendo de lista EmpleadoEstado Hijo"
						+ lstEmpleadoEstado.size());
				// Get Total Record Count for Pagination

				// Return in the format required by jTable plugin
				JSONROOT.put("Result", "OK");
				JSONROOT.put("Options", lstEmpleadoEstado);
				// JSONROOT.put("TotalRecordCount", total);

				// Convert Java Object to Json
				String jsonArray = gson.toJson(JSONROOT);
				res.getWriter().print(jsonArray);

			} else if (relacion.equals("Padre")) {
				System.out.print("entrando a if Padre" + "\n");
				int startPageIndex = Integer.parseInt(req
						.getParameter("jtStartIndex"));
				int recordsPerPage = Integer.parseInt(req
						.getParameter("jtPageSize"));

				// Fetch Data from Student Table
				lstEmpleadoEstado = empleadoEstadoDao.getAllEmpleadoEstado(
						startPageIndex, recordsPerPage);

				System.out.print("saliendo de lista EmpleadoEstado Padre"
						+ lstEmpleadoEstado.size());
				// Get Total Record Count for Pagination

				int total = empleadoEstadoDao.getTotalRecordCount();

				// Return in the format required by jTable plugin
				JSONROOT.put("Result", "OK");
				JSONROOT.put("Records", lstEmpleadoEstado);
				JSONROOT.put("TotalRecordCount", total);

				// Convert Java Object to Json
				String jsonArray = gson.toJson(JSONROOT);
				res.getWriter().print(jsonArray);

			}

		} catch (IOException e) {

			try {
				System.out.print("Error en listado EmpleadoEstado");
				JSONROOT.put("Result", "ERROR");
				JSONROOT.put("Message", e + "dfdf");
				System.out.print(e);
				String error = gson.toJson(JSONROOT);

				res.getWriter().print(error);
			} catch (IOException e1) {

				e1.printStackTrace();
			}

		}
	}

}
