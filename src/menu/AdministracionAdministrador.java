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
			if(op.equals("s")) { //Corregir esto
				modificarCriptomoneda();
			}
			else
			{
				//salir
			}
		}
		else
		{
			System.out.println("Ingrese Simbolo de la Criptomoneda: ");
			simbolo = sc.nextLine();
			System.out.println("Ingrese Precio en Dolares de la Criptomoneda: ");
			precioBase = sc.nextDouble();		
			
			Criptomoneda criptomoneda = new Criptomoneda(nombre, simbolo, precioBase);		
			criptomonedas.add(criptomoneda);
			
			Mercado mercado = new Mercado(simbolo);
			mercados.add(mercado);
		}		
		
		sc.close();
	}
	
	public static void modificarCriptomoneda() {
		
	}
	
}
