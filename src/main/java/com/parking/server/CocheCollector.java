package com.parking.server;

import java.util.ArrayList;

import com.parking.serialization.Coche;
import com.parking.serialization.CocheDAO;


public class CocheCollector {
    
    public ArrayList<Coche> addCoche(Coche coche) {
        synchronized(this) {
        	CocheDAO.getInstance().save(coche);
            return (ArrayList<Coche>) CocheDAO.getInstance().getAll();
        }
    }

    public ArrayList<Coche> getCoches() {
    	return (ArrayList<Coche>) CocheDAO.getInstance().getAll();
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