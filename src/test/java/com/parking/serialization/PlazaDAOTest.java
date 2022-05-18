package com.parking.serialization;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

@RunWith(MockitoJUnitRunner.class)
public class PlazaDAOTest {

	PersistenceManager pm;
	PersistenceManagerFactory pmf;
	PlazaDAO plazaDAO;
	private LocalDate fecha;
	private Usuario usuario;
	private Coche coche;
	private Plaza plaza1;
    private ArrayList<Plaza> plazas;
    
	@Before
	public void setUp() {

		plazaDAO = PlazaDAO.getInstance();
		pm = org.mockito.Mockito.mock(PersistenceManager.class);
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		when(pm.currentTransaction()).thenReturn(pmf.getPersistenceManager().currentTransaction());
		plazaDAO.setPM(pm);

		fecha = LocalDate.of(2000, Month.MAY, 15);
    	usuario = new Usuario("123456789A", "Aitor", fecha );
    	coche = new Coche("1234ABC", usuario);
    	plaza1 = new Plaza(3, "C", 12, coche);
    	
		plazas = new ArrayList<>();
		plazas.add(plaza1);
	}
	
	@Test
	public void testSave() {
		when(pm.makePersistent(plaza1)).thenReturn(plaza1);
		assertTrue(plazaDAO.save(plaza1));
	}

	@Test
	@Ignore
	public void testDelete() {
		when(plazaDAO.delete(plaza1)).thenReturn(true);

		assertTrue(plazaDAO.delete(plaza1));
	}

	@Test
	@Ignore
	public void testgetAll() {
		when(plazaDAO.getAll()).thenReturn(plazas);
		
		assertEquals(plazas, plazaDAO.getAll());
	}

	@Test
	@Ignore
	public void testfind() {		
		when(plazaDAO.find("parametro")).thenReturn(plaza1);
		
		assertEquals(plaza1, plazaDAO.find("parametro"));
	}
}
