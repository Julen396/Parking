package com.parking.serialization;

import java.util.ArrayList;

import java.util.List;

public class ListaCoche {
    private List<Coche> listCoches;

    public ListaCoche() {
        listCoches = new ArrayList<>();
    }

    public ListaCoche(List<Coche> Coches) {
        this.listCoches = Coches;
    }

    public List<Coche> getListCoches() {
    	return listCoches;	
    }
    
    public void setListCoches(List<Coche> list) {
    	this.listCoches = list;
    }


    @Override
    public String toString() {
        return "ListaCoches: " + listCoches.toString();
    }
}
