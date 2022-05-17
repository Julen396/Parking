package com.parking.serialization;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingDAOTest {
    
	ParkingDAO parkingDAO;
	private Parking parking;
	private ArrayList<Parking> parkings;
	
	@Before
    public void setUp() {
        
		parkingDAO= org.mockito.Mockito.mock(ParkingDAO.class);
		parking = new Parking(2);
		
		parkings = new ArrayList<>();
		parkings.add(parking);
    }
	
	@Test
	@Ignore
	public void testsave() {
		when(parkingDAO.save(parking)).thenReturn(true);

		assertTrue(parkingDAO.save(parking));
	}
	
	@Test
	@Ignore
	public void testdelete() {
		when(parkingDAO.delete(parking)).thenReturn(true);

		assertTrue(parkingDAO.delete(parking));
	}
	
	@Test
	@Ignore
	public void testgetAll() {
		when(parkingDAO.getAll()).thenReturn(parkings);
		
		assertEquals(parkings, parkingDAO.getAll());
	}
	
	@Test
	@Ignore
	public void testfind() {	
		when(parkingDAO.find("parametro")).thenReturn(parking);
		
		assertEquals(parking, parkingDAO.find("parametro"));
	}
}
