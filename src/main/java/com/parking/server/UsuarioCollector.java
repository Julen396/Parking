package com.parking.server;

import com.parking.serialization.CocheDAO;
import com.parking.serialization.UsuarioDAO;
import com.parking.serialization.Usuario;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import java.util.ArrayList;

public class UsuarioCollector {

    public ArrayList<Usuario> getUsuarios() {
        // PM
        UsuarioDAO dao = UsuarioDAO.getInstance();
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        PersistenceManager pm = pmf.getPersistenceManager();
        dao.setPM(pm);
        dao.setTransaction(pm.currentTransaction());

        return (ArrayList<Usuario>) dao.getAll();
    }
}
