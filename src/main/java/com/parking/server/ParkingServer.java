package com.parking.server;

import com.parking.serialization.Coche;
import com.parking.serialization.ListaUsuarios;
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
    
	private CocheCollector cocheCollector;
	private PlazaCollector plazaCollector;
	private UsuarioCollector usuarioCollector;
	public ParkingServer() {
		cocheCollector = new CocheCollector();
		plazaCollector = new PlazaCollector();
		usuarioCollector = new UsuarioCollector();
		
	}
	public ParkingServer(CocheCollector cocheCollectort, PlazaCollector plazaCollectort, UsuarioCollector usuarioCollectort) {
		cocheCollector= cocheCollectort;
		plazaCollector= plazaCollectort;
		usuarioCollector= usuarioCollectort;
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
	@Path("/usuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarios() {
		System.out.println("Petición para mandar usuarios recibida");
		ListaUsuarios usuarios = new ListaUsuarios(usuarioCollector.getUsuarios());
		return Response.ok(usuarios).build(); }
	

}
