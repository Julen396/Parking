package com.parking.server;

import java.util.ArrayList;

import com.parking.serialization.Coche;
import com.parking.serialization.Plaza;
import com.parking.serialization.PlazaDAO;

public class PlazaCollector {
	public ArrayList<Plaza> addPlaza(Plaza plaza, PlazaDAO pldao) {
        synchronized(this) {
        	pldao.save(plaza);
            return (ArrayList<Plaza>) pldao.getAll();
        }
    }

    public ArrayList<Plaza> getPlazas(PlazaDAO pldao) {
        return (ArrayList<Plaza>) pldao.getAll();
    }
    
    public boolean ocuparPlaza(String id, Coche coche, PlazaDAO pldao) {
    	Plaza p = pldao.find(id);
    	p.setCoche(coche);
    	pldao.save(p);
    	return true;
    }
    
    public boolean desocuparPlaza(String id, PlazaDAO pldao) {
    	Plaza p = pldao.find(id);
    	p.desocupar();
    	pldao.save(p);
    	return true;
    }
}
