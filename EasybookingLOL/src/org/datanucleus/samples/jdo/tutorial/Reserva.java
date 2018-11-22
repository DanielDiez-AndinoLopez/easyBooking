package org.datanucleus.samples.jdo.tutorial;

import java.util.Arrays;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Reserva {
	String codigoReserva;
	int numPasajeros;
	String[] nombrePasajeros;
	float coste;
	float comision;
	Vuelo vuelo;

	public Reserva(String codigoReserva, int numPasajeros, String[] nombrePasajeros, float coste, float comision,
			Vuelo vuelo) {
		this.codigoReserva = codigoReserva;
		this.numPasajeros = numPasajeros;
		this.nombrePasajeros = nombrePasajeros;
		this.coste = coste;
		this.comision = comision;
		this.vuelo = vuelo;
	}

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public int getNumPasajeros() {
		return numPasajeros;
	}

	public void setNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
	}

	public String[] getNombrePasajeros() {
		return nombrePasajeros;
	}

	public void setNombrePasajeros(String[] nombrePasajeros) {
		this.nombrePasajeros = nombrePasajeros;
	}

	public float getCoste() {
		return coste;
	}

	public void setCoste(float coste) {
		this.coste = coste;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

}