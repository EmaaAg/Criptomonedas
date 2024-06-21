package criptomonedas;

import java.util.List;

public class Historico {
	private String simbolo;
	private Double cantidad;
	
	public Historico(String simbolo, double cantidad) {
		
		this.simbolo = simbolo;
		this.cantidad = cantidad;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public static Historico buscarHistoricoPorSimbolo(String simbolo, List<Historico> historicos) {
		Historico historicoExistente = null;
        for (Historico historico : historicos) {
            if (historico.getSimbolo().equalsIgnoreCase(simbolo)) {
            	historicoExistente  = historico;
                break;
            }
        }				
		return historicoExistente;
	}
	
	@Override
	public String toString() {
		return "Simbolo: " + simbolo + " Cantidad: " + cantidad;
	}
		
}
