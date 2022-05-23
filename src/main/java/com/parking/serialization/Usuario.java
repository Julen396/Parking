package com.parking.serialization;

import java.io.Serializable;
import java.time.LocalDate;

import javax.jdo.annotations.PersistenceCapable;

/**
 * Clase usuario
 *
 */
@PersistenceCapable(detachable="true")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	private String dni;
	private String nombre;
	private LocalDate fecha_nac;
	/**
	 * Construye un usuario
	 *
	 */
	public Usuario(String dni, String nombre, LocalDate fecha_nac) {
		this.dni = dni;
		this.nombre = nombre;
		this.fecha_nac = fecha_nac;
	}
	/**
	 * Cosntruye un usuario vacio
	 *
	 */
	public Usuario() {
		this.dni = "11111111A";
		this.nombre = "Deault";
		this.fecha_nac = null;
	}
	/**
	 * Devuelve el DNI de un usuario
	 *
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Establece el DNI de un usuario
	 *
	 */
	public void setDni(String dni) {
		if(dni.matches("\\d{7}[A-Z]")) {
			this.dni = dni;
		}
	}
	/**
	 * Devuelve el nombre de un usuario
	 *
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Establece el nombre de un usuario
	 *
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve la fecha de nacimineto de un usuario
	 *
	 */
	public LocalDate getFecha_nac() {
		return fecha_nac;
	}
	/**
	 * Establece la fecha de nacimiento de un usuario
	 *
	 */
	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	/**
	 * Devuelve los atributos de un usuario: DNI, nombre y fecha de nacimiento
	 *
	 */
	@Override
	public String toString() {
		return "(DNI: " + this.dni + "; nombre: " + this.nombre + "; fecha de nacimiento: " + this.fecha_nac + ")";
	}
}
