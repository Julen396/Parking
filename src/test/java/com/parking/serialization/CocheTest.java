package com.parking.serialization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CocheTest {
    private Coche c1;
    private Usuario u;

    @Before
    public void setUp() {
        u = new Usuario("1234567A", "Koldo",null);
        c1 = new Coche("123123", u);
        
    }

    @Test
    public void testGetMatricula() {
        String expected = "123123";
        assertEquals(expected, c1.getMatricula());
    }
    @Test
    public void testSetMatricula() {
        c1.setMatricula("123123");
        String expected = "123123";
        assertEquals(expected, c1.getMatricula());
    }

    @Test
    public void testGetPropietario() {
        assertEquals(u, c1.getPropietario());
    }
    @Test
    public void testSetPropietario() {
        Usuario expected = new Usuario("7654321B", "Jon", null);
        c1.setPropietario(expected);
        assertEquals(expected, c1.getPropietario());
    }

    @Test
    public void testToString() {
        String expected = "(Matricula: 123123; Propietario: (DNI: 1234567A; nombre: Koldo; fecha de nacimiento: null))";
        assertEquals(expected, c1.toString());
    }
}

