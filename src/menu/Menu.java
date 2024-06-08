package menu;

import java.util.Scanner;

public class Menu {
	
	public static void menu() {
		
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
	
    public static int obtenerOpcion(String mensaje, int min, int max, Scanner scanner) {

        int opcion = 0;

        System.out.println(mensaje);

        do {
            System.out.print("Ingrese su opción: ");
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
