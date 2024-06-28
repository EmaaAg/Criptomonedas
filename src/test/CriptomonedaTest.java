package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import criptomonedas.Criptomoneda;

class CriptomonedaTest {

    private Criptomoneda criptomoneda;
    private List<Criptomoneda> criptomonedas;

    @BeforeEach
    public void setUp() {
        criptomoneda = new Criptomoneda("Bitcoin", "BTC", 50000.0);
        criptomonedas = new ArrayList<>();
        criptomonedas.add(criptomoneda);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Bitcoin", criptomoneda.getNombre());
    }

    @Test
    public void testSetNombre() {
        criptomoneda.setNombre("Ethereum");
        assertEquals("Ethereum", criptomoneda.getNombre());
    }

    @Test
    public void testGetSimbolo() {
        assertEquals("BTC", criptomoneda.getSimbolo());
    }

    @Test
    public void testSetSimbolo() {
        criptomoneda.setSimbolo("ETH");
        assertEquals("ETH", criptomoneda.getSimbolo());
    }

    @Test
    public void testGetPrecioBase() {
        assertEquals(50000.0, criptomoneda.getPrecioBase());
    }

    @Test
    public void testSetPrecioBase() {
        criptomoneda.setPrecioBase(60000.0);
        assertEquals(60000.0, criptomoneda.getPrecioBase());
    }

    @Test
    public void testBuscarCriptomoneda() {
        assertTrue(Criptomoneda.buscarCriptomoneda("Bitcoin", criptomonedas));
        assertFalse(Criptomoneda.buscarCriptomoneda("Nonexistent", criptomonedas));
    }

    @Test
    public void testBuscarCriptomonedaPorNombre() {
        assertEquals(criptomoneda, Criptomoneda.buscarCriptomonedaPorNombre("Bitcoin", criptomonedas));
        assertNull(Criptomoneda.buscarCriptomonedaPorNombre("Nonexistent", criptomonedas));
    }

    @Test
    public void testBuscarCriptomonedaPorSimbolo() {
        assertEquals(criptomoneda, Criptomoneda.buscarCriptomonedaPorSimbolo("BTC", criptomonedas));
        assertNull(Criptomoneda.buscarCriptomonedaPorSimbolo("NON", criptomonedas));
    }

    @Test
    public void testToString() {
        String cadena = "Nombre: [Bitcoin], Simbolo: [BTC], Precio Base: [50000.0].";
        assertEquals(cadena, criptomoneda.toString());
    }

}
