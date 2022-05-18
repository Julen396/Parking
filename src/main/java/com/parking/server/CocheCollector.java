package com.parking.server;

import java.util.ArrayList;

import com.parking.serialization.Coche;
import com.parking.serialization.CocheDAO;

public class CocheCollector {
    
    public ArrayList<Coche> addCoche(Coche coche, CocheDAO cdao) {
        synchronized(this) {
        	cdao.save(coche);
            return (ArrayList<Coche>) cdao.getAll();
        }
    }

    public ArrayList<Coche> getCoches(CocheDAO cdao) {
    	return (ArrayList<Coche>) cdao.getAll();
    }
    
    public ArrayList<String> getListaMatriculas(CocheDAO cdao){
    	ArrayList<Coche> listaC = getCoches(cdao);
    	ArrayList<String> listaMat = new ArrayList<String>();
    	for(Coche coche: listaC) {
    		listaMat.add(coche.getMatricula());
    	}
    	return listaMat;
    }
    
    public Coche getCocheporMatricula (String matricula, CocheDAO cdao) {
    	return cdao.find(matricula);
    }
}