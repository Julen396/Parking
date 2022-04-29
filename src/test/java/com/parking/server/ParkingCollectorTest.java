package com.parking.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.serialization.Coche;
import com.parking.serialization.Parking;
import com.parking.serialization.Plaza;
import com.parking.serialization.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class ParkingCollectorTest {
	
	
	private Date fecha;
	private Usuario usuario;
	private Coche coche;
	private Plaza plaza1;
	private Parking parking1;
	
	private ParkingCollector parkingCollector;
	
	
	
    @Before
    public void setUp() {
    	
    	fecha = new Date(2000, 5, 15);
    	usuario = new Usuario("123456789A", "Aitor", fecha );
    	coche = new Coche("1234ABC", usuario);
    	plaza1 = new Plaza(3, "C", 12, coche);
    	parking1 = new Parking(2);
    	
    	parkingCollector= org.mockito.Mockito.mock(ParkingCollector.class);
    }
	
    @Test
	public void testaddParking(){
    	ArrayList<Parking> parkings = new ArrayList();
    	parkings.add(parking1);
    	
    	when(parkingCollector.addParking(parking1)).thenReturn(parkings);
    	
    	assertEquals(parkings, parkingCollector.addParking(parking1));
		
	}
}
