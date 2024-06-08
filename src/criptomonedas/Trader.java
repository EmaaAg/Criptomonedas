package criptomonedas;

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
	
	
}
