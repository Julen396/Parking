package com.parking.server;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.parking.serialization.Coche;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class ParkingServer{

	private CocheCollector cocheCollector;

	public ParkingServer() {
		cocheCollector = new CocheCollector();
	}
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	@POST
	@Path("/coches")
	public Response addDonation(Coche coche) {
		ArrayList<Coche> total = cocheCollector.addCoche(coche);
		System.out.println("Received donation: " + coche + ". Total donations: " + total);
		return Response.ok().build();
	}
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
}
