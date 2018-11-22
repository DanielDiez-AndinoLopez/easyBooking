package org.datanucleus.samples.jdo.tutorial;

import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Vuelo {
	int numVuelo;
	Aeropuerto origen;
	Aeropuerto destino;
	Date fechaSalida;
	Date fechaLlegada;
	int totalAsientos;
	int asientosLibres;

	public Vuelo(int numVuelo, Aeropuerto origen, Aeropuerto destino, Date fechaSalida, Date fechaLlegada,
			int totalAsientos, int asientosLibres) {
		this.numVuelo = numVuelo;
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.totalAsientos = totalAsientos;
		this.asientosLibres = asientosLibres;
	}

	public int getNumVuelo() {
		return numVuelo;
	}

	public void setNumVuelo(int numVuelo) {
		this.numVuelo = numVuelo;
	}

	public Aeropuerto getOrigen() {
		return origen;
	}

	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}

	public Aeropuerto getDestino() {
		return destino;
	}

	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public int getToatalAsientos() {
		return totalAsientos;
	}

	public void setToatalAsientos(int toatalAsientos) {
		this.totalAsientos = toatalAsientos;
	}

	public int getAsientosLibres() {
		return asientosLibres;
	}

	public void setAsientosLibres(int asientosLibres) {
		this.asientosLibres = asientosLibres;
	}

}
