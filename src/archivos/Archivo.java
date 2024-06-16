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
import criptomonedas.Criptomoneda;
import criptomonedas.Mercado;
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
	
    public void cargarArchivoUsuarios(List<Administrador> administradores, List<Trader> traders) {
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
    public void cargarArchivoCriptomonedas(List<Criptomoneda> criptomonedas) {
    	try (BufferedReader br = new BufferedReader(new FileReader(this.nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                String nombre = partes[0];                
            	String simbolo = partes[1];
            	Double precioBase = Double.parseDouble(partes[2]);
            	
            	Criptomoneda criptomoneda = new Criptomoneda(nombre, simbolo, precioBase);
            	criptomonedas.add(criptomoneda);
            	
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

	public void cargarArchivoMercado(List<Mercado> mercados) {
		try (BufferedReader br = new BufferedReader(new FileReader(this.nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
            	String simbolo = partes[0];
            	Double capacidad = Double.parseDouble(partes[1].replace(",", "."));
            	Double volumen = Double.parseDouble(partes[2].replace(",", ".").replace("%", ""));
            	Double variacion = Double.parseDouble(partes[3].replace(",", ".").replace("%", "").replace("+", ""));

            	Mercado mercado = new Mercado(simbolo, capacidad, volumen, variacion);
            	mercados.add(mercado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }		
	}
	
}
