package com.parking.serialization;

import java.util.ArrayList;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable="true")
public class Parking {

	private int numPlazas;
	@Join
	@Persistent(dependentElement="true", defaultFetchGroup="true")
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
	
	public int getNumPlazasLibres() {
		int cont = 0;
		for(Plaza plaza: this.plazas) {
			if(plaza.getCoche() != null) {
				cont += 1;
			}
		}
		return cont;
	}

	@Override
	public String toString() {
		
		int cont = 0;
		for(Plaza plaza: this.plazas) {
			if(plaza.getCoche() != null) {
				cont += 1;
				System.out.println(plaza.getCoche().getMatricula());
			}
		
		}
		return "" + this.numPlazas;
	}
	
}
