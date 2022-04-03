package com.parking.server;

import com.parking.serialization.Coche;
import com.parking.serialization.Plaza;
import com.parking.serialization.Usuario;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.POST;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class ParkingServer{
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Funciona!";
    }
    
	private CocheCollector cocheCollector;
	private PlazaCollector plazaCollector;
	public ParkingServer() {
		cocheCollector = new CocheCollector();
		plazaCollector = new PlazaCollector();
		
		Plaza p1 = new Plaza();
		p1.setPiso(1);
		anadirPlaza(p1);
		
		/*Usuario u1 = new Usuario();
		u1.setDni("7777777K");
		Coche coche1 = new Coche();
		coche1.setMatricula("sds5645");
		coche1.setPropietario(u1);
		anadirCoche(coche1);
		Coche coche2 = new Coche();
		coche2.setMatricula("yhh8486");
		anadirCoche(coche2);*/
		
	}
	
	@POST
	@Path("/coches")
	public Response anadirCoche(Coche coche) {
		cocheCollector.addCoche(coche);
		System.out.println("Coche recibido");
		return Response.ok(coche.getMatricula()).build();
	}

	@GET
	@Path("/coches")
	public Response getCoches() {
		return Response.ok(cocheCollector.getCoches()).build();
	}
	
	@POST
	@Path("/plazas")
	public Response anadirPlaza(Plaza plaza) {
		plazaCollector.addPlaza(plaza);
		System.out.println("Plaza recibido");
		return Response.ok(plaza).build();
	}

	@GET
	@Path("/plazas")
	public Response getPlazas() {
		return Response.ok(plazaCollector.getPlazas()).build();
	}
	

}
