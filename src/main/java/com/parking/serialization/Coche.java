package com.parking.serialization;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable="true")
public class Coche {
	private String matricula;
	@Persistent(defaultFetchGroup="true")
	private Usuario propietario;

	public Coche(String matricula, Usuario propietario) {
		this.matricula = matricula;
		this.propietario = propietario;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public Usuario getPropietario() {
		return propietario;
	}
	
	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}
	
	@Override
	public String toString() {
		return "(Matricula: " + this.matricula + "; Propietario: " + this.propietario + ")";
	}
}
