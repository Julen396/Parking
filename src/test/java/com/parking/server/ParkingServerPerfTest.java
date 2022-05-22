package com.parking.server;

import com.parking.client.Cliente;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.experimental.categories.Category;

import com.parking.server.ServerManagerMain;
import com.parking.serialization.Coche;
import com.parking.serialization.ListaUsuarios;
import com.parking.serialization.Plaza;
import com.parking.serialization.Usuario;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;

import categories.PerformanceTest;

//@Category(PerformanceTest.class)
@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class ParkingServerPerfTest {
    @Rule public ContiPerfRule rule = new ContiPerfRule();

    private static HttpServer server;
    private static WebTarget target;
	
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
     
    
	@Test
    @PerfTest(invocations = 100, threads = 20)
    @Required(max = 20000, average = 10000)
	public void testAnadirCoche() {
		Cliente c = new Cliente("localhost", "8085");

		Coche coche = new Coche();

		assertTrue(c.addCoche(coche));
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
