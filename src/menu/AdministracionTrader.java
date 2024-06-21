package menu;

import java.util.List;
import java.util.Scanner;

import criptomonedas.Criptomoneda;
import criptomonedas.Historico;
import criptomonedas.Mercado;
import criptomonedas.Trader;

public class AdministracionTrader {

	public static void comprarCriptomonedas(List<Criptomoneda> criptomonedas, List<Mercado> mercados, String nombre,
		List<Trader> traders, List<Historico> historicos, Scanner sc) {
		String simbolo;
		Double cantidadAComprar;

		System.out.println("Ingrese el símbolo a Buscar: ");
		simbolo = sc.next();

		Criptomoneda criptomonedaExistente = Criptomoneda.buscarCriptomonedaPorSimbolo(simbolo, criptomonedas);
		Mercado mercadoExistente = Mercado.buscarMercadoPorSimbolo(simbolo, mercados);

		if (criptomonedaExistente == null) {
			sc.close();
			return;
		}

		System.out.println("Valor en dólares de " + criptomonedaExistente.getNombre() + " es de "
				+ criptomonedaExistente.getPrecioBase() + " y se puede comprar hasta "
				+ mercadoExistente.getCapacidad());

		do {
			System.out.println("Ingrese la cantidad a comprar: ");
			cantidadAComprar = sc.nextDouble();
		} while (cantidadAComprar > mercadoExistente.getCapacidad());

		mercadoExistente.setCapacidad(mercadoExistente.getCapacidad() - cantidadAComprar);
		mercadoExistente.setVariacion(mercadoExistente.getVariacion() * 1.05);
		mercadoExistente.setVolumen(mercadoExistente.getVolumen() * 1.05);

		if (cantidadAComprar > 1000) {
			criptomonedaExistente.setPrecioBase(criptomonedaExistente.getPrecioBase() * 1.1);
		}

		Trader traderExistente = Trader.buscarTraderPorNombre(nombre, traders);

		Double precioTotal = criptomonedaExistente.getPrecioBase() * cantidadAComprar;
		double saldoFaltante;

		if (traderExistente.getSaldoActual() < precioTotal) {
			do {
				System.out.println("Ingrese el dinero faltante (" + (precioTotal - traderExistente.getSaldoActual()) + "):");
				saldoFaltante = sc.nextDouble();
			} while (saldoFaltante < (precioTotal - traderExistente.getSaldoActual()));
			traderExistente.setSaldoActual(traderExistente.getSaldoActual() + saldoFaltante);

		}
		traderExistente.setSaldoActual(traderExistente.getSaldoActual() - precioTotal); //actualizar saldo
		
		Historico historico = Historico.buscarHistoricoPorSimbolo(simbolo, historicos);
		
		if(historico == null) {
			historico = new Historico(simbolo, cantidadAComprar);
			historicos.add(historico);
		}else{
			Historico historicoModificado = new Historico(mercadoExistente.getSimbolo(), historico.getCantidad() + cantidadAComprar);
            int indexHistorico = historicos.indexOf(historico);
            historicos.set(indexHistorico, historicoModificado);
		}
		
	}

//	public static void crearTrader(List<Trader> traders, Scanner sc, String nombre) {
//		System.out.println("Ingrese Numero de cuenta bancaria: ");
//		String numeroDeCuenta = sc.nextLine();
//
//		System.out.println("Ingrese nombre de Banco: ");
//		String nombreDeBanco = sc.nextLine();
//		Double saldo;
//		
//		do {
//			System.out.println("Ingrese Saldo Actual: ");
//			saldo = sc.nextDouble();			
//		}while( saldo < 0);
//
//		Trader tra = new Trader(nombre, numeroDeCuenta, nombreDeBanco, saldo);
//
//		traders.add(tra);
//		Menu.menu();
//	}

}
