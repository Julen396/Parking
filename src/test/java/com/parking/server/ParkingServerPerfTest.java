package com.parking.server;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.parking.serialization.Coche;
import com.parking.serialization.Usuario;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;


//@Category(PerformanceTest.class)
@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class ParkingServerPerfTest {
    @Rule public ContiPerfRule rule = new ContiPerfRule();

    private static HttpServer server;
    private static WebTarget target;
    
    ParkingServer parkingServer;
	
	CocheCollector cocheCollector;
	PlazaCollector plazaCollector;
	UsuarioCollector usuarioCollector;
		
    @BeforeClass
    public static void setUp() {
        // start the server
        server = ServerManagerMain.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(ServerManagerMain.BASE_URI);
    }
    	
	@Before
	public void setUpPServer() {
		cocheCollector= org.mockito.Mockito.mock(CocheCollector.class);
		plazaCollector= org.mockito.Mockito.mock(PlazaCollector.class);
		usuarioCollector= org.mockito.Mockito.mock(UsuarioCollector.class);
		parkingServer=new ParkingServer(cocheCollector, plazaCollector, usuarioCollector);
	}
     
    
	@Test
    @PerfTest(invocations = 1000, threads = 20)
    @Required(max = 80, average = 8)
	public void testanadirCoche() {
		Usuario u1 = new Usuario();
		u1.setDni("1789562V");
		u1.setFecha_nac(LocalDate.of(2004, Month.APRIL, 22));
		u1.setNombre("Juan");
		Coche c1 = new Coche();
		c1.setMatricula("1111BBB");
		c1.setPropietario(u1);
		parkingServer.anadirCoche(c1);
	}
	
	@Test
	public void testGetCoches() {
		assertEquals(1, 1);
	}
	
	@Test
	public void testAnadirPlaza() {
		assertEquals(1, 1);
	}
	
	@Test
	public void testGetPlazas() {
		
		assertEquals(1, 1);
	}
	
	@Test
	public void testGetUsuarios() {

		assertEquals(1, 1);

	}
	
}
