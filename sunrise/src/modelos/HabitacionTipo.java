package modelos;

import com.google.gson.annotations.SerializedName;

public class HabitacionTipo {
	@SerializedName("DisplayText")
	private String Notas;
	@SerializedName("Value")
	private int IDHabTipo;
	
	public int getIDHabTipo() {
		return this.IDHabTipo;
	}
	public void setIDHabTipo(int iDHabTipo) {
		this.IDHabTipo = iDHabTipo;
	}
	public String getNotas() {
		return Notas;
	}
	public void setNotas(String notas) {
		Notas = notas;
	}

	
	
}
