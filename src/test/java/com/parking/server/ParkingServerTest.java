package com.parking.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.serialization.Coche;
import com.parking.serialization.Plaza;
import com.parking.serialization.Usuario;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RunWith(MockitoJUnitRunner.class)
public class ParkingServerTest {
	
	private Coche coche1;
	//ParkingServer parkingServer;
	private Usuario usuario;
	private Date fecha;
	private Plaza plaza1;
	
	
	ParkingServer parkingServer;
	@Before
	public void setUp() {
		coche1 = new Coche("1234ABC", usuario);
		fecha = new Date(2000, 5, 15);
		usuario = new Usuario("123456789A", "Aitor", fecha);
		plaza1 = new Plaza(3, "C", 12, coche1);
		parkingServer= org.mockito.Mockito.mock(ParkingServer.class);
	}
	@Test
	public void testanadirCoche() {
		
		when(parkingServer.anadirCoche(coche1)).thenReturn(Response.ok(coche1, MediaType.APPLICATION_JSON).build());
		
		Response response = parkingServer.anadirCoche(coche1);
		
		assertEquals(coche1, response.getEntity());
	}
	
	@Test
	public void testgetCoches() {
	
		ArrayList<Coche> coches = new ArrayList<>();
		coches.add(coche1);	
		
		when(parkingServer.getCoches()).thenReturn(Response.ok(coches, MediaType.APPLICATION_JSON).build());
		
		Response response = parkingServer.getCoches();
		
		assertEquals(coches, response.getEntity());
	}
	
	@Test
	public void testanadirPlaza() {
		
		when(parkingServer.anadirPlaza(plaza1)).thenReturn(Response.ok(plaza1, MediaType.APPLICATION_JSON).build());
		
		Response response = parkingServer.anadirPlaza(plaza1);
		
		assertEquals(plaza1, response.getEntity());
	}
	
	@Test
	public void testgetPlazas() {
		
		ArrayList<Plaza> plazas = new ArrayList<>();
		plazas.add(plaza1);	
		
		when(parkingServer.getPlazas()).thenReturn(Response.ok(plazas, MediaType.APPLICATION_JSON).build());
		
		Response response = parkingServer.getPlazas();
		
		assertEquals(plazas, response.getEntity());
	}
	
}
