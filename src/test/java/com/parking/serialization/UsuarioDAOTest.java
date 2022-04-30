package com.parking.serialization;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioDAOTest {
	UsuarioDAO usuarioDAO;
	private Date fecha;
	private Usuario usuario;
	private ArrayList<Usuario> usuarios;
	
	@Before
	public void setUp() {
		
		usuarioDAO= org.mockito.Mockito.mock(UsuarioDAO.class);
    	fecha = new Date(2000, 5, 15);
    	usuario = new Usuario("123456789A", "Aitor", fecha );
    	
		usuarios = new ArrayList<>();
		usuarios.add(usuario);
		
	}
	
	@Test
	public void testsave() {
		when(usuarioDAO.save(usuario)).thenReturn(true);

		assertTrue(usuarioDAO.save(usuario));
	}

	@Test
	public void testdelete() {
		when(usuarioDAO.delete(usuario)).thenReturn(true);

		assertTrue(usuarioDAO.delete(usuario));
	}

	@Test
	public void testgetAll() {
		when(usuarioDAO.getAll()).thenReturn(usuarios);
		
		assertEquals(usuarios, usuarioDAO.getAll());
	}

	@Test
	public void testfind() {
		when(usuarioDAO.find("parametro")).thenReturn(usuario);
		
		assertEquals(usuario, usuarioDAO.find("parametro"));
	}

}
