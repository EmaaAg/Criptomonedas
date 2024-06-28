package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import criptomonedas.Criptomoneda;
import criptomonedas.Mercado;
import menu.AdministracionAdministrador;

public class AdministracionAdministradorTest {

    private List<Criptomoneda> criptomonedas;
    private List<Mercado> mercados;

    @BeforeEach
    public void setUp() {
        criptomonedas = new ArrayList<>();
        mercados = new ArrayList<>();
        criptomonedas.add(new Criptomoneda("Bitcoin", "BTC", 30000.0));
        mercados.add(new Mercado("BTC", 1000000.0, 5.0, 10.0));
    }

    @Test
    public void testEliminarCriptomonedaExistente() {
        String input = "Bitcoin\n";
        Scanner sc = new Scanner(input);
        AdministracionAdministrador.eliminarCriptomoneda(criptomonedas, mercados, sc);
        sc.close();
        assertTrue(criptomonedas.isEmpty());
        assertTrue(mercados.isEmpty());
    }

    @Test
    public void testEliminarCriptomonedaNoExistente() {
        String input = "Ethereum\nN\n";
        Scanner sc = new Scanner(input);
        AdministracionAdministrador.eliminarCriptomoneda(criptomonedas, mercados, sc);
        sc.close();
        assertFalse(criptomonedas.isEmpty());
        assertFalse(mercados.isEmpty());
        assertEquals(1, criptomonedas.size());
        assertEquals(1, mercados.size());
    }

    @Test
    public void testCrearCriptomonedaNueva() {
        String input = "Ethereum\nETH\n2000,0\n";
        Scanner sc = new Scanner(input);
        AdministracionAdministrador.crearCriptomoneda(criptomonedas, mercados, sc);
        sc.close();
        assertEquals(2, criptomonedas.size());
        assertEquals(2, mercados.size());
        assertEquals("ETH", criptomonedas.get(1).getSimbolo());
    }

    @Test
    public void testModificarCriptomonedaExistente() {
        String input = "Bitcoin\nS\nBitcoinModificado\nBTCM\n35000,0\n";
        Scanner sc = new Scanner(input);
        AdministracionAdministrador.crearCriptomoneda(criptomonedas, mercados, sc);
        sc.close();
        assertEquals(1, criptomonedas.size());
        assertEquals(1, mercados.size());
        assertEquals("BTCM", criptomonedas.get(0).getSimbolo());
        assertEquals(35000.0, criptomonedas.get(0).getPrecioBase());
    }

    @Test
    public void testModificarCriptomonedaNoExistente() {
        String input = "Ethereum\nN\n";
        Scanner sc = new Scanner(input);
        AdministracionAdministrador.modificarCriptomoneda(criptomonedas, mercados, sc);
        sc.close();
        assertEquals(1, criptomonedas.size());
        assertEquals(1, mercados.size());
        assertEquals("BTC", criptomonedas.get(0).getSimbolo());
    }
}
