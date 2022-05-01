package com.parking.serialization;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuarios {
    private List<Usuario> listUsuarios;

    public ListaUsuarios() {
        listUsuarios = new ArrayList<>();
    }

    public ListaUsuarios(List<Usuario> usuarios) {
        this.listUsuarios = usuarios;
    }

    public List<Usuario> getListUsuarios() {return listUsuarios;}
    public void setListUsuarios(List<Usuario> list) {this.listUsuarios = list; }


    @Override
    public String toString() {
        return "ListaUsuarios: " + listUsuarios;
    }
}
