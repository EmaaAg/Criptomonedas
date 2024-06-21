package criptomonedas;

import java.util.List;

public class Trader extends Usuario{
	private String numeroDeCuenta;
	private String nombreDeBanco;
	private Double saldoActual;
	


    public Trader(String nombre, String numeroDeCuenta, String nombreDeBanco, Double saldoActual) {
		super(nombre);
		this.numeroDeCuenta = numeroDeCuenta;
		this.nombreDeBanco = nombreDeBanco;
		this.saldoActual = saldoActual;
	}
    
//	public Trader(String nombre, String numeroDeCuenta, String nombreDeBanco, Double saldoActual, List<Trader> traders) {
//		super(nombre);
//		this.numeroDeCuenta = numeroDeCuenta;
//		this.nombreDeBanco = nombreDeBanco;
//		this.saldoActual = saldoActual;
//		this.traders = traders;
//	}
	
	
	public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}
	
	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}
	
	public String getNombreDeBanco() {
		return nombreDeBanco;
	}
	
	public void setNombreDeBanco(String nombreDeBanco) {
		this.nombreDeBanco = nombreDeBanco;
	}
	
	public Double getSaldoActual() {
		return saldoActual;
	}
	
	public void setSaldoActual(Double saldoActual) {
		this.saldoActual = saldoActual;
	}
	
	@Override
	public boolean verificarUsuario() {
		if(numeroDeCuenta != "Administrador") {
			return true;
		}
		return false;
	}
	
	public static boolean buscarTrader(String nombre, List<Trader> traders) {
		for (Trader trader : traders) {
			if(trader.getNombre().equals(nombre)) {
				return true;
			}
		}
				
		return false;
	}
	
	public static Trader buscarTraderPorNombre(String nombre, List<Trader> traders) {
		for (Trader trader : traders) {
			if(trader.getNombre().equals(nombre)) {
				return trader;
			}
		}				
		return null;
	}

	@Override
	public String toString() {
		return "Nombre: "+ getNombre() + ", Numero De Cuenta:" + numeroDeCuenta + ", Nombre De Banco: " + nombreDeBanco + ", saldoActual="
				+ saldoActual;
	}
	
	
}
