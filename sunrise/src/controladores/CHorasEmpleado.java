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
import javax.servlet.http.HttpSession;

import modelos.Habitacion;
import modelos.horasEmpleado;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daos.HabitacionDao;
import daos.HorasEmpleadosDao;


@WebServlet("/CHorasEmpleado")
public class CHorasEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	HorasEmpleadosDao  PadreHoras;

    public CHorasEmpleado() {
    	PadreHoras = new HorasEmpleadosDao();
    }
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { }


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Listado(req, res);
	}
	
	
	void Listado(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String action = (String)req.getParameter("action");
		HttpSession sesion = req.getSession();
		List<horasEmpleado> lstHorasEmpleados  =new ArrayList<horasEmpleado>();
		
		res.setContentType("application/json");
		
		if (action.equals("list")) {
			//int startPageIndex =  Integer.parseInt(req.getParameter("jtStartIndex"));
			//int recordsPerPage  = Integer.parseInt(req.getParameter("jtPageSize"));
			String Nombre = req.getParameter("Nombre");
			String ExceptoNombre =  sesion.getAttribute("nombre").toString();			
			if( Nombre.length() == 0 )	lstHorasEmpleados = PadreHoras.getHorasEmpleados(ExceptoNombre); 
			else lstHorasEmpleados = PadreHoras.getHorasEmpleados(Nombre,ExceptoNombre);
			


			// Fetch Data from Student Table
			//lstHorasEmpleados = PadreHoras.getHorasEmpleados(Nombre);
			
			//lstHabitacion=Habitaciondao.getAllRooms();
			System.out.print("Listado Horas Servlet Horas Empleado " + lstHorasEmpleados.size() + "\n");
			// Get Total Record Count for Pagination
			
			//int total = Habitaciondao.getTotalRecordCount();

			// Return in the format required by jTable plugin
			JSONROOT.put("Result", "OK");
			JSONROOT.put("Records", lstHorasEmpleados);
			//JSONROOT.put("TotalRecordCount", total);

			// Convert Java Object to Json
			String jsonArray = gson.toJson(JSONROOT);

			res.getWriter().print(jsonArray);
		}
		
	}
	
	
	
	

}
