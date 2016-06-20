package modelos;

public class Reservas {
	private int IdReserva;
	private int IdEmp;
	private int IdCliente;
	private int IdHabitacion;
	private String FechaEntrada;
	private String FechaSalida;
	private String Notas;
	
	public int getIdReserva() {
		return IdReserva;
	}

	public void setIdReserva(int idReserva) {
		IdReserva = idReserva;
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

	public String getFechaEntrada() {
		return FechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		FechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return FechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		FechaSalida = fechaSalida;
	}

	public String getNotas() {
		return Notas;
	}

	public void setNotas(String notas) {
		Notas = notas;
	}

}
