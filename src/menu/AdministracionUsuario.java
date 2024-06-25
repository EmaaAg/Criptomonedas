package menu;

import java.util.List;
import java.util.Scanner;

import criptomonedas.Criptomoneda;
import criptomonedas.Mercado;

public abstract class AdministracionUsuario {
	
	public static void consultarCriptomoneda(List<Criptomoneda> criptomonedas, List<Mercado> mercados, Scanner sc) {
	    String respuesta;

	    do {
	        System.out.println("Ingrese el nombre o símbolo de la criptomoneda que desea consultar: ");
	        String consulta = sc.next().toUpperCase();

	        boolean encontrada = false;

	        for (Criptomoneda criptomoneda : criptomonedas) {
	            if (criptomoneda.getNombre().equalsIgnoreCase(consulta) || criptomoneda.getSimbolo().equalsIgnoreCase(consulta)) {
	                System.out.println("\nNombre: " + criptomoneda.getNombre() +
	                                   " Símbolo: " + criptomoneda.getSimbolo() +
	                                   " Precio en dólares: " + String.format("%,.1f", criptomoneda.getPrecioBase()));
	                System.out.println("\nDatos del mercado:");
	                
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

	        System.out.println("\n¿Desea consultar otra criptomoneda? (S/N)");
	        respuesta = sc.next();
	    } while (respuesta.equalsIgnoreCase("S"));

	    System.out.println("Consulta de criptomonedas finalizada.");
	}
}
