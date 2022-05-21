package com.parking.serialization;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
/**
 * Test unitario de la clase parking
 *
 */
public class ParkingTest {
	private LocalDate fecha;
	private Usuario usuario;
	private Coche coche;
	private Plaza plaza1;
	private Plaza plaza2;
	private Parking parking;
	
	
    @Before
    public void setUp() {

    	fecha = LocalDate.of(2000, Month.MAY, 15);
    	usuario = new Usuario("123456789A", "Aitor", fecha );
    	coche = new Coche("1234ABC", usuario);
    	plaza1 = new Plaza(3, "C", 12, coche);
		plaza2 = new Plaza(2, "A", 12, null);
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
		Plaza plaza3 = new Plaza(3, "C", 12, coche);
		plazas.add(plaza2);
		plazas.add(plaza3);
		parking.setPlazas(plazas);
    	assertEquals(expected, parking.getNumPlazasLibres());
	}

    @Test
	public void testToString() {
    	ArrayList<Plaza> plazas = new ArrayList<>();
    	Plaza plaza2 = new Plaza(3, "C", 12, coche);
    	Plaza plaza3 = new Plaza(4, "C", 14, null);
		plazas.add(plaza2);
		plazas.add(plaza3);
		parking.setPlazas(plazas);
    	String expected = "" + 2;
    	assertEquals(expected, parking.toString());
	}
	
}
