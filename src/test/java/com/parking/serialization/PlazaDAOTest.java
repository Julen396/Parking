package com.parking.serialization;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlazaDAOTest {
	
	PlazaDAO plazaDAO;
	private LocalDate fecha;
	private Usuario usuario;
	private Coche coche;
	private Plaza plaza1;
    private ArrayList<Plaza> plazas;
    
	@Before
	public void setUp() {
		
		plazaDAO= org.mockito.Mockito.mock(PlazaDAO.class);

		fecha = LocalDate.of(2000, Month.MAY, 15);
    	usuario = new Usuario("123456789A", "Aitor", fecha );
    	coche = new Coche("1234ABC", usuario);
    	plaza1 = new Plaza(3, "C", 12, coche);
    	
		plazas = new ArrayList<>();
		plazas.add(plaza1);
	}
	
	@Test
	public void testsave() {
		when(plazaDAO.save(plaza1)).thenReturn(true);

		assertTrue(plazaDAO.save(plaza1));
	}

	@Test
	public void testdelete() {
		when(plazaDAO.delete(plaza1)).thenReturn(true);

		assertTrue(plazaDAO.delete(plaza1));
	}

	@Test
	public void testgetAll() {
		when(plazaDAO.getAll()).thenReturn(plazas);
		
		assertEquals(plazas, plazaDAO.getAll());
	}

	@Test
	public void testfind() {		
		when(plazaDAO.find("parametro")).thenReturn(plaza1);
		
		assertEquals(plaza1, plazaDAO.find("parametro"));
	}
}
