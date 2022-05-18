package com.parking.server;

import com.parking.serialization.UsuarioDAO;
import com.parking.serialization.Usuario;

import java.util.ArrayList;

public class UsuarioCollector {

    public ArrayList<Usuario> getUsuarios(UsuarioDAO udao) {
        return (ArrayList<Usuario>) udao.getAll();
    }
}
