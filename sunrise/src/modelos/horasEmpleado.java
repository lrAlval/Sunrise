package modelos;

import com.google.gson.annotations.SerializedName;

public class horasEmpleado {
	private int idHora;
	private int idEmp;
	//@SerializedName("w")
	private String SessionID;
	private String Nombre;
	private String Apellido;
	private String Fecha;
	private String LogInHora;
	private String LogOutHora;
	
	
	public String getSessionID() {
		return SessionID;
	}
	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}
	public int getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}
	public int getIdHora() {
		return idHora;
	}
	public void setIdHora(int idHora) {
		this.idHora = idHora;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getLogInHora() {
		return LogInHora;
	}
	public void setLogInHora(String logInHora) {
		LogInHora = logInHora;
	}
	public String getLogOutHora() {
		return LogOutHora;
	}
	public void setLogOutHora(String logOutHora) {
		LogOutHora = logOutHora;
	}
	
	

	
	
	
	

}
