package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import criptomonedas.Administrador;

class AdministradorTest {

	private Administrador administrador;
    private List<Administrador> administradores;

    @BeforeEach
    public void setUp() {
        administrador = new Administrador("Alice", "Administrador");
        administradores = new ArrayList<>();
        administradores.add(administrador);
    }

    @Test
    public void testGetPerfil() {
        assertEquals("Administrador", administrador.getPerfil());
    }

    @Test
    public void testSetPerfil() {
        administrador.setPerfil("Trader");
        assertEquals("Trader", administrador.getPerfil());
    }

    @Test
    public void testVerificarUsuario() {
        assertTrue(administrador.verificarUsuario());
        
        administrador.setPerfil("User");
        assertFalse(administrador.verificarUsuario());
    }

    @Test
    public void testBuscarAdmin() {
        assertTrue(Administrador.buscarAdmin("Alice", administradores));
        assertFalse(Administrador.buscarAdmin("Bob", administradores));
    }

    @Test
    public void testToString() {
        String expectedString = "Nombre: [Alice], Perfil: [Administrador].";
        assertEquals(expectedString, administrador.toString());
    }

}
