package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import archivos.Archivo;
import criptomonedas.Administrador;
import criptomonedas.Criptomoneda;
import criptomonedas.Historico;
import criptomonedas.Mercado;
import criptomonedas.Trader;

public class Menu {

	public static void menu() {
		List<Trader> traders = new ArrayList<Trader>();
		List<Administrador> admin = new ArrayList<Administrador>();

		Scanner sc = new Scanner(System.in);
		String nombre;

		Archivo archivo = new Archivo("usuarios.csv");
		archivo.cargarArchivoUsuarios(admin, traders);

		mostrarAdministradores(admin);
		mostrarTraders(traders);

		System.out.println("Ingrese su nombre");
		nombre = sc.nextLine();

		// Buscar en la lista de Traders y Admins
		if (criptomonedas.Administrador.buscarAdmin(nombre, admin)) {
			menuAdmin();
		} else {
			if (criptomonedas.Trader.buscarTrader(nombre, traders)) {
				menuTrader(nombre, traders);
			} else {
				// crearTrader
				crearTrader(traders, sc, nombre);
				menuTrader(nombre, traders);
				// AdministracionTrader.crearTrader(traders, sc, nombre);
			}
			Archivo archivoUsuario = new Archivo("usuarios.csv");
			archivoUsuario.guardarArchivoUsuario(admin, traders);
		}

		sc.close();
	}

	private static void crearTrader(List<Trader> traders, Scanner sc, String nombre) {
		System.out.println("Ingrese Numero de cuenta bancaria: ");
		String numeroDeCuenta = sc.nextLine();

		System.out.println("Ingrese nombre de Banco: ");
		String nombreDeBanco = sc.nextLine();
		Double saldo;

		do {
			System.out.println("Ingrese Saldo Actual: ");
			saldo = sc.nextDouble();
		} while (saldo < 0);

		Trader tra = new Trader(nombre, numeroDeCuenta, nombreDeBanco, saldo);

		traders.add(tra);
	}

	public static void mostrarTraders(List<Trader> traders) {
		System.out.println("Traders:");
		for (Trader trader : traders) {
			System.out.println(trader);
		}
	}

	public static void mostrarAdministradores(List<Administrador> admin) {
		System.out.println("Administradores:");
		for (Administrador administrador : admin) {
			System.out.println(administrador);
		}
	}

	public static void mostrarCriptomonedas(List<Criptomoneda> criptomonedas) {
		System.out.println("Criptomonedas:");
		for (Criptomoneda cripto : criptomonedas) {
			System.out.println(cripto);
		}
	}

	public static void mostrarMercado(List<Mercado> mercados) {
		System.out.println("Mercados:");
		for (Mercado mercado : mercados) {
			System.out.println(mercado);
		}
	}

	public static void mostrarHistorico(List<Historico> historicos) {
		System.out.println("Historicos:");
		for (Historico historico : historicos) {
			System.out.println(historico);
		}
	}

	public static void menuAdmin() {

		List<Criptomoneda> criptomonedas = new ArrayList<Criptomoneda>();
		List<Mercado> mercados = new ArrayList<Mercado>();

		String mensaje = "\n1) Crear Criptomoneda.\n" + "2) Modificar Criptomoneda.\n" + "3) Eliminar Criptomoneda.\n"
				+ "4) Consultar Criptomoneda.\n" + "5) Consultar estado actual del mercado.\n" + "6) Salir.\n";
		Scanner sc = new Scanner(System.in);
		int opcion = obtenerOpcion(mensaje, 1, 6, sc);

		Archivo archivoCripto = new Archivo("criptomonedas.csv");
		archivoCripto.cargarArchivoCriptomonedas(criptomonedas);

		Archivo archivoMercado = new Archivo("mercados.csv");
		archivoMercado.cargarArchivoMercado(mercados);
//		mostrarCriptomonedas(criptomonedas);
		while (opcion != 6) {

			switch (opcion) {
			case 1:
				// crearCriptomoneda();
				System.out.println("\nOpción Crear Criptomoneda seleccionada.");
				AdministracionAdministrador.crearCriptomoneda(criptomonedas, mercados, sc);

				archivoMercado.guardarArchivoMercado(mercados);
				archivoCripto.guardarArchivoCriptomoneda(criptomonedas);
				break;
			case 2:
				// modificarCriptomoneda();
				System.out.println("\nOpción Modificar Criptomoneda seleccionada.");
				AdministracionAdministrador.modificarCriptomoneda(criptomonedas, mercados, sc);

				archivoMercado.guardarArchivoMercado(mercados);
				archivoCripto.guardarArchivoCriptomoneda(criptomonedas);
				break;
			case 3:
				// eliminarCriptomoneda();
				System.out.println("\nOpción Eliminar Criptomoneda seleccionada.");
				AdministracionAdministrador.eliminarCriptomoneda(criptomonedas, mercados, sc);

				archivoMercado.guardarArchivoMercado(mercados);
				archivoCripto.guardarArchivoCriptomoneda(criptomonedas);
				break;
			case 4:
				// consultarCriptomoneda();
				System.out.println("\nOpción Consultar Criptomoneda seleccionada.");
				mostrarCriptomonedas(criptomonedas);
				AdministracionAdministrador.consultarCriptomoneda(criptomonedas, mercados, sc);
				break;
			case 5:
				System.out.println("\nOpción Consultar estado actual del mercado seleccionada.");
				mostrarMercado(mercados);
				break;
			case 6:
				System.out.println("\nSaliendo del programa.");
				System.exit(0);
				break;
			default:
				System.out.println("Opción no válida.");
				break;
			}
			opcion = obtenerOpcion(mensaje, 1, 6, sc);
		}
		System.out.println("Gracias por Administrar.");

		sc.close();
	}

