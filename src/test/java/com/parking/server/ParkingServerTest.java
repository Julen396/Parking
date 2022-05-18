package com.parking.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.serialization.Coche;
import com.parking.serialization.ListaUsuarios;
import com.parking.serialization.Plaza;
import com.parking.serialization.Usuario;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import junit.framework.JUnit4TestAdapter;

@RunWith(MockitoJUnitRunner.class)
@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class ParkingServerTest {
	
	private Coche coche1;
	private Usuario usuario;
	private LocalDate fecha;
	private Plaza plaza1;
	private ArrayList<Coche> coches;
	private ListaUsuarios listaUsuarios;
	
	ParkingServer parkingServer;
	ParkingServer parkingServerVacio;
	
	CocheCollector cocheCollector;
	PlazaCollector plazaCollector;
	UsuarioCollector usuarioCollector;
	
	// If you use the EmptyReportModule, the report is not generated
	//@Rule public ContiPerfRule rule = new ContiPerfRule(new EmptyReportModule());
	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(ParkingServerTest.class);
	}

	
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
    @PerfTest(invocations = 1000, threads = 20)
    @Required(max = 80, average = 60)
	public void testanadirCoche() {
		
		Response response = parkingServer.anadirCoche(coche1);
		
		assertEquals(coche1.getMatricula(), response.getEntity());
	}
	
	@Test
	public void testgetCoches() {
	
		ArrayList<Coche> coches = new ArrayList<>();
		coches.add(coche1);	
		
		when(cocheCollector.getCoches()).thenReturn(coches);
		
		Response response = parkingServer.getCoches();
		
		assertEquals(coches, response.getEntity());
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
