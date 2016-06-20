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

import libs.debug;
import modelos.Habitacion;
import modelos.infoPerEmpleado;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daos.HabitacionDao;
import daos.infoPerEmpleadoDao;

@WebServlet("/CHabitacion")
public class CHabitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	List<Habitacion> lstHabitacion=new ArrayList<Habitacion>();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	infoPerEmpleadoDao info ;
	private HabitacionDao Habitaciondao;
	
	debug d = new debug();
    
    public CHabitacion() {
    	Habitaciondao=new HabitacionDao();
    	info = new infoPerEmpleadoDao();
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action = (String)req.getParameter("action");
		String relacion = (String) req.getParameter("relacion");
		
		HttpSession sesion  = req.getSession();
		
		res.setContentType("application/json");
		
		
		switch (action) {
			case "list":  Listado(req, res, relacion); break;
			case "create": case "update": Upsert(req, res, action);  break;
			case "delete": 
			info.addInfoPerEmpleado(sesion.getId(),"Habitacion","Elimino una Habitacion");
			Delete(req, res); break;
	     }
	
	}


	private void Listado(HttpServletRequest req, HttpServletResponse res,String relacion) throws IOException {
			if (relacion.equals("Hijo")) {
				lstHabitacion = Habitaciondao.getAllRooms();

				JSONROOT.put("Result", "OK");
				JSONROOT.put("Options", lstHabitacion);

				// Convert Java Object to Json
				String jsonArray = gson.toJson(JSONROOT);
				res.getWriter().print(jsonArray);

			} else if (relacion.equals("Padre")) {
				int startPageIndex = Integer.parseInt(req.getParameter("jtStartIndex"));
				int recordsPerPage = Integer.parseInt(req.getParameter("jtPageSize"));
				// Fetch Data from Student Table
				lstHabitacion = Habitaciondao.getAllRooms(startPageIndex,recordsPerPage);
				int total = Habitaciondao.getTotalRecordCount();

				// Return in the format required by jTable plugin
				JSONROOT.put("Result", "OK");
				JSONROOT.put("Records", lstHabitacion);
				JSONROOT.put("TotalRecordCount", total);

				// Convert Java Object to Json
				String jsonArray = gson.toJson(JSONROOT);
				res.getWriter().print(jsonArray);
			}
	
	}
	
	
	
	
	
	void Upsert(HttpServletRequest req, HttpServletResponse res,String accion) throws IOException{
		Habitacion NewData = getParameters(req);
		HttpSession sesion  = req.getSession();
		 if(accion.equals("create")){
			 		d.log("Insertando Habitacion CHabitacion");
			 		info.addInfoPerEmpleado(sesion.getId(),"Habitacion","Añadio una Habitacion");
			 		Habitaciondao.addHabitacion(NewData);					
				    lstHabitacion.add(NewData);
		 }else{
			 d.log("Actualizando Habitacion CHabitacion");
			 info.addInfoPerEmpleado(sesion.getId(),"Habitacion","Actualiso una Habitacion");
			 Habitaciondao.updateHabitacion(NewData);
		 }
			 JSONROOT.put("Result", "OK");
			 JSONROOT.put("Record", NewData);
			// Convert Java Object to Json
			String jsonArray = gson.toJson(JSONROOT);
			res.getWriter().print(jsonArray);
	}
	
	void Delete(HttpServletRequest req,HttpServletResponse res) throws IOException{
		if (req.getParameter("Value")!=null) {
			String IDHab=(String)req.getParameter("Value");
		    Habitaciondao.deleteHabitacion(Integer.parseInt(IDHab));
			// Return in the format required by jTable plugin
			JSONROOT.put("Result", "OK");

			// Convert Java Object to Json
			String jsonArray = gson.toJson(JSONROOT);
			res.getWriter().print(jsonArray);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Habitacion getParameters(HttpServletRequest req){
		Habitacion h = new Habitacion();

		if( req.getParameter("Value") != null ){
		   int IDHab = Integer.parseInt(req.getParameter("Value"));
		   h.setIDHab(IDHab);
		}
		
		 // IDHab, IDHabTipo, IdCamaTipo, Precio, IdEstado, Notas
		if(req.getParameter("IDHabTipo")!=null){
			   int IDHabTipo= Integer.parseInt(req.getParameter("IDHabTipo"));
			   h.setIDHabTipo(IDHabTipo);
		}
		if(req.getParameter("IdCamaTipo") !=null){
			   int IdCamaTipo= Integer.parseInt(req.getParameter("IdCamaTipo"));
			   h.setIdCamaTipo(IdCamaTipo);
		}
		if(req.getParameter("Precio") !=null){
		   double Precio=Double.parseDouble(req.getParameter("Precio")); 
		   h.setPrecio(Precio);
		}
		
		if(req.getParameter("IdEstado") !=null){
			   int IdEstado=Integer.parseInt(req.getParameter("IdEstado")); 
			   h.setIdEstado(IdEstado);
		}
		
		if(req.getParameter("Notas") !=null){
			   String Notas=req.getParameter("DisplayText"); 
			   h.setNotas(Notas);
		}
		
		return h;
	}
	
	
	
	
	
	
	
	
	
	
	
}
