package jdo;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class Main {

	public static void main(String[] args) {
		try {
			PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();				
			
			Aerolinea aerolineaIberia = new Aerolinea("Iberia");
		    Aeropuerto aeropuertoLoiu = new Aeropuerto("Loiu");
		    Aeropuerto aeropuertoMunich = new Aeropuerto("Munich");	
		    Vuelo vuelo = new Vuelo(aeropuertoLoiu, aeropuertoMunich, aerolineaIberia, null, null, 10);	
		    Usuario eljoni = new Usuario("jonaso@opendeusto.es", "yon", "google+", "paypal", aeropuertoLoiu);
		    Reserva reservaJoni = new Reserva(eljoni, 50, 20, vuelo);
			
		    //Insert data from the db
		    try {
			    transaction.begin();
			    
			    persistentManager.makePersistent(vuelo);
			    persistentManager.makePersistent(aeropuertoMunich);
			    persistentManager.makePersistent(aeropuertoLoiu);
			    persistentManager.makePersistent(eljoni);
			    persistentManager.makePersistent(reservaJoni);
			    persistentManager.makePersistent(aerolineaIberia);
			    
			    System.out.println("- Inserted into db: " + aerolineaIberia.getClass().getName() +" "+ aerolineaIberia.name);
			    System.out.println("- Inserted into db: " + aeropuertoLoiu.getClass().getName() +" "+ aeropuertoLoiu.name);
			    System.out.println("- Inserted into db: " + aeropuertoMunich.getClass().getName() +" "+ aeropuertoMunich.name);
			    System.out.println("- Inserted into db: " + vuelo.getClass().getName() +" "+ vuelo.id_vuelo);
			    System.out.println("- Inserted into db: " + eljoni.getClass().getName() +" "+ eljoni.email);
			    System.out.println("- Inserted into db: " + reservaJoni.getClass().getName() +" "+ reservaJoni.id_reserva);
			    
			    transaction.commit();
			} catch(Exception ex) {
				System.err.println("* Exception inserting data into db: " + ex.getMessage());
			} finally {		    
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
			    
			    persistentManager.close();
			}
		
		    
		    
			//Select data from the db
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			
			try {
			    transaction.begin();
	
			    @SuppressWarnings("unchecked")
			    Query<Aeropuerto> AeropuertosQuery = persistentManager.newQuery("SELECT FROM " + Aeropuerto.class.getName());
			    
			    for (Aeropuerto aeropuerto : AeropuertosQuery.executeList()) {
			        System.out.println("- Selected from db: " + aeropuerto.name);
			        persistentManager.deletePersistent(aeropuerto);
			        System.out.println("- Deleted from db: " + aeropuerto.name);
			    }
			    
			    transaction.commit();
			} catch(Exception ex) {
				System.err.println("* Exception executing a query: " + ex.getMessage());
			} finally {
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
			    persistentManager.close();
			}
			
			
			
			//Update the db data
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			
			try {
			    transaction.begin();
	
			    aerolineaIberia.setName("Vueling");
			    
			    persistentManager.makePersistent(aerolineaIberia);
			    
			    transaction.commit();
			    
			    System.out.println("- Updated: " + aerolineaIberia.toString());
			} catch(Exception ex) {
				System.err.println("* Exception updating data in db: " + ex.getMessage());
			} finally {
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
			    persistentManager.close();
			}
			
		} catch (Exception ex) {
			System.err.println("* Exception: " + ex.getMessage());
		}
		
		
	}
}