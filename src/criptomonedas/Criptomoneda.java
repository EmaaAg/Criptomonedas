package criptomonedas;

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
	
}
