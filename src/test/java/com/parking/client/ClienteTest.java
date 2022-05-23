package com.parking.client;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.serialization.Coche;
import com.parking.serialization.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class ClienteTest {
	Cliente cliente;
    private LocalDate d;
    private Coche c1;
    private Usuario u;
	
	@Before
	public void setUp() {
		cliente= org.mockito.Mockito.mock(Cliente.class);
		d = LocalDate.of(1995, Month.APRIL,3);
        u = new Usuario("1234567A", "Koldo",d);
        c1 = new Coche("123123", u);
	}

	@Test
	public void testAddCoche() {
		when(cliente.addCoche(c1)).thenReturn(true);
		
		assertTrue(cliente.addCoche(c1));
	}
	
	
}
