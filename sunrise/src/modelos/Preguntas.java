package modelos;

import com.google.gson.annotations.SerializedName;

public class Preguntas {
	@SerializedName("Value")
	private int IdPregunta;
	@SerializedName("DisplayText")
	private String Descripcion;
	
	
	
	public int getIdPregunta() {
		return IdPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		IdPregunta = idPregunta;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
}
