package com.parking.serialization;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ParkingTest {
	private Date fecha;
	private Usuario usuario;
	private Coche coche;
	private Plaza plaza1;
	private Parking parking;
	
	
    @Before
    public void setUp() {
    	
    	fecha = new Date(2000, 5, 15);
    	usuario = new Usuario("123456789A", "Aitor", fecha );
    	coche = new Coche("1234ABC", usuario);
    	plaza1 = new Plaza(3, "C", 12, coche);
    	parking = new Parking(2);
    }
    
    @Test
	public void testgetNumPlazas() {
        int expected = 2;
        assertEquals(expected, parking.getNumPlazas());
	}
    @Test
	public void testsetNumPlazas() {
        int expected = 1;
        parking.setNumPlazas(1);
        assertEquals(expected, parking.getNumPlazas());
	}
    @Test
	public void testgetPlazas() {
    	ArrayList<Plaza> plazas = new ArrayList<>();
		Plaza plaza2 = new Plaza(3, "C", 12, coche);
		plazas.add(plaza2);
		parking.setPlazas(plazas);
    	assertEquals(plazas, parking.getPlazas());
	}
    @Test
	public void testsetPlazas() {
		ArrayList<Plaza> plazas = new ArrayList<>();
		Plaza plaza2 = new Plaza(3, "C", 12, coche);
		plazas.add(plaza2);
		parking.setPlazas(plazas);
		assertEquals(plazas, parking.getPlazas());
	}
    @Test
	public void testgetNumPlazasLibres() {
    	int expected = 1;
		ArrayList<Plaza> plazas = new ArrayList<>();
		Plaza plaza2 = new Plaza(3, "C", 12, coche);
		plazas.add(plaza2);
		parking.setPlazas(plazas);
    	assertEquals(expected, parking.getNumPlazasLibres());
	}

    @Test
	public void testToString() {
    	String expected = "" + 2;
    	assertEquals(expected, parking.toString());
	}
	
}
