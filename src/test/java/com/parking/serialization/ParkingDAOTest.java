package com.parking.serialization;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

@RunWith(MockitoJUnitRunner.class)
public class ParkingDAOTest {
	PersistenceManager pm;
	Transaction tx;
	ParkingDAO parkingDAO;
	private Parking parking;
	private ArrayList<Parking> parkings;
	private ArrayList<Parking> parkingsVacio;
	
	@Before
    public void setUp() {
        
		parkingDAO = ParkingDAO.getInstance();
		tx = org.mockito.Mockito.mock(Transaction.class);
		pm = org.mockito.Mockito.mock(PersistenceManager.class);

		parkingDAO.setPM(pm);
		parkingDAO.setTransaction(tx);

		doNothing().when(tx).begin();
		doNothing().when(tx).commit();
		doNothing().when(pm).close();

		parking = new Parking(2);
		
		parkings = new ArrayList<>();
		parkingsVacio = new ArrayList<>();
		parkings.add(parking);
    }
	
	@Test
	public void testSave() {
		when(pm.makePersistent(parking)).thenReturn(parking);
		when(tx.isActive()).thenReturn(true);
		assertTrue(parkingDAO.save(parking));
	}
	
	@Test
	public void testDelete() {
		assertTrue(parkingDAO.delete(parking));
	}
	
	@Test
	public void testGetAll() {
		assertEquals(parkingsVacio, parkingDAO.getAll());
	}
	
	@Test
	@Ignore
	public void testFind() {	
		when(parkingDAO.find("parametro")).thenReturn(parking);
		
		assertEquals(parking, parkingDAO.find("parametro"));
	}
}
