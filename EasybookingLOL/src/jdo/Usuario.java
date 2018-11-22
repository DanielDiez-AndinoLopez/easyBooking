package jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario
{
	@PrimaryKey
	String email = null;
    String name = null;
    String sisauth = null;
    String paymethod = null;
    long aer = 0;


	public Usuario(String email, String name, String sisauth, String paymethod, Aeropuerto aer) {
	
		this.email = email;
		this.name = name;
		this.sisauth = sisauth;
		this.paymethod = paymethod;
		this.aer = aer.getId_aeropuerto();
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSisauth() {
		return sisauth;
	}


	public void setSisauth(String sisauth) {
		this.sisauth = sisauth;
	}


	public String getPaymethod() {
		return paymethod;
	}


	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}


	public Usuario() {
		// TODO Auto-generated constructor stub
	}
}