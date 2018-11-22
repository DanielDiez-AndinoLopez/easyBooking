package jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aerolinea
{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    long id_aerolinea;
    String name = null;

    public Aerolinea(String name)
    {
        this.name = name;
    }

	public long getId_aerolinea() {
		return id_aerolinea;
	}

	public void setId_aerolinea(long id_aerolinea) {
		this.id_aerolinea = id_aerolinea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Aerolinea [id_aerolinea=" + id_aerolinea + ", name=" + name + "]";
	}
	
}