package criptomonedas;

import java.util.List;

public class Administrador extends Usuario{
	private String perfil;
    private static List<Administrador> administradores;
	
	
	public Administrador(String nombre, String perfil) {
		super(nombre);
		this.perfil = perfil;
	}
	

	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	@Override 
	public boolean verificarUsuario() {
		if(perfil == "Administrador") {
			return true;
		}
		return false;
	}
	
	public static boolean buscarAdmin(String nombre) {
		for (Administrador administrador : administradores) {
			if(administrador.getNombre() == nombre) {
				return true;
			}
		}
				
		return false;
	}


	@Override
	public String toString() {
		return "Nombre: " + getNombre() + " Perfil:" + perfil;
	}
	
	
	
}
