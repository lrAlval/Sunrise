package modelos;

public class Pago {
	
	private int IdRecibo;
	private int IdEmp;
	private String FechaPago;
	private int IdCliente;
	private double ImportePagar;
	private String Notas;

	public int getIdRecibo() {
		return IdRecibo;
	}

	public void setIdRecibo(int idRecibo) {
		IdRecibo = idRecibo;
	}

	public int getIdEmp() {
		return IdEmp;
	}

	public void setIdEmp(int idEmp) {
		IdEmp = idEmp;
	}

	public String getFechaPago() {
		return FechaPago;
	}

	public void setFechaPago(String fechaPago) {
		FechaPago = fechaPago;
	}

	public int getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

	public double getImportePagar() {
		return ImportePagar;
	}

	public void setImportePagar(double importePagar) {
		ImportePagar = importePagar;
	}

	public String getNotas() {
		return Notas;
	}

	public void setNotas(String notas) {
		Notas = notas;
	}

}
