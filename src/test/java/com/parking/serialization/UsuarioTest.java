package com.parking.serialization;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class UsuarioTest {
    private Usuario u;
    private Usuario uVacio;
    private LocalDate d;
    private LocalDate d1;

    @Before
    public void setUp() {
        d = LocalDate.of(1995, Month.FEBRUARY,3);
        d1 = LocalDate.of(1940, Month.NOVEMBER,30);
        u = new Usuario("1234567A", "Jon", d);
        uVacio = new Usuario();
    }

    @Test
    public void testGetDni() {
        String expected = "1234567A";
        assertEquals(expected, u.getDni());
    }
    @Test
    public void testSetDni() {
        u.setDni("8765432Z");
        uVacio.setDni("123456789");
        String expected = "8765432Z";
        assertEquals(expected, u.getDni());
        assertEquals("11111111A", uVacio.getDni());
    }

    @Test
    public void testGetNombre() {
        String expected = "Jon";
        assertEquals(expected, u.getNombre());
    }
    @Test
    public void testSetNombre() {
       u.setNombre("Iker");
       String expected = "Iker";
       assertEquals(expected, u.getNombre());
    }
 
    @Test
    public void testGetFecha_nac() {
       LocalDate expected = LocalDate.of(1995, Month.FEBRUARY,3);
       assertEquals(expected, u.getFecha_nac());
    }
    @Test
    public void testSetFecha_nac() {
        u.setFecha_nac(LocalDate.of(1940, Month.NOVEMBER,30));
        LocalDate expected = d1;
        assertEquals(expected, u.getFecha_nac());
    }

    @Test
    public void testToString() {
        String expected = "(DNI: 1234567A; nombre: Jon; fecha de nacimiento: " + d.toString() + ")";
        assertEquals(expected, u.toString());
    }
    
}
