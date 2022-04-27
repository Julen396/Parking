package com.parking.serialization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class UsuarioTest {
    private Usuario u;

    @Before
    public void setUp() {
        u = new Usuario("1234567A", "Jon", null);
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
/* 
    @Test
    public void testGetFecha_nac() {
       
    }
    @Test
    public void testSetFecha_nac() {
        
    }
*/
    @Test
    public void testToString() {
        String expected = "(DNI: 1234567A; nombre: Jon; fecha de nacimiento: null)";
        assertEquals(expected, u.toString());
    }
    
}
