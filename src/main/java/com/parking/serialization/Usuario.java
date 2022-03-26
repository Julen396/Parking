package com.parking.serialization;

import java.util.Date;

public class Usuario {
	private String dni;
	private String nombre;
	private Date fecha_nac;
	
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
}
