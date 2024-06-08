package criptomonedas;

public class Mercado {
	private String simbolo;
	private Double capacidad;
	private Double volumen;
	private Double variacion;
	
	public String getSimbolo() {
		return simbolo;
	}
	
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	public Double getCapacidad() {
		return capacidad;
	}
	
	public void setCapacidad(Double capacidad) {
		this.capacidad = capacidad;
	}
	
	public Double getVolumen() {
		return volumen;
	}
	
	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}
	
	public Double getVariacion() {
		return variacion;
	}
	
	public void setVariacion(Double variacion) {
		this.variacion = variacion;
	}
	
}
