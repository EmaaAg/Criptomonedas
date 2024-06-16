package criptomonedas;

public class Mercado {
	private String simbolo;
	private Double capacidad;
	private Double volumen;
	private Double variacion;
	
	public Mercado(String simbolo) {
        this.simbolo = simbolo;
        this.capacidad = 500.0;       // Inicializar capacidad con 500
        this.volumen = 1.0;          // Inicializar volumen con 1% en alza
        this.variacion = 1.0;        // Inicializar variacion con 1% en alza
    }
	
	
	public Mercado(String simbolo, Double capacidad, Double volumen, Double variacion) {
		this.simbolo = simbolo;
		this.capacidad = capacidad;
		this.volumen = volumen;
		this.variacion = variacion;
	}

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
	
	@Override
	public String toString() {
		return "Simbolo: [" + simbolo +"], Capacidad: [" + capacidad + "], Volumen: [" + volumen 
				+ "], Variación: [" + variacion;
	}
	
}
