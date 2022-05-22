package com.parking.serialization;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioDAOTest {
	PersistenceManager pm;
	Transaction tx;
	UsuarioDAO usuarioDAO;
	private LocalDate fecha;
	private Usuario usuario;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Usuario> usuariosVacio;
	
	@Before
	public void setUp() {
		
		usuarioDAO= UsuarioDAO.getInstance();
		tx = org.mockito.Mockito.mock(Transaction.class);
		pm = org.mockito.Mockito.mock(PersistenceManager.class);

		usuarioDAO.setPM(pm);
		usuarioDAO.setTransaction(tx);

		doNothing().when(tx).begin();
		doNothing().when(tx).commit();
		doNothing().when(pm).close();

		fecha = LocalDate.of(2000, Month.MAY, 15);
    	usuario = new Usuario("123456789A", "Aitor", fecha );
    	
		usuarios = new ArrayList<>();
		usuariosVacio = new ArrayList<>();
		usuarios.add(usuario);
		
	}
	
	@Test
	public void testsave() {
		when(pm.makePersistent(usuario)).thenReturn(usuario);
		when(tx.isActive()).thenReturn(true);
		assertTrue(usuarioDAO.save(usuario));
	}

	@Test
	public void testdelete() {
		assertTrue(usuarioDAO.delete(usuario));
	}

	@Test
	public void testgetAll() {
		assertEquals(usuariosVacio, usuarioDAO.getAll());
	}

	@Test
	@Ignore
	public void testfind() {
		when(usuarioDAO.find("parametro")).thenReturn(usuario);
		
		assertEquals(usuario, usuarioDAO.find("parametro"));
	}

}
