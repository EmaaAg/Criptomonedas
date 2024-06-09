package criptomonedas;

import java.util.List;

public class Administrador extends Usuario{
	private String perfil;
	
	
	public Administrador(String nombre, String perfil) {
		super(nombre);
		this.perfil = perfil;
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
	
	public static boolean buscarAdmin(String nombre, List<Administrador> administradores) {
		for (Administrador administrador : administradores) {
			if(administrador.getNombre().equals(nombre)) {
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
