package com.parking.server;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.serialization.Coche;
import com.parking.serialization.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class CocheCollectorTest {

	private Coche coche1;
	private Usuario usuario;
	private Date fecha;
	private ArrayList<Coche> coches;
	CocheCollector cocheCollector;
	
	@Before
	public void setUp() {
		fecha = new Date(2000, 5, 15);
		
		usuario = new Usuario("123456789A", "Aitor", fecha);
		
		coche1 = new Coche("1234ABC", usuario);
		
		coches = new ArrayList<>();
		coches.add(coche1);
		
		cocheCollector= org.mockito.Mockito.mock(CocheCollector.class);
	}

	@Test
	public void testaddCoche() {

		when(cocheCollector.addCoche(coche1)).thenReturn(coches);

		assertEquals(coches, cocheCollector.addCoche(coche1));
	}
	
	@Test 
	public void testgetCoches() {

		when(cocheCollector.getCoches()).thenReturn(coches);
		
		assertEquals(coches, cocheCollector.getCoches());
		
	}
	
	@Test 
	public void testgetListaMatriculas(){
		
		ArrayList<String> listaMatriculas= new ArrayList<>();
		listaMatriculas.add(coche1.getMatricula());
		
		when(cocheCollector.getListaMatriculas()).thenReturn(listaMatriculas);
		
		assertEquals(listaMatriculas, cocheCollector.getListaMatriculas());
	}
	
	
	@Test 
	public void testgetCocheporMatricula () {
		
		when(cocheCollector.getCocheporMatricula(coche1.getMatricula())).thenReturn(coche1);
		
		assertEquals(coche1, cocheCollector.getCocheporMatricula(coche1.getMatricula()));
	}
	
}
