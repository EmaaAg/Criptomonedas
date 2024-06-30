package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import criptomonedas.Criptomoneda;
import criptomonedas.Historico;
import criptomonedas.Mercado;
import criptomonedas.Trader;
import menu.AdministracionTrader;

public class AdministracionTraderTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private List<Historico> historicos;
    private List<Mercado> mercados;
    private List<Criptomoneda> criptomnonedas;
    private List<Trader> traders;
    
    @BeforeEach
    public void setUp() {
        historicos = new ArrayList<>();
        historicos.add(new Historico("BTC", 1000.0));
        historicos.add(new Historico("ETH", 500.0));
        historicos.add(new Historico("ADA", 200.0));
        
        mercados = new ArrayList<>();
        mercados.add(new Mercado("BTC", 1000.0, 7.1, 17.3));
        mercados.add(new Mercado("ETH", 200.0, 2.1, 0.5));
        mercados.add(new Mercado("ADA", 5500.0, 2.1, 0.5));
        
        criptomnonedas = new ArrayList<>();
        criptomnonedas.add(new Criptomoneda("Bitcoin", "BTC", 500.0));
        criptomnonedas.add(new Criptomoneda("Ethereum", "ETH", 2000.0));
        criptomnonedas.add(new Criptomoneda("Cardano", "ADA", 1333.0));
        
        traders = new ArrayList<>();
        traders.add(new Trader("Pablo", "12345678", "Banco Nacion", 100000.0));
        traders.add(new Trader("Ema", "98765432", "Banco Provincia", 200000.0));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testVisualizarTransacciones() {
        System.setOut(new PrintStream(outputStreamCaptor));

        AdministracionTrader.visualizarTransacciones(historicos);

        String expectedOutput = "Simbolo: [BTC], Cantidad: [1000.0].\r\n"
                + "Simbolo: [ETH], Cantidad: [500.0].\r\n"
                + "Simbolo: [ADA], Cantidad: [200.0].\r\n";

        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
  
    @Test
    public void testComprarCriptomonedas() {
    	String input = "BTC\n100\n";
    	Scanner sc = new Scanner(input);
    	AdministracionTrader.comprarCriptomonedas(criptomnonedas, mercados, "Pablo", traders, historicos, sc);
    	
    	assertEquals(50000,traders.get(0).getSaldoActual());
    	assertEquals(900, mercados.get(0).getCapacidad());
    	assertEquals(1100, historicos.get(0).getCantidad());
    }
    
    @Test
    public void testVenderCriptomonedas() {
    	String input = "BTC\n500\n";
    	Scanner sc = new Scanner(input);
    	AdministracionTrader.venderCriptomonedas(criptomnonedas, mercados, "Pablo", traders, historicos, sc);
    	
    	assertEquals(350000, traders.get(0).getSaldoActual());
    	assertEquals(1500, mercados.get(0).getCapacidad());
    	assertEquals(500, historicos.get(0).getCantidad());
    }

}
