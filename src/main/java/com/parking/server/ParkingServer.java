package com.parking.server;

import com.parking.serialization.Coche;
import com.parking.serialization.Plaza;
import com.parking.serialization.Usuario;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
	private UsuarioCollector usuarioCollector;
	public ParkingServer() {
		cocheCollector = new CocheCollector();
		plazaCollector = new PlazaCollector();
		usuarioCollector = new UsuarioCollector();
		
	}
	
	@POST
	@Path("/coches")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response anadirCoche(Coche coche) {
		System.out.println("Coche recibido");
		System.out.println("Nuevo coche" + coche);
		cocheCollector.addCoche(coche);
		return Response.ok(coche.getMatricula()).build();
	}

	@GET
	@Path("/coches")
	public Response getCoches() {return Response.ok(cocheCollector.getCoches()).build();}

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

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/usuarios")
	public Response getUsuarios() { return Response.ok(usuarioCollector.getUsuarios()).build(); }
	

}
