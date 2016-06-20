package modelos;

import com.google.gson.annotations.SerializedName;

public class EmpleadoEstado {

	@SerializedName("Value")
	private int IdEstado;
	@SerializedName("DisplayText")
	private String DescEstado;

	public int getIdEstado() {
		return IdEstado;
	}

	public void setIdEstado(int idEstado) {
		IdEstado = idEstado;
	}

	public String getDescEstado() {
		return DescEstado;
	}

	public void setDescEstado(String descEstado) {
		DescEstado = descEstado;
	}

}
