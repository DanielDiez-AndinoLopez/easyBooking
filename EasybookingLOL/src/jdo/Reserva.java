package jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva
{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    long id_reserva;
	String emailUsuario = null;
    double coste = 0.0;
	double comision = 0.0;
	long id_vuelo = 0;
	
	public Reserva(Usuario usu, double coste, double comision, Vuelo vuelo) {
		
		this.emailUsuario = usu.getEmail();
		this.coste = coste;
		this.comision = comision;
		this.id_vuelo = vuelo.getId_vuelo();
	}


}