package com.parking.serialization;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListaCocheTest {
    private ListaCoche lu;
    private ListaCoche luVacia;
    private LocalDate fecha;
    private Usuario u;
    private Coche c;

    @Before
    public void setUp() {
        fecha = LocalDate.of(2000, Month.DECEMBER, 15);
        u = new Usuario("11111111A", "Unai", fecha);
        c = new Coche("1234ABC", u);
        List<Coche> coches = new ArrayList<>();
        coches.add(c);

        lu = new ListaCoche(coches);
        luVacia = new ListaCoche();
    }

    @Test
    public void testGetListCoches() {
        List<Coche> expected = new ArrayList<>();
        expected.add(c);

        assertEquals(expected, lu.getListCoches());
    }

    @Test
    public void testSetListCoches() {
        List<Coche> expected = new ArrayList<>();
        expected.add(c);

        luVacia.setListCoches(expected);
        assertEquals(expected, luVacia.getListCoches());
    }

    @Test
    public void testToString() {
        String expected = "ListaCoches: " + lu.getListCoches();
        assertEquals(expected, lu.toString());
    }
}
