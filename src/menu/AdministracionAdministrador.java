package menu;

import java.util.List;
import java.util.Scanner;

import criptomonedas.Criptomoneda;
import criptomonedas.Mercado;

public class AdministracionAdministrador {
	public static void administrador() {
		
	}
	public static void eliminarCriptomoneda(List<Criptomoneda> criptomonedas, List<Mercado> mercados) {
	    Scanner sc = new Scanner(System.in);
	    String nombre;
	    boolean encontrado = false;

	    do {
	        System.out.println("Ingrese Nombre de la Criptomoneda que desea eliminar: ");
	        nombre = sc.nextLine();

	        // Buscar la criptomoneda en la lista
	        Criptomoneda criptomonedaExistente = Criptomoneda.buscarCriptomonedaPorNombre(nombre, criptomonedas);

	        if (criptomonedaExistente != null) {
	            // Eliminar la criptomoneda de la lista
	            criptomonedas.remove(criptomonedaExistente);

	            // Buscar el mercado asociado y eliminarlo de la lista de mercados
	            Mercado mercadoAsociado = Mercado.buscarMercadoPorSimbolo(criptomonedaExistente.getSimbolo(), mercados);
	            if (mercadoAsociado != null) {
	                mercados.remove(mercadoAsociado);
	            }

	            System.out.println("Criptomoneda y mercado asociado eliminados exitosamente.");
	            encontrado = true; // Se encontró y eliminó la criptomoneda, salir del bucle
	        } else {
	            System.out.println("La criptomoneda no se encontró en la lista.");
	            System.out.println("¿Desea intentar de nuevo? (S/N)");
	            String respuesta = sc.nextLine();
	            if (!respuesta.equalsIgnoreCase("S")) {
	                break; // Salir del bucle si no desea intentar de nuevo
	            }
	        }
	    } while (!encontrado);

	    sc.close();
	}


	
	public static void crearCriptomoneda(List<Criptomoneda> criptomonedas, List<Mercado> mercados) {
	    Scanner sc = new Scanner(System.in);
	    String nombre;
	    String simbolo;
	    Double precioBase;

	    System.out.println("Ingrese Nombre de la Criptomoneda: ");
	    nombre = sc.nextLine();

	    // Buscar si ya existe la criptomoneda
	    Criptomoneda criptomonedaExistente = Criptomoneda.buscarCriptomonedaPorNombre(nombre, criptomonedas);

	    if (criptomonedaExistente != null) {
	        // Si la criptomoneda existe, ofrecer modificarla
	        System.out.println("La criptomoneda ya existe, ¿Desea modificar algun parámetro? (S = sí, N = no):");
	        String op = sc.nextLine();
	        if (op.equalsIgnoreCase("s")) {
	            System.out.println("Ingrese el nuevo nombre para " + nombre + ": ");
	            nombre = sc.nextLine(); // Usar nextLine() para leer el nombre modificado
	            System.out.println("Ingrese el nuevo simbolo: ");
	            simbolo = sc.nextLine().toUpperCase(); // Usar nextLine() para leer el símbolo modificado
	            System.out.println("Ingrese el nuevo precio base: ");
	            precioBase = sc.nextDouble();

	            // Crear una nueva instancia con los valores modificados
	            Criptomoneda criptomonedaModificada = new Criptomoneda(nombre, simbolo, precioBase);

	            // Reemplazar la criptomoneda existente en la lista
	            int index = criptomonedas.indexOf(criptomonedaExistente);
	            criptomonedas.set(index, criptomonedaModificada);

	            System.out.println("Criptomoneda modificada exitosamente.");
	        } else {
	            System.out.println("Operación cancelada.");
	        }
	    } else {
	        // Si la criptomoneda no existe, solicitar símbolo y precio base
	        System.out.println("Ingrese Símbolo de la Criptomoneda: ");
	        simbolo = sc.nextLine().toUpperCase();
	        System.out.println("Ingrese Precio en Dólares de la Criptomoneda: ");
	        precioBase = sc.nextDouble();

	        // Crear nueva criptomoneda y agregarla a la lista
	        Criptomoneda criptomoneda = new Criptomoneda(nombre, simbolo, precioBase);
	        criptomonedas.add(criptomoneda);

	        // Crear nuevo mercado y agregarlo a la lista de mercados
	        Mercado mercado = new Mercado(simbolo);
	        mercados.add(mercado);

	        System.out.println("Criptomoneda creada exitosamente.");
	    }

	    sc.close();
	}

	
	public static void modificarCriptomoneda(List<Criptomoneda> criptomonedas, List<Mercado> mercados) {
	    Scanner sc = new Scanner(System.in);
	    String nombre;
	    String simbolo;
	    Double precioBase;
	    
	    do {
	        System.out.println("Ingrese la Criptomoneda que desea modificar: ");
	        nombre = sc.next();
	        
	        // Buscar la criptomoneda usando la función buscarCriptomonedaPorNombre
	        Criptomoneda criptomonedaExistente = Criptomoneda.buscarCriptomonedaPorNombre(nombre, criptomonedas);
	        Mercado mercadoExistente = Mercado.buscarMercadoPorSimbolo(criptomonedaExistente.getSimbolo(), mercados);
	        // Si se encuentra la criptomoneda, modificarla
	        if (criptomonedaExistente != null && mercadoExistente != null) {
	            System.out.println("Ingrese el nuevo nombre para " + nombre + ": ");
	            nombre = sc.next();
	            System.out.println("Ingrese el nuevo simbolo: ");
	            simbolo = sc.next();
	            System.out.println("Ingrese el nuevo precio base: ");
	            precioBase = sc.nextDouble();
	            
	            // Crear una nueva instancia con los valores modificados
	            Criptomoneda criptomonedaModificada = new Criptomoneda(nombre, simbolo, precioBase);
	            
	            // Reemplazar la criptomoneda existente en la lista
	            int indexCripto = criptomonedas.indexOf(criptomonedaExistente);
	            criptomonedas.set(indexCripto, criptomonedaModificada);
	            
	            Mercado mercadoModificado = new Mercado(simbolo);
	            int indexMercado = mercados.indexOf(mercadoExistente);
	            mercados.set(indexMercado, mercadoModificado);
	            
	            System.out.println("Criptomoneda y Mercado modificados exitosamente.");
	            break; // Salir del bucle al modificar correctamente
	        } else {
	            System.out.println("La criptomoneda no se encontró en la lista.");
	            System.out.println("¿Desea intentar de nuevo? (S/N)");
	            String respuesta = sc.next();
	            if (!respuesta.equalsIgnoreCase("S")) {
	                break; // Salir del bucle si no desea intentar de nuevo
	            }
	        }
	    } while (true); // Repetir hasta que se encuentre la criptomoneda o el usuario decida no continuar
	    
	    sc.close();
	}


	
}
