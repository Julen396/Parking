package com.parking.server;

import java.util.ArrayList;

import com.parking.serialization.Coche;
import com.parking.serialization.CocheDAO;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class CocheCollector {
    
    public ArrayList<Coche> addCoche(Coche coche) {
        synchronized(this) {
            // PM
            CocheDAO dao = CocheDAO.getInstance();
            PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager pm = pmf.getPersistenceManager();
            dao.setPM(pm);
            dao.setTransaction(pm.currentTransaction());
            // Save
            dao.save(coche);
            // PM
            pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            pm = pmf.getPersistenceManager();
            dao.setPM(pm);
            dao.setTransaction(pm.currentTransaction());
            return (ArrayList<Coche>) dao.getAll();
        }
    }

    public ArrayList<Coche> getCoches() {
        // PM
        CocheDAO dao = CocheDAO.getInstance();
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        PersistenceManager pm = pmf.getPersistenceManager();
        dao.setPM(pm);
        dao.setTransaction(pm.currentTransaction());

        return (ArrayList<Coche>) dao.getAll();
    }
    
    public ArrayList<String> getListaMatriculas(){
    	ArrayList<Coche> listaC = getCoches();
    	ArrayList<String> listaMat = new ArrayList<String>();
    	for(Coche coche: listaC) {
    		listaMat.add(coche.getMatricula());
    	}
    	return listaMat;
    }
    
    public Coche getCocheporMatricula (String matricula) {
    	return CocheDAO.getInstance().find(matricula);
    }
}