	public static void menuTrader(String nombre, List<Trader> traders) {

		String mensaje = "\n1) Comprar Criptomonedas.\n" + "2) Vender Criptomonedas.\n" + "3) Consultar Criptomoneda.\n"
				+ "4) Recomendar Criptomonedas.\n" + "5) Consultar estado actual del mercado.\n"
				+ "6) Visualizar archivo de transacciones (histórico).\n" + "7) Salir.\n";
		Scanner sc = new Scanner(System.in);
		int opcion = obtenerOpcion(mensaje, 1, 7, sc);

		// modificar
		List<Criptomoneda> criptomonedas = new ArrayList<Criptomoneda>();
		List<Mercado> mercados = new ArrayList<Mercado>();
		List<Historico> historicos = new ArrayList<Historico>();
		Trader trader = Trader.buscarTraderPorNombre(nombre, traders);

		Archivo archivoCripto = new Archivo("criptomonedas.csv");
		archivoCripto.cargarArchivoCriptomonedas(criptomonedas);

		Archivo archivoMercado = new Archivo("mercados.csv");
		archivoMercado.cargarArchivoMercado(mercados);

		Archivo archivoHistorico = new Archivo(nombre + "_historico.csv");
		archivoHistorico.cargarArchivoHistorico(historicos);

		while (opcion != 7) {
			switch (opcion) {
			case 1:
				// comprarCriptomoneda();

				System.out.println("\nOpción Comprar Criptomoneda seleccionada.");
				mostrarCriptomonedas(criptomonedas);
				System.out.println("Su Saldo es de: " + trader.getSaldoActual());
				AdministracionTrader.comprarCriptomonedas(criptomonedas, mercados, nombre, traders, historicos, sc);
				archivoHistorico.guardarArchivoHistorico(historicos);
				archivoMercado.guardarArchivoMercado(mercados);
				break;
			case 2:
				// venderCriptomoneda();
				System.out.println("\nOpción Vender Criptomoneda seleccionada.");
				
				AdministracionTrader.venderCriptomonedas(criptomonedas, mercados, nombre, traders, historicos, sc);
				archivoHistorico.guardarArchivoHistorico(historicos);
				archivoMercado.guardarArchivoMercado(mercados);
				break;
			case 3:
				// consultarCriptomoneda();
				System.out.println("\nOpción Consultar Criptomoneda seleccionada.");
				mostrarCriptomonedas(criptomonedas);
				AdministracionTrader.consultarCriptomoneda(criptomonedas, mercados, sc);
				break;
			case 4:
				// recomendarCriptomoneda();
				System.out.println("\nOpción Recomendar Criptomoneda seleccionada.");
				AdministracionTrader.recomendarCriptomoneda(criptomonedas, mercados);
				break;
			case 5:
				// consultarEstadoMercado();
				System.out.println("\nOpción Consultar estado actual del mercado seleccionada.");
				mostrarMercado(mercados);
				break;
			case 6:
				// archivoTransacciones();
				System.out.println("\nOpción Visualizar archivo Transacciones seleccionada.");
				AdministracionTrader.visualizarTransacciones(historicos);
				break;
			case 7:
				System.out.println("\nSaliendo del programa.");
				System.exit(0);
				break;
			default:
				System.out.println("Opción no válida.");
				break;
			}
			opcion = obtenerOpcion(mensaje, 1, 7, sc);
		}

		System.out.println("Gracias por Tradear.");
		sc.close();
	}

	public static int obtenerOpcion(String mensaje, int min, int max, Scanner scanner) {

		int opcion = 0;

		System.out.println(mensaje);

		do {
			System.out.print("Ingrese su opción(" + min + " - " + max + "): ");
			if (scanner.hasNextInt()) {
				opcion = scanner.nextInt();
			} else {
				System.out.println("Por favor, ingrese un número válido.");
				scanner.next();
			}
		} while (opcion > max || opcion < min);

		return opcion;
	}
}
