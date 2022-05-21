package com.parking.serialization;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
/**
 * Clase plaza
 *
 */
@PersistenceCapable(detachable="true")
public class Plaza {
    private int piso;
    private String zona;
    private int posicion;
    @Persistent(defaultFetchGroup="true")
    private Coche coche;

	/**
	 * Construye una plaza
	 *
	 */
	public Plaza(int piso, String zona, int posicion, Coche coche) {
		this.piso = piso;
		this.zona = zona;
		this.posicion = posicion;
		this.coche = coche;
	}

	/**
	 * Construye una plaza vacia
	 *
	 */
	public Plaza() {
		this.piso = 0;
		this.zona = "A";
		this.posicion = 0;
		this.coche = null;
	}

    /**
     * Devuelve el piso de la plaza
     */
    public int getPiso() {
		return piso;
	}
	/**
	 * Establece el piso de la plaza
	 *
	 */
	public void setPiso(int piso) {
		this.piso = piso;
	}
	
	/**
	 * Devuelve la zona de la plaza
	 */
	public String getZona() {
		return zona;
	}
	/**
	 * Establece la zona de la plaza
	 *
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}
	
	/**
	 * Devuelve el numero de la posicion dentro del piso y la zona correspondientes de la plaza
	 */
	public int getPosicion() {
		return posicion;
	}
	/**
	 * Establece la posoicion de la plaza
	 *
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	/**
	 * Devuelve el coche estacionado dentro de la plaza
	 * @return NULL cuando no hay ningun coche estacionado en esa plaza
	 */
	public Coche getCoche() {
		return coche;
	}
	/**
	 * Establece el coche de una plaza, pasando a estar ocupada
	 *
	 */
	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	/**
	 * Libera una plaza
	 *
	 */
	public void desocupar() {
		this.coche = null;
	}
	/**
	 * Devuelve las propiedades de una plaza: piso, zona, posicion y coche
	 *
	 */
	@Override
	public String toString() {
		return "(Piso: " + this.piso + "; Zona: " + this.zona + "; Posicion: " + this.posicion + "; Coche: " + this.coche + ")";
	}
}

