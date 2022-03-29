package com.parking.server;

import java.util.ArrayList;

import com.parking.serialization.Coche;

public class CocheCollector {
    ArrayList<Coche> coches = new ArrayList<Coche>();
    
    public ArrayList<Coche> addCoche(Coche coche) {
        synchronized(this) {
        	coches.add(coche);
            return coches;
        }
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }
}
