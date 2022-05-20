package com.parking.serialization;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

/**
 * Clase coche.
 *
 */
@PersistenceCapable(detachable="true")
public class Coche {
	private String matricula;
	@Persistent(defaultFetchGroup="true")
	private Usuario propietario;
	/**
	 * Cosntruye un coche
	 *
	 */
	public Coche(String matricula, Usuario propietario) {
		this.matricula = matricula;
		this.propietario = propietario;
	}
	/**
	 * Construye un coche vacio
	 *
	 */
	public Coche() {
		this.matricula = "Default";
		this.propietario = null;
	}
	/**
	 * Devuelve la matricula de un coche
	 *
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * 	Establece la matricula de un coche
	 *
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	/**
	 * Devuelve el propietario de un cohe
	 *
	 */
	public Usuario getPropietario() {
		return propietario;
	}
	/**
	 * Establece el propietario de un coche
	 *
	 */
	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}
	/**
	 * Devuelve los atributos de un coche
	 *
	 */	
	@Override
	public String toString() {
		return "(Matricula: " + this.matricula + "; Propietario: " + this.propietario + ")";
	}
}
