package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import criptomonedas.Mercado;

class MercadoTest {

    private Mercado mercado;
    private List<Mercado> mercados;

    @BeforeEach
    public void setUp() {
        mercado = new Mercado("BTC", 1000.0, 200.0, 2.0);
        mercados = new ArrayList<>();
        mercados.add(mercado);
    }

    @Test
    public void testGetSimbolo() {
        assertEquals("BTC", mercado.getSimbolo());
    }

    @Test
    public void testSetSimbolo() {
        mercado.setSimbolo("ETH");
        assertEquals("ETH", mercado.getSimbolo());
    }

    @Test
    public void testGetCapacidad() {
        assertEquals(1000.0, mercado.getCapacidad());
    }

    @Test
    public void testSetCapacidad() {
        mercado.setCapacidad(1500.0);
        assertEquals(1500.0, mercado.getCapacidad());
    }

    @Test
    public void testGetVolumen() {
        assertEquals(200.0, mercado.getVolumen());
    }

    @Test
    public void testSetVolumen() {
        mercado.setVolumen(250.0);
        assertEquals(250.0, mercado.getVolumen());
    }

    @Test
    public void testGetVariacion() {
        assertEquals(2.0, mercado.getVariacion());
    }

    @Test
    public void testSetVariacion() {
        mercado.setVariacion(3.0);
        assertEquals(3.0, mercado.getVariacion());
    }

    @Test
    public void testBuscarMercadoPorSimbolo() {
        assertEquals(mercado, Mercado.buscarMercadoPorSimbolo("BTC", mercados));
        assertNull(Mercado.buscarMercadoPorSimbolo("ETH", mercados));
    }

    @Test
    public void testToString() {
        String cadena = "Simbolo: [BTC], Capacidad: [1000.0], Volumen: [200.0%], Variación: [+2.0%]";
        assertEquals(cadena, mercado.toString());
    }

}
