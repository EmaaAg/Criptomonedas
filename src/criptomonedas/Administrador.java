package criptomonedas;

public class Administrador extends Usuario{
	private String perfil;
	
	public Administrador(String nombre,String perfil) {
		super(nombre);
		this.perfil = perfil;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
}
