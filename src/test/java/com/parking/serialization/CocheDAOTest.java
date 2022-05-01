package com.parking.serialization;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.server.CocheCollector;

@RunWith(MockitoJUnitRunner.class)
public class CocheDAOTest {
	
	CocheDAO cocheDAO;
	
    private LocalDate d;
    private Coche c1;
    private Usuario u;
    
    private ArrayList<Coche> coches;
	
	@Before
	public void setUp() {
		
		cocheDAO= org.mockito.Mockito.mock(CocheDAO.class);
        d = LocalDate.of(1995, Month.APRIL,3);
        u = new Usuario("1234567A", "Koldo",d);
        c1 = new Coche("123123", u);
        
		coches = new ArrayList<>();
		coches.add(c1);
	}

	@Test
	public void testsave() {
		when(cocheDAO.save(c1)).thenReturn(true);

		assertTrue(cocheDAO.save(c1));
		
	}
	
	@Test
	public void testdelete() {
		when(cocheDAO.delete(c1)).thenReturn(true);

		assertTrue(cocheDAO.delete(c1));		
	}
	
	@Test
	public void testgetAll() {
		when(cocheDAO.getAll()).thenReturn(coches);
		
		assertEquals(coches, cocheDAO.getAll());
	}
	
	@Test
	public void testfind() {
		when(cocheDAO.find("parametro")).thenReturn(c1);
		
		assertEquals(c1, cocheDAO.find("parametro"));
	}
}
