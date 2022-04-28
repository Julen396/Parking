package com.parking.serialization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class UsuarioTest {
    private Usuario u;
    private Date d;
    private Date d1;

    @Before
    public void setUp() {
        d = new Date(1995, 4,3);
        d1 = new Date(1940, 11,30);
        u = new Usuario("1234567A", "Jon", d);
    }

    @Test
    public void testGetDni() {
        String expected = "1234567A";
        assertEquals(expected, u.getDni());
    }
    @Test
    public void testSetDni() {
        u.setDni("8765432Z");
        String expected = "8765432Z";
        assertEquals(expected, u.getDni());
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
       Date expected = new Date(1995, 4,3);
       assertEquals(expected, u.getFecha_nac());
    }
    @Test
    public void testSetFecha_nac() {
        u.setFecha_nac(new Date(1940, 11,30));
        Date expected = d1;
        assertEquals(expected, u.getFecha_nac());
    }

    @Test
    public void testToString() {
        String expected = "(DNI: 1234567A; nombre: Jon; fecha de nacimiento: " + d.toString() + ")";
        assertEquals(expected, u.toString());
    }
    
}
