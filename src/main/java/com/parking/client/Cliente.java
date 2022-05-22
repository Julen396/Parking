package com.parking.client;

import com.parking.serialization.Coche;
import com.parking.serialization.ListaCoche;
import com.parking.serialization.ListaUsuarios;
import com.parking.serialization.Usuario;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

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

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            System.out.println("No se pudieron obtener los coches");
            System.out.println("Path: " + webTarget.getUri() + " / Estado: " + response.getStatus());
        } else {
            System.out.println("Se han obtenido los coches");
        }
        return true;
    }

    public List<Usuario> getUsuarios() {
        WebTarget usuariosWebTarget = webTarget.path("/myresource/usuarios");
        Invocation.Builder invocationBuilder = usuariosWebTarget.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println("Se han obtenido los usuarios");
            ListaUsuarios usuarios = response.readEntity(ListaUsuarios.class);
            System.out.println(usuarios);
            return usuarios.getListUsuarios();
        } else {
            System.out.println("No se pudieron obtener los usuarios");
            ListaUsuarios usuarios = new ListaUsuarios();
            return usuarios.getListUsuarios();
        }

    }
    
    public List<Coche> getCoches() {
        WebTarget cochesWebTarget = webTarget.path("/myresource/coches");
        Invocation.Builder invocationBuilder = cochesWebTarget.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println("Se han obtenido los coches");
            ListaCoche coches = response.readEntity(ListaCoche.class);
            System.out.println(coches);
            return coches.getListCoches();
        } else {
            System.out.println("No se pudieron obtener los coches");
            ListaCoche coches = new ListaCoche();
            return coches.getListCoches();
        }

    }
}
