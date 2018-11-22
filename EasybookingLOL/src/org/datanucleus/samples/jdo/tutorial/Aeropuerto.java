package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Aeropuerto {
	String idAeropuerto;
	String nombreAeropuerto;

	public String getIdAeropuerto() {
		return idAeropuerto;
	}

	public void setIdAeropuerto(String idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}

	public String getNombreAeropuerto() {
		return nombreAeropuerto;
	}

	public void setNombreAeropuerto(String nombreAeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
	}

	public Aeropuerto(String idAeropuerto, String nombreAeropuerto) {
		this.idAeropuerto = idAeropuerto;
		this.nombreAeropuerto = nombreAeropuerto;
	}
	
}
