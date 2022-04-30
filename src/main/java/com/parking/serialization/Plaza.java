package com.parking.serialization;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable="true")
public class Plaza {
    private int piso;
    private String zona;
    private int posicion;
    @Persistent(defaultFetchGroup="true")
    private Coche coche;

	// Constructor
	public Plaza(int piso, String zona, int posicion, Coche coche) {
		this.piso = piso;
		this.zona = zona;
		this.posicion = posicion;
		this.coche = coche;
	}

	// Constructor vacío
	public Plaza() {
		this.piso = 0;
		this.zona = "A";
		this.posicion = 0;
		this.coche = null;
	}

    /**
     * @return numero del piso
     */
    public int getPiso() {
		return piso;
	}
    
	public void setPiso(int piso) {
		this.piso = piso;
	}
	
	/**
	 * @return nombre de la zona (A, B, C, ...)
	 */
	public String getZona() {
		return zona;
	}
	
	public void setZona(String zona) {
		this.zona = zona;
	}
	
	/**
	 * @return numero de la posicion dentro del piso y la zona correspondientes
	 */
	public int getPosicion() {
		return posicion;
	}
	
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	/**
	 * @return coche estacionada dentro de la plaza
	 * @return NULL cuando no hay ningun coche estacionado en esa plaza
	 */
	public Coche getCoche() {
		return coche;
	}
	
	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	
	@Override
	public String toString() {
		return "(Piso: " + this.piso + "; Zona: " + this.zona + "; Posicion: " + this.posicion + "; Coche: " + this.coche + ")";
	}

	public void desocupar() {
		// TODO Hacer metodo desocupar
	}
}

