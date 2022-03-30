package com.parking.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/collector")
@Produces(MediaType.APPLICATION_JSON)

public class ParkingServer {
	
	@GET
	@Path("/hello")
	public Response sayHello() {
		
		return Response.ok("Hello").build();
	}
}
