package servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonEM {
	
	private EntityManagerFactory factory;
	private EntityManager manager;

	public SingletonEM() {
		super();
	}
	
	//Faire instance bla bla voir ACO
	
	
	public void init(){
		this.factory = Persistence.createEntityManagerFactory("example");
		this.manager = factory.createEntityManager();
	}
}
