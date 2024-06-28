package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import criptomonedas.Trader;

class TraderTest {

    private Trader trader;
    private List<Trader> traders;

    @BeforeEach
    public void setUp() {
        trader = new Trader("Test Trader", "123456789", "Test Banco", 1000.0);
        traders = new ArrayList<>();
        traders.add(trader);
    }

    @Test
    public void testGetNumeroDeCuenta() {
        assertEquals("123456789", trader.getNumeroDeCuenta());
    }

    @Test
    public void testSetNumeroDeCuenta() {
        trader.setNumeroDeCuenta("987654321");
        assertEquals("987654321", trader.getNumeroDeCuenta());
    }

    @Test
    public void testGetNombreDeBanco() {
        assertEquals("Test Banco", trader.getNombreDeBanco());
    }

    @Test
    public void testSetNombreDeBanco() {
        trader.setNombreDeBanco("Nuevo Banco");
        assertEquals("Nuevo Banco", trader.getNombreDeBanco());
    }

    @Test
    public void testGetSaldoActual() {
        assertEquals(1000.0, trader.getSaldoActual());
    }

    @Test
    public void testSetSaldoActual() {
        trader.setSaldoActual(2000.0);
        assertEquals(2000.0, trader.getSaldoActual());
    }

    @Test
    public void testVerificarUsuario() {
        assertTrue(trader.verificarUsuario());
    }

    @Test
    public void testBuscarTrader() {
        assertTrue(Trader.buscarTrader("Test Trader", traders));
        assertFalse(Trader.buscarTrader("Trader 1 ", traders));
    }

    @Test
    public void testBuscarTraderPorNombre() {
        assertEquals(trader, Trader.buscarTraderPorNombre("Test Trader", traders));
        assertNull(Trader.buscarTraderPorNombre("Trader 1 ", traders));
    }

    @Test
    public void testToString() {
        String cadena = "Nombre: [Test Trader], Numero De Cuenta: [123456789], Nombre De Banco: [Test Banco], saldoActual: [1000.0].";
        assertEquals(cadena, trader.toString());
    }

}
