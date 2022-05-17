package com.parking.serialization;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioDAOTest {
	UsuarioDAO usuarioDAO;
	private LocalDate fecha;
	private Usuario usuario;
	private ArrayList<Usuario> usuarios;
	
	@Before
	public void setUp() {
		
		usuarioDAO= org.mockito.Mockito.mock(UsuarioDAO.class);
		fecha = LocalDate.of(2000, Month.MAY, 15);
    	usuario = new Usuario("123456789A", "Aitor", fecha );
    	
		usuarios = new ArrayList<>();
		usuarios.add(usuario);
		
	}
	
	@Test
	@Ignore
	public void testsave() {
		when(usuarioDAO.save(usuario)).thenReturn(true);

		assertTrue(usuarioDAO.save(usuario));
	}

	@Test
	@Ignore
	public void testdelete() {
		when(usuarioDAO.delete(usuario)).thenReturn(true);

		assertTrue(usuarioDAO.delete(usuario));
	}

	@Test
	@Ignore
	public void testgetAll() {
		when(usuarioDAO.getAll()).thenReturn(usuarios);
		
		assertEquals(usuarios, usuarioDAO.getAll());
	}

	@Test
	@Ignore
	public void testfind() {
		when(usuarioDAO.find("parametro")).thenReturn(usuario);
		
		assertEquals(usuario, usuarioDAO.find("parametro"));
	}

}
