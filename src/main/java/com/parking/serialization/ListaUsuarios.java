package com.parking.serialization;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase Lista Usuarios
 *
 */
public class ListaUsuarios {
    private List<Usuario> listUsuarios;
    /**
     * Construye una lista de usuarios vacia
     *
     */
    public ListaUsuarios() {
        listUsuarios = new ArrayList<>();
    }
    /**
     * Construye una lista de usuarios
     *
     */
    public ListaUsuarios(List<Usuario> usuarios) {
        this.listUsuarios = usuarios;
    }
    /**
     * Devuelve la lista de usuarios
     *
     */
    public List<Usuario> getListUsuarios() {return listUsuarios;}
    /**
     * Establece la lista de usuarios
     *
     */
    public void setListUsuarios(List<Usuario> list) {this.listUsuarios = list; }

    /**
     * Imprime los usuarios y devuelve la lista de usuarios
     *
     */
    @Override
    public String toString() {
    	for (Usuario usuario : listUsuarios) {
			System.out.println(usuario.getNombre());
		}
        return "ListaUsuarios: " + listUsuarios.toString();
    }
}
