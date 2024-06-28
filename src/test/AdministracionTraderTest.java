package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import criptomonedas.Historico;
import menu.AdministracionTrader;

public class AdministracionTraderTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private List<Historico> historicos;

    @BeforeEach
    public void setUp() {
        historicos = new ArrayList<>();
        historicos.add(new Historico("BTC", 1000.0));
        historicos.add(new Historico("ETH", 500.0));
        historicos.add(new Historico("ADA", 200.0));
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
  


}
