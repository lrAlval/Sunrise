package modelos;

public class Contacto {
	private int IdContacto;
	private String Nombre;
	private String mail;
	private String Notas;

	public int getIdContacto() {
		return IdContacto;
	}

	public void setIdContacto(int idContacto) {
		IdContacto = idContacto;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNotas() {
		return Notas;
	}

	public void setNotas(String notas) {
		Notas = notas;
	}

}
