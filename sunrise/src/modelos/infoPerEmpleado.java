package modelos;

public class infoPerEmpleado {
	private int idActividad;
	private int idHoraEmpleado;
	private String opcion;
	private String Accion;
	private String Fecha;
	private String Hora;

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public int getIdHoraEmpleado() {
		return idHoraEmpleado;
	}

	public void setIdHoraEmpleado(int idHoraEmpleado) {
		this.idHoraEmpleado = idHoraEmpleado;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public String getAccion() {
		return Accion;
	}

	public void setAccion(String accion) {
		Accion = accion;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

}
