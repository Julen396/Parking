package com.parking.client;

import com.parking.serialization.Coche;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class Cliente {
    Client client;
    WebTarget webTarget;

    public Cliente(String hostname, String port) {
        this.client = ClientBuilder.newClient();
        this.webTarget = client.target(String.format("http://%s:%s/parking", hostname, port));
    }

    public boolean addCoche(Coche coche) {

        WebTarget cochesWebTarget = webTarget.path("/myresource/coches");
        Invocation.Builder invocationBuilder = cochesWebTarget.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.post(Entity.entity(coche, MediaType.APPLICATION_JSON));
        System.out.println("Respuesta: " + response.getStatus());
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            System.out.println("Path: " + webTarget.getUri() + " / Estado: " + response.getStatus());
        }
        return true;
    }
}
