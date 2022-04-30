package com.parking.serialization;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataAccessObjectBaseTest {
	
	DataAccessObjectBase dataAccessObjectBase;
	private Object object;
	
	@Before
	public void setUp() {
		dataAccessObjectBase = org.mockito.Mockito.mock(DataAccessObjectBase.class);
	}
	
	@Test
	public void testdeleteObject() {
		when(dataAccessObjectBase.deleteObject(object)).thenReturn(true);

		assertTrue(dataAccessObjectBase.deleteObject(object));
		
		when(dataAccessObjectBase.deleteObject(object)).thenReturn(false);
		
		assertFalse(dataAccessObjectBase.deleteObject(object));
	}
	public void testsaveObject() {
		when(dataAccessObjectBase.saveObject(object)).thenReturn(true);

		assertTrue(dataAccessObjectBase.saveObject(object));
		
		when(dataAccessObjectBase.saveObject(object)).thenReturn(false);

		assertFalse(dataAccessObjectBase.saveObject(object));
	}
}
