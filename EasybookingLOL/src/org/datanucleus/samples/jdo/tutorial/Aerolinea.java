package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Aerolinea {

	String nombreAerolinea;

	public Aerolinea(String nombreAerolinea) {
		this.nombreAerolinea = nombreAerolinea;
	}

	public String getNombreAerolinea() {
		return nombreAerolinea;
	}

	public void setNombreAerolinea(String nombreAerolinea) {
		this.nombreAerolinea = nombreAerolinea;
	}

}
