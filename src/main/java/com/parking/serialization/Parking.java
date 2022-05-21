package com.parking.serialization;

import java.util.ArrayList;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
/**
 * Clase parking
 *
 */
@PersistenceCapable(detachable="true")
public class Parking {

	private int numPlazas;
	@Join
	@Persistent(dependentElement="true", defaultFetchGroup="true")
	private ArrayList<Plaza> plazas;
	/**
	 * Construye un parking
	 *
	 */
	public Parking(int numPlazas) {
		super();
		this.numPlazas = numPlazas;
		this.plazas = new ArrayList<Plaza>();
	}
	/**
	 * Devuelve el numero de plazas del parking
	 *
	 */
	public int getNumPlazas() {
		return numPlazas;
	}
	/**
	 * Establece el numero de plazas del parking
	 *
	 */
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
	/**
	 * Devuelve el numero de plazas del parking
	 *
	 */
	public ArrayList<Plaza> getPlazas() {
		return plazas;
	}
	/**
	 * Establece las plazas del parking
	 *
	 */
	public void setPlazas(ArrayList<Plaza> plazas) {
		this.plazas = plazas;
	}
	/**
	 * Devuelve el numero de plazas libres del parking
	 *
	 */	
	public int getNumPlazasLibres() {
		int cont = 0;
		for(Plaza plaza: this.plazas) {
			if(plaza.getCoche() != null) {
				cont += 1;
			}
		}
		return cont;
	}
	/**
	 * Imprime la lista de las matriculas de los coches del parking y devuelve el numero de plazas libres
	 *
	 */
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
