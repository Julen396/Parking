package com.parking.serialization;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.jdo.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PlazaDAOTest {

	PersistenceManager pm;
	Transaction tx;
	PlazaDAO plazaDAO;
	LocalDate fecha;
	Usuario usuario;
	Coche coche;
	Plaza plaza1;
    ArrayList<Plaza> plazas;
	ArrayList<Plaza> plazasVacio;

	@Before
	public void setUp() {

		plazaDAO = PlazaDAO.getInstance();
		tx = org.mockito.Mockito.mock(Transaction.class);
		pm = org.mockito.Mockito.mock(PersistenceManager.class);
		//pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		plazaDAO.setPM(pm);
		plazaDAO.setTransaction(tx);

		doNothing().when(tx).begin();
		doNothing().when(tx).commit();
		doNothing().when(pm).close();

		fecha = LocalDate.of(2000, Month.MAY, 15);
    	usuario = new Usuario("123456789A", "Aitor", fecha );
    	coche = new Coche("1234ABC", usuario);
    	plaza1 = new Plaza(3, "C", 12, coche);

		plazas = new ArrayList<>();
		plazasVacio = new ArrayList<>();
		plazas.add(plaza1);
	}

	@Test
	public void testSave() {
		when(pm.makePersistent(plaza1)).thenReturn(plaza1);
		when(tx.isActive()).thenReturn(true);
		assertTrue(plazaDAO.save(plaza1));
	}

	@Test
	public void testDelete() {
		assertTrue(plazaDAO.delete(plaza1));
	}

	@Test
	public void testGetAll() {
		assertEquals(plazasVacio, plazaDAO.getAll());
	}

	@Test
	@Ignore
	public void testFind() {		
		when(plazaDAO.find("parametro")).thenReturn(plaza1);
		
		assertEquals(plaza1, plazaDAO.find("parametro"));
	}
}
