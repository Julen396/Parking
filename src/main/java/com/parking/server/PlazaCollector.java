package com.parking.server;

import java.util.ArrayList;

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
}
