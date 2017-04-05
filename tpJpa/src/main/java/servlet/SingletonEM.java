package servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonEM {
	
	private EntityManagerFactory factory;
	private EntityManager manager;

	private SingletonEM() {
	}
	
	private static SingletonEM INSTANCE = new SingletonEM();
	
	public static SingletonEM getInstance(){
		return INSTANCE;
	}
	
	public EntityManager getManager(){
		return this.manager;
	}
	
	public EntityManagerFactory getFactory(){
		return this.factory;
	}

	public void init(){
		this.factory = Persistence.createEntityManagerFactory("example");
		this.manager = factory.createEntityManager();
	}
	
	public void destroy(){
		manager.close();
		factory.close();
	}
}
