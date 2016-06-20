package modelos;

import com.google.gson.annotations.SerializedName;

public class Empleado {
	@SerializedName("Value")
	private int IdEmp;
	@SerializedName("DisplayText")
	private String Nombre;
	private String Apellido;
	private String Edad;
	private String Cargo;
	private String login;
	private String pass;
	private int idPregunta;
	private String respuesta;
	private int idEstado;
	private String profilepic;

	public int getIdEmp() {
		return IdEmp;
	}
	public void setIdEmp(int idEmp) {
		IdEmp = idEmp;
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
	public String getEdad() {
		return Edad;
	}
	public void setEdad(String edad) {
		Edad = edad;
	}
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
