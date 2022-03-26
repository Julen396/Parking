package com.parking.serialization;

public class Coche {
	private String matricula;
	private Usuario propietario;
	
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
}
