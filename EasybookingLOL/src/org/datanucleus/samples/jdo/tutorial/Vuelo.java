package org.datanucleus.samples.jdo.tutorial;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vuelo
{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    long id_vuelo;
	long id_origen = 0;
	long id_destino = 0;
	long id_aer = 0;
    Date salida = null;
    Date llegada = null;
    int totasientos = 0;	
	
	public long getId_vuelo() {
		return id_vuelo;
	}

	public void setId_vuelo(long id_vuelo) {
		this.id_vuelo = id_vuelo;
	}

	public Date getSalida() {
		return salida;
	}

	public void setSalida(Date salida) {
		this.salida = salida;
	}

	public Date getLlegada() {
		return llegada;
	}

	public void setLlegada(Date llegada) {
		this.llegada = llegada;
	}

	public int getTotasientos() {
		return totasientos;
	}

	public void setTotasientos(int totasientos) {
		this.totasientos = totasientos;
	}
	
    public Vuelo(Aeropuerto origen, Aeropuerto destino, Aerolinea idaer, Date salida, Date llegada, int totasientos) {

		this.id_origen = origen.getId_aeropuerto();
		this.id_destino = destino.getId_aeropuerto();
		this.id_aer = idaer.getId_aerolinea();
		this.llegada = llegada;
		this.totasientos = totasientos;
		
	}


}