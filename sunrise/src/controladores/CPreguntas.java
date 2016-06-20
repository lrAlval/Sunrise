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

import modelos.Preguntas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daos.PreguntasDao;

@WebServlet("/CPreguntas")
public class CPreguntas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	List<Preguntas> lstPreguntas = new ArrayList<Preguntas>();
	private PreguntasDao preguntasDao;

	public CPreguntas() {
		preguntasDao = new PreguntasDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String action =   (String) req.getParameter("action");
		String relacion = (String) req.getParameter("relacion");

		switch (action) {
		case "list":
			Listado(req, res, relacion);
			break;
		case "create":
		case "update":
			//upsert(req, res, action);
			break;
		case "delete":
			//Delete(req, res);
			break;
		}

	}

	void Listado(HttpServletRequest req, HttpServletResponse res,
			String relacion) {

		// Fetch Data from User Table
		try {
			if (relacion.equals("Hijo")) {
				
				lstPreguntas = preguntasDao.getAllPreguntas();
				// lstHabitacion=Habitaciondao.getAllRooms();
				System.out.print("saliendo de lista EmpleadoEstado Hijo" + lstPreguntas.size());

				JSONROOT.put("Result", "OK");
				JSONROOT.put("Options", lstPreguntas);
				// JSONROOT.put("TotalRecordCount", total);

				// Convert Java Object to Json
				String jsonArray = gson.toJson(JSONROOT);
				res.getWriter().print(jsonArray);

			} else if (relacion.equals("Padre")) {
				
				int startPageIndex = Integer.parseInt(req.getParameter("jtStartIndex"));
				int recordsPerPage = Integer.parseInt(req.getParameter("jtPageSize"));

				// Fetch Data from Student Table
				lstPreguntas = preguntasDao.getAllPreguntas(startPageIndex,recordsPerPage);

				int total = preguntasDao.getTotalRecordCount();
				// Return in the format required by jTable plugin
				JSONROOT.put("Result", "OK");
				JSONROOT.put("Records", lstPreguntas);
				JSONROOT.put("TotalRecordCount", total);

				// Convert Java Object to Json
				String jsonArray = gson.toJson(JSONROOT);
				res.getWriter().print(jsonArray);

			}

		} catch (IOException e) {

				try {
					System.out.print("Error en listado EmpleadoEstado");
					JSONROOT.put("Result", "ERROR");
					JSONROOT.put("Message", e.getMessage() + "");
					System.out.print(e);
					String error = gson.toJson(JSONROOT);
	
					res.getWriter().print(error);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

		}
	}

}
