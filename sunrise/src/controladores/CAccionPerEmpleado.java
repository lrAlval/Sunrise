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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelos.horasEmpleado;
import modelos.infoPerEmpleado;
import daos.HorasEmpleadosDao;
import daos.infoPerEmpleadoDao;


@WebServlet("/CAccionPerEmpleado")
public class CAccionPerEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	infoPerEmpleadoDao InfoHijo;
	
	 public CAccionPerEmpleado() {
	    	InfoHijo = new infoPerEmpleadoDao();
	    }
		

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ListadoDetalle(req, res);
	}
	
	
	void ListadoDetalle(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String action = (String)req.getParameter("action");
		List<infoPerEmpleado> lstInfoDetalle  = new ArrayList<infoPerEmpleado>();
		res.setContentType("application/json");
		
		if (action.equals("list")) {
			
			//int startPageIndex =  Integer.parseInt(req.getParameter("jtStartIndex"));
			//int recordsPerPage  = Integer.parseInt(req.getParameter("jtPageSize"));
			int idHora = Integer.parseInt(req.getParameter("idHora"));
			String Nombre = req.getParameter("nombre");
			
			

			// Fetch Data from Student Table
			lstInfoDetalle = InfoHijo.getInfoPerEmpleado(idHora);
			
			//lstHabitacion=Habitaciondao.getAllRooms();
			System.out.print("Listado Horas Servlet Horas Detalle Empleado " + lstInfoDetalle.size() + " \n");
			// Get Total Record Count for Pagination
			
			//int total = Habitaciondao.getTotalRecordCount();

			// Return in the format required by jTable plugin
			JSONROOT.put("Result", "OK");
			JSONROOT.put("Records", lstInfoDetalle);
			//JSONROOT.put("TotalRecordCount", total);

			// Convert Java Object to Json
			String jsonArray = gson.toJson(JSONROOT);

			res.getWriter().print(jsonArray);
		}
		
	}

}
