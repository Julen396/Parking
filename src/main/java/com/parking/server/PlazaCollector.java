package com.parking.server;

import java.util.ArrayList;

import com.parking.serialization.Coche;
import com.parking.serialization.Plaza;
import com.parking.serialization.PlazaDAO;

public class PlazaCollector {
	public ArrayList<Plaza> addPlaza(Plaza plaza) {
        synchronized(this) {
        	PlazaDAO.getInstance().save(plaza);
            return (ArrayList<Plaza>) PlazaDAO.getInstance().getAll();
        }
    }

    public ArrayList<Plaza> getPlazas() {
        return (ArrayList<Plaza>) PlazaDAO.getInstance().getAll();
    }
    
    public void ocuparPlaza(String id, Coche coche) {
    	Plaza p = PlazaDAO.getInstance().find(id);
    	p.setCoche(coche);
    	PlazaDAO.getInstance().save(p);
    }
    
    public void desocuparPlaza(String id) {
    	Plaza p = PlazaDAO.getInstance().find(id);
    	p.desocupar();
    	PlazaDAO.getInstance().save(p);
    }
}
