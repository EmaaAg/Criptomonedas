package menu;

import java.util.List;
import java.util.Scanner;

import criptomonedas.Trader;

public class AdministracionTrader {	

	public static void crearTrader(List<Trader> traders, Scanner sc, String nombre) {
		System.out.println("Ingrese Numero de cuenta bancaria: ");
		String numeroDeCuenta = sc.nextLine();

		System.out.println("Ingrese nombre de Banco: ");
		String nombreDeBanco = sc.nextLine();

		System.out.println("Ingrese Saldo Actual: "); /// verificar saldo
		Double saldo = sc.nextDouble();

		Trader tra = new Trader(nombre, numeroDeCuenta, nombreDeBanco, saldo);

		traders.add(tra);
	}

}
