package com.parking.serialization;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CocheDAOTest {

	PersistenceManager pm;
	Transaction tx;
	CocheDAO cocheDAO;
	
    private LocalDate d;
    private Coche c1;
    private Usuario u;
    
    private ArrayList<Coche> coches;
	private ArrayList<Coche> cochesVacio;
	
	@Before
	public void setUp() {
		
		cocheDAO= CocheDAO.getInstance();
		tx = org.mockito.Mockito.mock(Transaction.class);
		pm = org.mockito.Mockito.mock(PersistenceManager.class);
		//pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		cocheDAO.setPM(pm);
		cocheDAO.setTransaction(tx);

		doNothing().when(tx).begin();
		doNothing().when(tx).commit();
		doNothing().when(pm).close();

        d = LocalDate.of(1995, Month.APRIL,3);
        u = new Usuario("1234567A", "Koldo",d);
        c1 = new Coche("123123", u);
        
		coches = new ArrayList<>();
		cochesVacio = new ArrayList<>();
		coches.add(c1);
	}

	@Test
	public void testsave() {
		when(pm.makePersistent(c1)).thenReturn(c1);
		when(tx.isActive()).thenReturn(true);
		assertTrue(cocheDAO.save(c1));
	}
	
	@Test
	public void testdelete() {
		assertTrue(cocheDAO.delete(c1));		
	}
	
	@Test
	public void testgetAll() {
		assertEquals(cochesVacio, cocheDAO.getAll());
	}
	
	@Test
	@Ignore
	public void testfind() {
		when(cocheDAO.find("parametro")).thenReturn(c1);
		
		assertEquals(c1, cocheDAO.find("parametro"));
	}
}
