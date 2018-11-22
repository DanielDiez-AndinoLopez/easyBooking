package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

/**
 * 
 * @author DGP
 *
 */

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Usuario {

	String correo;
	String autorizacion;
	String nombre;
	String apellidos;
	String metodoPago;
	String aeropuertoPorDefecto;
	
	public Usuario(String nombre, String apellidos,String correo, String autorizacion, String metodoPago, String aeropuertoPorDefecto) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.autorizacion = autorizacion;
		this.metodoPago = metodoPago;
		this.aeropuertoPorDefecto = aeropuertoPorDefecto;
	}

	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getAeropuertoPorDefecto() {
		return aeropuertoPorDefecto;
	}

	public void setAeropuertoPorDefecto(String aeropuertoPorDefecto) {
		this.aeropuertoPorDefecto = aeropuertoPorDefecto;
	}

	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", autorizacion=" + autorizacion + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", metodoPago=" + metodoPago + ", aeropuertoPorDefecto=" + aeropuertoPorDefecto + "]";
	}	
}