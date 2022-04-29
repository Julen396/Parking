package com.parking.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.serialization.Coche;
import com.parking.serialization.Plaza;
import com.parking.serialization.PlazaDAO;
import com.parking.serialization.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class PlazaCollectorTest {
	
	private Plaza plaza1;
	private Coche c1;
	private Date fecha;
	private Usuario usuario;
	private ArrayList<Plaza> plazas;
	PlazaCollector plazaCollector;
	
	@Before
	public void setUp() {
	  	fecha = new Date(2000, 5, 15);
    	usuario = new Usuario("123456789A", "Aitor", fecha );
    	c1 = new Coche("1234ABC", usuario);
		plaza1 = new Plaza(3, "C", 12, c1);
		
		plazas = new ArrayList<>();
		plazas.add(plaza1);
		
		plazaCollector= org.mockito.Mockito.mock(PlazaCollector.class);
		
		
	}
    @Test	
	public void addPlaza() {
		when(plazaCollector.addPlaza(plaza1)).thenReturn(plazas);

		assertEquals(plazas, plazaCollector.addPlaza(plaza1));
    }

    @Test	
    public void getPlazas() {
    	
		when(plazaCollector.getPlazas()).thenReturn(plazas);
		
		assertEquals(plazas, plazaCollector.getPlazas());
    }
    
    @Test    
    public void ocuparPlaza() {
    	
    	when(plazaCollector.ocuparPlaza("1", c1)).thenReturn(true);
    	
    	assertTrue(plazaCollector.ocuparPlaza("1", c1));
    }
    
    @Test    
    public void desocuparPlaza() {
    	
    	when(plazaCollector.desocuparPlaza("1")).thenReturn(true);
    	
    	assertTrue(plazaCollector.desocuparPlaza("1"));
    }
}
