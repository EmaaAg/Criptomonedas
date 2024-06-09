package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import archivos.Archivo;
import criptomonedas.Administrador;
import criptomonedas.Trader;

public class Menu {
	
	public static void menu() {
		List<Trader> traders = new ArrayList<Trader>();
		List<Administrador> admin = new ArrayList<Administrador>();
		
		Scanner sc = new Scanner(System.in);
		String nombre;
		
		
		Archivo archivo = new Archivo("usuarios.csv");
		archivo.cargarArchivo(admin, traders);
		
//		for (Administrador administrador : admin) {
//			System.out.println(administrador);
//		}
		for (Trader trader : traders) {
			System.out.println(trader);			
		}
		
		System.out.println("Ingrese su nombre");
		nombre = sc.nextLine();
		
		//Buscar en la lista de Traders y Admins
		if(criptomonedas.Administrador.buscarAdmin(nombre, admin)) {
			menuAdmin();
		}
		
		if(criptomonedas.Trader.buscarTrader(nombre, traders)) {
			menuTrader();
		}
		else
		{
			//crearTrader
			
			System.out.println("Ingrese Numero de cuenta bancaria: ");
			String numeroDeCuenta = sc.nextLine();
			
			System.out.println("Ingrese nuemero de Banco: ");
			String nombreDeBanco = sc.nextLine();
			
			System.out.println("Ingrese Saldo Actual: "); ///verificar saldo
			Double saldo = sc.nextDouble();
			
			Trader tra = new Trader(nombre, numeroDeCuenta, nombreDeBanco, saldo);
			
			traders.add(tra);			
		}
		
		for (Trader trader : traders) {
			System.out.println(trader);			
		}
		
		//Si no esta en ninguna crear un nuevo trader
		sc.close();
	}
	
	public static void menuAdmin() {
		
		String mensaje = 
				"1) Crear Criptomoneda.\n" +
                "2) Modificar Criptomoneda.\n" +
                "3) Eliminar Criptomoneda.\n" +
                "4) Consultar Criptomoneda.\n" +
                "5) Consultar estado actual del mercado.\n" +
                "6) Salir.\n";
        Scanner sc = new Scanner(System.in);
        int opcion = obtenerOpcion(mensaje, 1, 6, sc); 

        switch (opcion) {
	        case 1:
	            //crearCriptomoneda();
	            System.out.println("Opción Crear Criptomoneda seleccionada.");
	            break;
	        case 2:
	            //modificarCriptomoneda();
	            System.out.println("Opción Modificar Criptomoneda seleccionada.");
	            break;
	        case 3:
	            //eliminarCriptomoneda();
	            System.out.println("Opción Eliminar Criptomoneda seleccionada.");
	            break;
	        case 4:
	            //consultarCriptomoneda();
	            System.out.println("Opción Consultar Criptomoneda seleccionada.");
	            break;
	        case 5:
	            //consultarEstadoMercado();
	            System.out.println("Opción Consultar estado actual del mercado seleccionada.");
	            break;
	        case 6:
	            System.out.println("Saliendo del programa.");
                System.exit(0);
	            break;
	        default:
	            System.out.println("Opción no válida.");
	            break;
        }
        sc.close();
	}
	
	public static void menuTrader() {
		
		String mensaje = 
				"1) Comprar Criptomonedas.\n" +
                "2) Vender Criptomonedas.\n" +
                "3) Consultar Criptomoneda.\n" +
                "4) Recomendar Criptomonedas.\n" +
                "5) Consultar estado actual del mercado.\n" +
                "6) Visualizar archivo de transacciones (histórico).\n" +
                "7) Salir.\n";
        Scanner sc = new Scanner(System.in);
        int opcion = obtenerOpcion(mensaje, 1, 7, sc); 

        switch (opcion) {
	        case 1:
	            //comprarCriptomoneda();
	            System.out.println("Opción Comprar Criptomoneda seleccionada.");
	            break;
	        case 2:
	            //venderCriptomoneda();
	            System.out.println("Opción Vender Criptomoneda seleccionada.");
	            break;
	        case 3:
	            //consultarCriptomoneda();
	            System.out.println("Opción Consultar Criptomoneda seleccionada.");
	            break;
	        case 4:
	            //recomendarCriptomoneda();
	            System.out.println("Opción Recomendar Criptomoneda seleccionada.");
	            break;
	        case 5:
	            //consultarEstadoMercado();
	            System.out.println("Opción Consultar estado actual del mercado seleccionada.");
	            break;
	        case 6:
	        	//archivoTransacciones();
	        	System.out.println("Opción Visualizar archivo Transacciones.");
	        	break;
	        case 7:
	            System.out.println("Saliendo del programa.");
                System.exit(0);
	            break;
	        default:
	            System.out.println("Opción no válida.");
	            break;
        }
        sc.close();
	}
	
    public static int obtenerOpcion(String mensaje, int min, int max, Scanner scanner) {

        int opcion = 0;

        System.out.println(mensaje);

        do {
            System.out.print("Ingrese su opción("+ min + " - " + max + "): ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
        } while (opcion > max || opcion < min);

        // scanner.close();

        return opcion;
    }
}
