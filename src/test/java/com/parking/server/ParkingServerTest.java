package com.parking.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.serialization.Coche;
import com.parking.serialization.CocheDAO;
import com.parking.serialization.ListaCoche;
import com.parking.serialization.ListaUsuarios;
import com.parking.serialization.Plaza;
import com.parking.serialization.PlazaDAO;
import com.parking.serialization.Usuario;
import com.parking.serialization.UsuarioDAO;

import jakarta.ws.rs.core.Response;

@RunWith(MockitoJUnitRunner.class)
public class ParkingServerTest {
	
	private Coche coche1;
	private Usuario usuario;
	private LocalDate fecha;
	private Plaza plaza1;
	private ArrayList<Coche> coches;
	private ListaUsuarios listaUsuarios;
	private ListaCoche listaCoche;
	
	ParkingServer parkingServer;
	ParkingServer parkingServerVacio;
	
	CocheCollector cocheCollector;
	PlazaCollector plazaCollector;
	UsuarioCollector usuarioCollector;
	

	PlazaDAO pldao;
	CocheDAO cdao;
	UsuarioDAO udao;
	
	@Before
	public void setUp() {
		coche1 = new Coche("1234ABC", usuario);
		fecha = LocalDate.of(2000, Month.MAY, 15);
		usuario = new Usuario("123456789A", "Aitor", fecha);
		plaza1 = new Plaza(3, "C", 12, coche1);
		cocheCollector= org.mockito.Mockito.mock(CocheCollector.class);
		plazaCollector= org.mockito.Mockito.mock(PlazaCollector.class);
		usuarioCollector= org.mockito.Mockito.mock(UsuarioCollector.class);
		parkingServer=new ParkingServer(cocheCollector, plazaCollector, usuarioCollector);
		parkingServerVacio=new ParkingServer();

	}
	
	@Test
	public void testAnadirCoche() {
		
		Response response = parkingServer.anadirCoche(coche1);
		
		assertEquals(coche1.getMatricula(), response.getEntity());
	}

	@Test
	public void testAnadirUsuario() {
		Response response = parkingServer.anadirUsuario(usuario);

		assertEquals(usuario.getDni(), response.getEntity());
	}
	
	@Test
	public void testGetCoches() {
	
		ArrayList<Coche> coches = new ArrayList<>();
		coches.add(coche1);	
		
		listaCoche = new ListaCoche(coches);
		
		when(cocheCollector.getCoches()).thenReturn(coches);

		Response response = parkingServer.getCoches();		
		ListaCoche lc = (ListaCoche) response.getEntity();
		int i = 0;
		for (Coche c : listaCoche.getListCoches()) {
			assertEquals(c, lc.getListCoches().get(i));
			i++;
		}
	}
	
	@Test
	public void testAnadirPlaza() {
		
		Response response = parkingServer.anadirPlaza(plaza1);
		
		assertEquals(plaza1, response.getEntity());
	}
	
	@Test
	public void testGetPlazas() {
		
		ArrayList<Plaza> plazas = new ArrayList<>();
		plazas.add(plaza1);	
		
		when(plazaCollector.getPlazas()).thenReturn(plazas);
		
		Response response = parkingServer.getPlazas();
		
		assertEquals(plazas, response.getEntity());
	}
	
	@Test
	public void testGetUsuarios() {

		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario);
		
		listaUsuarios = new ListaUsuarios(usuarios);
		
		when(usuarioCollector.getUsuarios()).thenReturn(usuarios);
		
		Response response = parkingServer.getUsuarios();
		ListaUsuarios lu = (ListaUsuarios) response.getEntity();
		int i = 0;
		for (Usuario u : listaUsuarios.getListUsuarios()) {
			assertEquals(u, lu.getListUsuarios().get(i));
			i++;
		}

	}
	
}
