package jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aeropuerto
{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    long id_aeropuerto;
    public long getId_aeropuerto() {
		return id_aeropuerto;
	}

	public void setId_aeropuerto(long id_aeropuerto) {
		this.id_aeropuerto = id_aeropuerto;
	}

	String name = null;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Aeropuerto(String name)
    {
        this.name = name;
    }
}