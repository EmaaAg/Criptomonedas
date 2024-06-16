package menu;

import java.util.Scanner;

import criptomonedas.Criptomoneda;

public class AdministracionAdministrador {
	public static void administrador() {
		
	}
	
	
	public static void crearCriptomoneda() {
		String nombre;
		String simbolo;
		Double precioBase;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese Nombre de la Criptomoneda: ");
		nombre = sc.nextLine();
		System.out.println("Ingrese Simbolo de la Criptomoneda: ");
		simbolo = sc.nextLine();
		System.out.println("Ingrese Precio en Dolares de la Criptomoneda: ");
		precioBase = sc.nextDouble();		
		
		Criptomoneda criptomoneda = new Criptomoneda(nombre, simbolo, precioBase);
		
		sc.close();
	}
	
	public static void modificarCriptomoneda() {
		
	}
	
}
