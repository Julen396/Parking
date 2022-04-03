package com.parking.serialization;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;


@PersistenceCapable(detachable="true")
public class Usuario {
	private String dni;
	private String nombre;
	private Date fecha_nac;

	public Usuario(String dni, String nombre, Date fecha_nac) {
		this.dni = dni;
		this.nombre = nombre;
		this.fecha_nac = fecha_nac;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		if(dni.matches("\\d{7}[A-Z]")) {
			this.dni = dni;
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFecha_nac() {
		return fecha_nac;
	}
	
	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	
	@Override
	public String toString() {
		return "(DNI: " + this.dni + "; nombre: " + this.nombre + "; fecha de nacimiento: " + this.fecha_nac + ")";
	}
}
