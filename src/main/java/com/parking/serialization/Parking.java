package com.parking.serialization;

import java.util.ArrayList;
import java.util.Iterator;

public class Parking {

	private int numPlazas;
	private ArrayList<Plaza> plazas;
	
	public Parking(int numPlazas) {
		super();
		this.numPlazas = numPlazas;
		this.plazas = new ArrayList<Plaza>();
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public ArrayList<Plaza> getPlazas() {
		return plazas;
	}

	public void setPlazas(ArrayList<Plaza> plazas) {
		this.plazas = plazas;
	}

	@Override
	public String toString() {
	for (int i = 0; i < numPlazas; i++) {
			System.out.println(plazas.get(i).getCoche().getMatricula());
			
		}
	return "" + numPlazas;
	}
	
	
	
}
