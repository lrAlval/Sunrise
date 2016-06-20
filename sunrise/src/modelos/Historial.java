package modelos;

public class Historial {
	private int IdHistorial;	
	private int IdEmp;		
	private int IdCliente;		
	private int IdHabitacion;	
	private String FechaEstadia;	
	private double CargoPorHabitacion;		
	private double CargoPorTelefono;			
	private String Notas;
	
	
	public int getIdHistorial() {
		return IdHistorial;
	}
	public void setIdHistorial(int idHistorial) {
		IdHistorial = idHistorial;
	}
	public int getIdEmp() {
		return IdEmp;
	}
	public void setIdEmp(int idEmp) {
		IdEmp = idEmp;
	}
	public int getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}
	public int getIdHabitacion() {
		return IdHabitacion;
	}
	public void setIdHabitacion(int idHabitacion) {
		IdHabitacion = idHabitacion;
	}
	public String getFechaEstadia() {
		return FechaEstadia;
	}
	public void setFechaEstadia(String fechaEstadia) {
		FechaEstadia = fechaEstadia;
	}
	public double getCargoPorHabitacion() {
		return CargoPorHabitacion;
	}
	public void setCargoPorHabitacion(double cargoPorHabitacion) {
		CargoPorHabitacion = cargoPorHabitacion;
	}
	public double getCargoPorTelefono() {
		return CargoPorTelefono;
	}
	public void setCargoPorTelefono(double cargoPorTelefono) {
		CargoPorTelefono = cargoPorTelefono;
	}
	public String getNotas() {
		return Notas;
	}
	public void setNotas(String notas) {
		Notas = notas;
	}		

}
