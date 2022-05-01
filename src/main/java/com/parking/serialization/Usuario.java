package com.parking.serialization;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;


@PersistenceCapable(detachable="true")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	private String dni;
	private String nombre;
	private LocalDate fecha_nac;

	public Usuario(String dni, String nombre, LocalDate fecha_nac) {
		this.dni = dni;
		this.nombre = nombre;
		this.fecha_nac = fecha_nac;
	}

	public Usuario() {
		this.dni = "11111111A";
		this.nombre = "Deault";
		this.fecha_nac = null;
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
	
	public LocalDate getFecha_nac() {
		return fecha_nac;
	}
	
	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	
	@Override
	public String toString() {
		return "(DNI: " + this.dni + "; nombre: " + this.nombre + "; fecha de nacimiento: " + this.fecha_nac + ")";
	}
}
