package com.parking.serialization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PlazaTest {
    private Plaza p1;
    private Plaza p2;
    private Coche c1;

    @Before
    public void setUp() {
        c1 = new Coche("123123", null);

        p1 = new Plaza();
        p2 = new Plaza(3, "C", 12, c1);
    }

    @Test
    public void testGetPiso() {
        int expected = 3;
        assertEquals(expected, p2.getPiso());
    }
    @Test
    public void testSetPiso() {
        p1.setPiso(2);
        int expected = 2;
        assertEquals(expected, p1.getPiso());
    }

    @Test
    public void testGetZona() {
        String expected = "C";
        assertEquals(expected, p2.getZona());
    }
    @Test
    public void testSetZona() {
        p1.setZona("B");
        String expected = "B";
        assertEquals(expected, p1.getZona());
    }

    @Test
    public void testGetPosicion() {
        int expected = 12;
        assertEquals(expected, p2.getPosicion());
    }
    @Test
    public void testSetPosicion() {
        p1.setPosicion(21);
        int expected = 21;
        assertEquals(expected, p1.getPosicion());
    }

    @Test
    public void testGetCoche() {
        assertEquals(c1, p2.getCoche());
    }
    @Test
    public void testSetCoche() {
        Coche expected = new Coche("21", null);
        p1.setCoche(expected);
        assertEquals(expected, p1.getCoche());
    }

    @Test
    public void testToString() {
        String expected = "(Piso: 3; Zona: C; Posicion: 12; Coche: (Matricula: 123123; Propietario: null))";
        assertEquals(expected, p2.toString());
    }

    @Test
    public void testDesocupar() {
        p1.desocupar();
    }
}
