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

import libs.Json;
import libs.debug;
import modelos.Empleado;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daos.EmpleadoDao;

@WebServlet("/CEmpleado")
public class CEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	debug d = new debug();
	 Gson gson = new GsonBuilder().setPrettyPrinting().create();

	List<Empleado> lstEmpleado = new ArrayList<Empleado>();
	

	private EmpleadoDao empleadoDao;
	
	

	public CEmpleado() {
		empleadoDao = new EmpleadoDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String action = (String) req.getParameter("action");
		String relacion = (String) req.getParameter("relacion");

		res.setContentType("application/json");
		
		switch (action) {
			case "list": Listado(req, res, relacion); break;
			case "create": case "update": Upsert(req, res, action);  break;
			case "delete": Delete(req, res); break;
		}


	}
	

	void Listado(HttpServletRequest req, HttpServletResponse res,String relacion) throws IOException {
		try {
			if (relacion.equals("Hijo")) {

				d.log("Entrando if Hijo Empleados");
				lstEmpleado = empleadoDao.getAllEmpleados();
				d.log("Lista llena ? " + lstEmpleado.size());

				JSONROOT.put("Result", "OK");
				JSONROOT.put("Options", lstEmpleado);

				// Convert Java Object to Json
				String jsonArray = gson.toJson(JSONROOT);
				res.getWriter().print(jsonArray);

			} else if (relacion.equals("Padre")) {
				int startPageIndex = Integer.parseInt(req.getParameter("jtStartIndex"));
				int recordsPerPage = Integer.parseInt(req.getParameter("jtPageSize"));

				// Fetch Data from Student Table
				lstEmpleado = empleadoDao.getAllEmpleados(startPageIndex,recordsPerPage);

				System.out.print("saliendo de lista empleado Padre" + lstEmpleado.size() + "\n");
				// Get Total Record Count for Pagination

				int total = empleadoDao.getTotalRecordCount();

				// Return in the format required by jTable plugin
				JSONROOT.put("Result", "OK");
				JSONROOT.put("Records", lstEmpleado);
				JSONROOT.put("TotalRecordCount", total);
				

				// Convert Java Object to Json
				String jsonArray = gson.toJson(JSONROOT);
				res.getWriter().print(jsonArray);

			}

		} catch (IOException e) {
			JSONROOT.put("Result", "ERROR");
			JSONROOT.put("Message", e.getMessage()+ "" );
			String error = gson.toJson(JSONROOT);
			res.getWriter().print(error);
			e.printStackTrace();
		}
	}
	
	
	void Upsert(HttpServletRequest req, HttpServletResponse res,String accion) throws IOException{
		Empleado NewData = getParameters(req);
		 if(accion.equals("create")){
			 		d.log("Insertando Empleado CEmpleados");
					empleadoDao.addEmpleado(NewData);
					lstEmpleado.add(NewData);
		 }else{
			 d.log("Actualizando Empleado CEmpleados");
			 empleadoDao.updateEmpleado(NewData);
		 }
			 JSONROOT.put("Result", "OK");
			 JSONROOT.put("Record", NewData);

			// Convert Java Object to Json
			String jsonArray = gson.toJson(JSONROOT);
			res.getWriter().print(jsonArray);
	}
	
	
	

	
	
	
	void Delete(HttpServletRequest req,HttpServletResponse res) throws IOException{
		if (req.getParameter("Value") != null) {
			String IdEmp = req.getParameter("Value");
			empleadoDao.deleteEmpleado(Integer.parseInt(IdEmp));

			// Return in the format required by jTable plugin
			JSONROOT.put("Result", "OK");

			// Convert Java Object to Json
			String jsonArray = gson.toJson(JSONROOT);
			res.getWriter().print(jsonArray);
		}
	}
	
	
	Empleado getParameters(HttpServletRequest req){
		Empleado e = new Empleado();

		if (req.getParameter("Value") != null) {
			int IdEmp = Integer.parseInt(req.getParameter("Value"));
			e.setIdEmp(IdEmp);
		}

		if (req.getParameter("DisplayText") != null) {
			String Nombre = req.getParameter("DisplayText");
			e.setNombre(Nombre);
		}
		if (req.getParameter("Apellido") != null) {
			String Apellido = req.getParameter("Apellido");
			e.setApellido(Apellido);
		}
		if (req.getParameter("Cargo") != null) {
			String Cargo = req.getParameter("Cargo");
			e.setCargo(Cargo);
		}

		if (req.getParameter("login") != null) {
			String login = req.getParameter("login");
			e.setLogin(login);
		}
		if (req.getParameter("pass") != null) {
			String pass = req.getParameter("pass");
			e.setPass(pass);
		}
		if (req.getParameter("idPregunta") != null) {
			int idPregunta = Integer.parseInt(req.getParameter("idPregunta"));
			e.setIdPregunta(idPregunta);
		}
		if (req.getParameter("respuesta") != null) {
			String respuesta = req.getParameter("respuesta");
			e.setRespuesta(respuesta);
		}
		if (req.getParameter("idEstado") != null) {
			int idEstado = Integer.parseInt(req.getParameter("idEstado"));
			e.setIdEstado(idEstado);
		}
		
		return e;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
