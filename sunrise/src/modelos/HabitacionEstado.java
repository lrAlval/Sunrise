package modelos;

import com.google.gson.annotations.SerializedName;

public class HabitacionEstado {
	@SerializedName("DisplayText")
	private String Notas;
	@SerializedName("Value")
	private int IdEstado;

	public int getIdEstado() {
		return IdEstado;
	}

	public void setIdEstado(int idEstado) {
		IdEstado = idEstado;
	}

	public String getNotas() {
		return Notas;
	}

	public void setNotas(String notas) {
		Notas = notas;
	}

}
