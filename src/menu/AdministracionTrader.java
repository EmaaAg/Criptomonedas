package menu;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import criptomonedas.Criptomoneda;
import criptomonedas.Historico;
import criptomonedas.Mercado;
import criptomonedas.Trader;

public class AdministracionTrader {
	
	public static void visualizarTransacciones(List<Historico> historicos) {
		historicos.sort(null);
		for (Historico historico : historicos) {
			System.out.println(historico);
		}
	}
	
	public static void recomendarCriptomoneda(List<Criptomoneda> criptomonedas, List<Mercado> mercados) {
		double porcentaje;
		double porcentajeMax = 0;
		String simbolo = null;
		
		for (Mercado mercado : mercados) {
			Criptomoneda criptomoneda = Criptomoneda.buscarCriptomonedaPorSimbolo(mercado.getSimbolo(), criptomonedas);
			
			porcentaje = (mercado.getCapacidad() / criptomoneda.getPrecioBase()) * 100;
			
			if(porcentaje > porcentajeMax) {
				porcentajeMax = porcentaje;
				simbolo = mercado.getSimbolo();
			}	
		}	
		
		System.out.println("La criptodivisa con mayor cotización es: " + simbolo + " con valor: " + porcentajeMax);
	}

	public static void consultarCriptomoneda(List<Criptomoneda> criptomonedas, List<Mercado> mercados, Scanner sc) {
	    String respuesta;

	    do {
	        System.out.println("Ingrese el nombre o símbolo de la criptomoneda que desea consultar: ");
	        String consulta = sc.nextLine().toUpperCase();

	        boolean encontrada = false;

	        for (Criptomoneda criptomoneda : criptomonedas) {
	            if (criptomoneda.getNombre().equalsIgnoreCase(consulta) || criptomoneda.getSimbolo().equalsIgnoreCase(consulta)) {
	                System.out.println("Nombre: " + criptomoneda.getNombre() +
	                                   " Símbolo: " + criptomoneda.getSimbolo() +
	                                   " Precio en dólares: " + String.format("%,.1f", criptomoneda.getPrecioBase()));
	                System.out.println("Datos del mercado:");
	                
	                System.out.printf("%-20s%-20s%-20s%n", "Capacidad", "Volumen", "Variación");
	                
	                for (Mercado mercado : mercados) {
	                    if (mercado.getSimbolo().equalsIgnoreCase(criptomoneda.getSimbolo())) {
	                        // Formatear los datos del mercado según el formato deseado
	                        String capacidadFormateada = String.format("%,.2f", mercado.getCapacidad());
	                        String volumenFormateado = String.format("%.2f%%", mercado.getVolumen());
	                        String variacionFormateada = mercado.getVariacion() + "%";

	                        // Imprimir los datos formateados con el formato deseado
	                        System.out.printf("%-20s%-20s%-20s%n", capacidadFormateada, volumenFormateado, variacionFormateada);
	                        encontrada = true;
	                        break;
	                    }
	                }
	                break;
	            }
	        }

	        if (!encontrada) {
	            System.out.println("La criptomoneda especificada no fue encontrada.");
	        }

	        System.out.println("¿Desea consultar otra criptomoneda? (S/N)");
	        respuesta = sc.nextLine();
	    } while (respuesta.equalsIgnoreCase("S"));

	    System.out.println("Consulta de criptomonedas finalizada.");
	}
	
	public static void venderCriptomonedas(List<Criptomoneda> criptomonedas, List<Mercado> mercados, String nombre,
			List<Trader> traders, List <Historico> historicos, Scanner sc) {
		String simbolo;
		Double cantidadAVender;
		
		System.out.println("Ingrese el símbolo a Buscar: ");
		simbolo = sc.next();
		
		Criptomoneda criptomonedaExistente = Criptomoneda.buscarCriptomonedaPorSimbolo(simbolo, criptomonedas);
		Mercado mercadoExistente = Mercado.buscarMercadoPorSimbolo(simbolo, mercados);
		Historico historicoExistente = Historico.buscarHistoricoPorSimbolo(simbolo, historicos);
		
		if(historicoExistente == null) {
			sc.close();
			return;
		}
		
		System.out.println("La cantidad maxima de " + criptomonedaExistente.getNombre() +
				" que puede venderse es de " + historicoExistente.getCantidad());
		
		System.out.println("Ingrese la cantidad a vender: ");
		cantidadAVender = sc.nextDouble();
			
		if(cantidadAVender > historicoExistente.getCantidad()) {
			System.out.println("ERROR: la cantidad ingresada es mayor a la disponible");
			return;
		}
		
		mercadoExistente.setCapacidad(mercadoExistente.getCapacidad() + cantidadAVender);
		mercadoExistente.setVariacion(mercadoExistente.getVariacion() * 0.93);
		mercadoExistente.setVolumen(mercadoExistente.getVolumen() * 0.93);
		
		historicoExistente.setCantidad(historicoExistente.getCantidad() - cantidadAVender);
		
		Trader traderExistente = Trader.buscarTraderPorNombre(nombre, traders);
		traderExistente.setSaldoActual(traderExistente.getSaldoActual() + cantidadAVender * criptomonedaExistente.getPrecioBase());
	}
	
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
