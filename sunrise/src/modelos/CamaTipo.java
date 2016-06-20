package modelos;

import com.google.gson.annotations.SerializedName;

public class CamaTipo {

	@SerializedName("DisplayText")
	private String Notas;
	@SerializedName("Value")
	private int IdCamaTipo;

	public int getIdCamaTipo() {
		return IdCamaTipo;
	}

	public void setIdCamaTipo(int idCamaTipo) {
		IdCamaTipo = idCamaTipo;
	}

	public String getNotas() {
		return Notas;
	}

	public void setNotas(String notas) {
		Notas = notas;
	}

}
