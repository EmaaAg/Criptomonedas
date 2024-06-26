package criptomonedas;

import java.util.List;

public class Criptomoneda {
	private String nombre;
	private String simbolo;
	private Double precioBase;	
	
	public Criptomoneda(String nombre, String simbolo, Double precioBase) {
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.precioBase = precioBase;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getSimbolo() {
		return simbolo;
	}
	
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	public Double getPrecioBase() {
		return precioBase;
	}
	
	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	} 
	
	public static boolean buscarCriptomoneda(String nombre, List<Criptomoneda> criptomonedas) {
		for (Criptomoneda administrador : criptomonedas) {
			if(administrador.getNombre().equals(nombre)) {
				return true;
			}
		}
				
		return false;
	}
	
	
	public static Criptomoneda buscarCriptomonedaPorNombre(String nombre, List<Criptomoneda> criptomonedas) {
		Criptomoneda criptomonedaExistente = null;
        for (Criptomoneda c : criptomonedas) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                criptomonedaExistente = c;
                break;
            }
        }				
		return criptomonedaExistente;
	}
	
	public static Criptomoneda buscarCriptomonedaPorSimbolo(String simbolo, List<Criptomoneda> criptomonedas) {
		Criptomoneda criptomonedaExistente = null;
        for (Criptomoneda c : criptomonedas) {
            if (c.getSimbolo().equalsIgnoreCase(simbolo)) {
                criptomonedaExistente = c;
                break;
            }
        }				
		return criptomonedaExistente;
	}
	
	@Override
	public String toString() {
		return "Nombre: [" + nombre + "]" + ", Simbolo: [" + simbolo + "], Precio Base: [" + precioBase + "]." ;
	}
}
