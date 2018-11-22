package org.datanucleus.samples.jdo.tutorial;

import java.util.Date;

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
			
			try {
			    transaction.begin();
			    Aeropuerto origen = new Aeropuerto("1", "Melilla");
			    Aeropuerto destino = new Aeropuerto("2", "Bilbao");
			    Date fechaSalida = new Date(10000000000l);
			    Date fechaLlegada = new Date(10000500000l);
			    Vuelo miVuelo = new Vuelo(1, origen, destino, fechaSalida, fechaLlegada, 30, 28);
			    String[] s = {"asd" , "dsa"};
			    
			    Usuario usuario = new Usuario("Pepito", "Domingues Sanches","pds@opendeusto.es", "Facebook", "Paypal", "Leioa");
			    Reserva reserva = new Reserva("1", 30, s, 50, 20, miVuelo);
			    
			    Inventory inventory = new Inventory("My Inventory");
			    Product product = new Product("Sony MP4", "A standard MP4 from Sony", 49.99);
			    inventory.getProducts().add(product);		    
			    persistentManager.makePersistent(inventory);
			    
			    System.out.println("- Inserted into db: " + product.name);
			    
			    transaction.commit();
			} catch(Exception ex) {
				System.err.println("* Exception inserting data into db: " + ex.getMessage());
			} finally {		    
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
			    
			    persistentManager.close();
			}
			
			//Select data using a Query
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
				
			try {
			    transaction.begin();
	
			    @SuppressWarnings("unchecked")
				Query<Product> productsQuery = persistentManager.newQuery("SELECT FROM " + Product.class.getName() + " WHERE price < 150.00 ORDER BY price ASC");
			    
			    for (Product product : productsQuery.executeList()) {
			        System.out.println("- Selected from db: " + product.name);
			        persistentManager.deletePersistent(product);
			        System.out.println("- Deleted from db: " + product.name);
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
		} catch (Exception ex) {
			System.err.println("* Exception: " + ex.getMessage());
		}
	}
}