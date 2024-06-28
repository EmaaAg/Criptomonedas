package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import criptomonedas.Historico;

public class HistoricoTest {

    private List<Historico> historicos;

    @BeforeEach
    public void setUp() {
        historicos = new ArrayList<>();
        historicos.add(new Historico("BTC", 1000.0));
        historicos.add(new Historico("ETH", 500.0));
        historicos.add(new Historico("ADA", 200.0));
    }

    @Test
    public void testBuscarHistoricoPorSimboloExistente() {
        Historico resultado = Historico.buscarHistoricoPorSimbolo("ETH", historicos);
        assertEquals("ETH", resultado.getSimbolo());
        assertEquals(500.0, resultado.getCantidad());
    }

    @Test
    public void testBuscarHistoricoPorSimboloNoExistente() {
        Historico resultado = Historico.buscarHistoricoPorSimbolo("XRP", historicos);
        assertEquals(null, resultado);
    }

    @Test
    public void testCompareTo() {
        Collections.sort(historicos);
        assertTrue(historicos.get(0).getCantidad() >= historicos.get(1).getCantidad());
        assertTrue(historicos.get(1).getCantidad() >= historicos.get(2).getCantidad());
    }
}
