package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import criptomonedas.Administrador;
import criptomonedas.Trader;

public class Archivo {
	private String nombreArchivo;
	
	public Archivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
		
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
    public void cargarArchivo(List<Administrador> administradores, List<Trader> traders) {
        try (BufferedReader br = new BufferedReader(new FileReader(this.nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                String nombre = partes[0];
                
                if (partes.length == 2) { // Es Admin
                    String perfil = partes[1];
                    Administrador admin = new Administrador(nombre, perfil);
                    administradores.add(admin);
                } else if (partes.length == 4) { // Es Trader
                    String numeroDeCuenta = partes[1];
                    String nombreDeBanco = partes[2];
                    Double saldoActual = Double.parseDouble(partes[3]);
                    Trader trader = new Trader(nombre, numeroDeCuenta, nombreDeBanco, saldoActual);
                    traders.add(trader);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
	
}
