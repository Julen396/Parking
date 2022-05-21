package com.parking.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
/**
 * Test unitario de la clase Lista Usuarios
 *
 */
public class ListaUsuariosTest {
    private ListaUsuarios lu;
    private ListaUsuarios luVacia;
    private LocalDate fecha;
    private Usuario u;

    @Before
    public void setUp() {
        fecha = LocalDate.of(2000, Month.DECEMBER, 15);
        u = new Usuario("11111111A", "Unai", fecha);

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(u);

        lu = new ListaUsuarios(usuarios);
        luVacia = new ListaUsuarios();
    }

    @Test
    public void testGetListUsuarios() {
        List<Usuario> expected = new ArrayList<>();
        expected.add(u);

        assertEquals(expected, lu.getListUsuarios());
    }

    @Test
    public void testSetListUsuarios() {
        List<Usuario> expected = new ArrayList<>();
        expected.add(u);

        luVacia.setListUsuarios(expected);
        assertEquals(expected, luVacia.getListUsuarios());
    }

    @Test
    public void testToString() {
        String expected = "ListaUsuarios: " + lu.getListUsuarios();
        assertEquals(expected, lu.toString());
    }
}
