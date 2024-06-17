package menu;

import java.util.List;
import java.util.Scanner;

import criptomonedas.Criptomoneda;
import criptomonedas.Mercado;

public class AdministracionAdministrador {
	public static void administrador() {
		
	}
	
	
	public static void crearCriptomoneda(List<Criptomoneda> criptomonedas, List<Mercado> mercados) {
		String nombre;
		String simbolo;
		Double precioBase;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese Nombre de la Criptomoneda: ");
		nombre = sc.nextLine();
		
		//Buscar si ya existe
		if(Criptomoneda.buscarCriptomoneda(nombre, criptomonedas)) {
			System.out.println("La criptomoneda ya existe, ¿Desea Modificar algun parámetro?. (S = si, N = no)"); // Si ya existe preguntar si la quiere modificar
			String op = sc.nextLine();
			if(op.equalsIgnoreCase("s")) {
				modificarCriptomoneda();
			}
			else
			{
				//salir
				sc.close();
				return;
			}
		}
		else
		{
			System.out.println("Ingrese Simbolo de la Criptomoneda: ");
			simbolo = sc.nextLine().toUpperCase();
			System.out.println("Ingrese Precio en Dolares de la Criptomoneda: ");
			precioBase = sc.nextDouble();		
			
			Criptomoneda criptomoneda = new Criptomoneda(nombre, simbolo, precioBase);		
			criptomonedas.add(criptomoneda);
			
			Mercado mercado = new Mercado(simbolo);
			mercados.add(mercado);
		}		
		
		sc.close();
	}
	
	public static void modificarCriptomoneda(List<Criptomoneda> criptomonedas) {
	    Scanner sc = new Scanner(System.in);
	    String nombre;
	    String simbolo;
	    Double precioBase;
	    
	    do {
	        System.out.println("Ingrese la Criptomoneda que desea modificar: ");
	        nombre = sc.next();
	        
	        // Buscar la criptomoneda en la lista
	        Criptomoneda criptomonedaExistente = null;
	        for (Criptomoneda c : criptomonedas) {
	            if (c.getNombre().equalsIgnoreCase(nombre)) {
	                criptomonedaExistente = c;
	                break;
	            }
	        }
	        
	        // Si se encuentra la criptomoneda, modificarla
	        if (criptomonedaExistente != null) {
	            System.out.println("Ingrese el nuevo nombre para " + nombre + ": ");
	            nombre = sc.next();
	            System.out.println("Ingrese el nuevo simbolo: ");
	            simbolo = sc.next();
	            System.out.println("Ingrese el nuevo precio base: ");
	            precioBase = sc.nextDouble();
	            
	            // Crear una nueva instancia con los valores modificados
	            Criptomoneda criptomonedaModificada = new Criptomoneda(nombre, simbolo, precioBase);
	            
	            // Reemplazar la criptomoneda existente en la lista
	            int index = criptomonedas.indexOf(criptomonedaExistente);
	            criptomonedas.set(index, criptomonedaModificada);
	            
	            System.out.println("Criptomoneda modificada exitosamente.");
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
