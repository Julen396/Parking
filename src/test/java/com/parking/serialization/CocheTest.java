package com.parking.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import java.util.Date;
/**
 * Unit test for simple App.
 */
public class CocheTest {
    private Coche c1;
    private Coche c2;
    private Usuario u;
    private Date d;
    

    @Before
    public void setUp() {
        d = new Date(1995, 4,3);
        u = new Usuario("1234567A", "Koldo",d);
        c1 = new Coche("123123", u);
        c2 = new Coche();
        
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
        Usuario expected = new Usuario("7654321B", "Jon", d);
        c1.setPropietario(expected);
        assertEquals(expected, c1.getPropietario());
    }

    @Test
    public void testToString() {
        String expected = "(Matricula: 123123; Propietario: (DNI: 1234567A; nombre: Koldo; fecha de nacimiento: " + d.toString() + "))";
        assertEquals(expected, c1.toString());
    }
}

