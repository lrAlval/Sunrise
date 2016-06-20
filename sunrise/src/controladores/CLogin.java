package controladores;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import libs.Read;
import libs.gg;
import modelos.Empleado;
import modelos.horasEmpleado;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daos.EmpleadoDao;
import daos.HorasEmpleadosDao;

@WebServlet("/CLogin")
public class CLogin extends gg {
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	private static final long serialVersionUID = 1L;
	private Empleado empleado = new Empleado();
	private EmpleadoDao dao ;
	private HorasEmpleadosDao horasDao;
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	
	public CLogin (){
		dao = new EmpleadoDao();
		horasDao = new HorasEmpleadosDao();
	}

	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		salida(req, res);
	}

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		int proceso = Read.toInt(req, "proceso");
		switch (proceso) {
			case 0: ingreso(req, res); break;
			case 1: cambio(req, res);  break;
		}

	}


	private void ingreso(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		System.out.print("Servlet Ingreso"+"\n");
		HttpSession sesion = req.getSession();
		String Usuario = Read.toString(req, "txtUser");	
		String Pass    = Read.toString(req, "txtPass");
		

		String pagina = "login.jsp";
		Empleado e = dao.login(Usuario, Pass);
		

		
		if(e == null) {req.setAttribute("error", "Usuarop y/o Contraseña Incorrecta");} 
		else{
			String cod = Read.toString(e.getIdEmp());
			String Cargo = e.getCargo();
			String nombreCompleto = e.getNombre() + " " + e.getApellido();
			String leftBarInfo = e.getNombre() + "," + e.getEdad();
			String pic = e.getProfilepic();
			
			if(dao.Activo(cod)){
				sesion.setAttribute("codigo", cod);
				sesion.setAttribute("usuario", nombreCompleto);
				sesion.setAttribute("nombre", e.getNombre());
				sesion.setAttribute("leftBarInfo", leftBarInfo);
				sesion.setAttribute("profile", pic);
				sesion.setAttribute("CantClis", dao.getCantClientes(e.getIdEmp()) );
				sesion.setAttribute("CantReser", dao.getCantReservas(e.getIdEmp()));
				sesion.setAttribute("Horas", dao.getHorasEmpleado(e.getIdEmp()));
				String SessionID = sesion.getId();
				
				//sesion.setMaxInactiveInterval(50);
				horasEmpleado he = new horasEmpleado();
				
				he.setIdEmp(e.getIdEmp());
				he.setSessionID(SessionID);
				//he.setFecha(MySQLNOWFecha());
				//he.setLogInHora(HoraActual24H());
				//he.setLogOutHora(HoraActual24H());
				horasDao.addLoginInfo(he);
				
						if(Cargo.startsWith("R")) pagina = "HomeRecepcionista.jsp";
						if(Cargo.startsWith("G")) pagina = "HomeAdmin.jsp";
						if(Cargo.startsWith("J")) pagina = "HomeJef.jsp";
			}
			else req.setAttribute("error", "Ud. se encuentra despedido, no puede ingresar al sistema.");
			
		}
	    
	    req.getRequestDispatcher(pagina).forward(req, res);
	}
	
	


	private void cambio(HttpServletRequest req, HttpServletResponse res) {
		

	}

	private void salida(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		HttpSession sesion = req.getSession();
		int codEmp =  getInt(sesion.getAttribute("codigo"));
		horasEmpleado he = new horasEmpleado();
		he.setIdEmp( codEmp );
		he.setLogOutHora(HoraActual24H());
		he.setSessionID(sesion.getId());
		horasDao.UpdateLoginInfo(he);
		sesion.invalidate();
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}

}
