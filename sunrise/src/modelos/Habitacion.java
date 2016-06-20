package modelos;

import com.google.gson.annotations.SerializedName;

	public class Habitacion {
		@SerializedName("Value")
		private int IDHab;
		private int IDHabTipo;		
		private int IdCamaTipo;		
		private double Precio;			
		private int IdEstado;	
	    @SerializedName("DisplayText")
		private String Notas;
		
		
		public int getIDHab() {
			return IDHab;
		}
		public void setIDHab(int iDHab) {
			IDHab = iDHab;
		}
		public int getIDHabTipo() {
			return IDHabTipo;
		}
		public void setIDHabTipo(int iDHabTipo) {
			IDHabTipo = iDHabTipo;
		}
		public int getIdCamaTipo() {
			return IdCamaTipo;
		}
		public void setIdCamaTipo(int idCamaTipo) {
			IdCamaTipo = idCamaTipo;
		}
		public double getPrecio() {
			return Precio;
		}
		public void setPrecio(double precio) {
			Precio = precio;
		}
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

