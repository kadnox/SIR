package jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Appareil;
import domain.Chauffage;
import domain.Maison;
import domain.Personne;


public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		try {
			create(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tx.commit();
		
		manager.close();
		factory.close();
	}
	
	private static void create(EntityManager manager) {
		Long nbPersonne = (Long) manager.createQuery("select count(p) FROM Personne p").getSingleResult();
		
		if(nbPersonne == 0) {
			
			Collection<Appareil> appList1 = new ArrayList<Appareil>();
			Collection<Appareil> appList2 = new ArrayList<Appareil>();
			Collection<Appareil> appList3 = new ArrayList<Appareil>();
			
			
			Personne HTSA = new Personne();
			Personne Yvann = new Personne();
			Personne Thomas = new Personne();
			
			Appareil tv = new Appareil("TV",120,HTSA);
			Appareil lDVD = new Appareil("lecteurDVD",19,HTSA);
			Appareil hc = new Appareil("homecinema",200,HTSA);
			
			Appareil mo = new Appareil("micro ondes",200,Thomas);
			Appareil fo = new Appareil("four",200,Thomas);
			Appareil tel = new Appareil("smart phone",100,Thomas);
			
			Appareil table = new Appareil("tablette",80,Yvann);
			Appareil impr = new Appareil("imprimante",120,Yvann);
			
			appList1.add(tv);
			appList1.add(lDVD);
			appList1.add(hc);
			
			appList2.add(mo);
			appList2.add(fo);
			appList2.add(tel);
			
			appList3.add(table);
			appList3.add(impr);
			
			Chauffage ch1 = new Chauffage(50);
			Chauffage ch2 = new Chauffage(60);
			Chauffage ch3 = new Chauffage(70);
			Chauffage ch4 = new Chauffage(60);
			Chauffage ch5 = new Chauffage(50);
			Chauffage ch6 = new Chauffage(80);
			Chauffage ch7 = new Chauffage(80);
			
			Collection<Chauffage> chList1 = new ArrayList<Chauffage>();
			Collection<Chauffage> chList2 = new ArrayList<Chauffage>();
			Collection<Chauffage> chList3 = new ArrayList<Chauffage>();
			
			Maison maison1 = new Maison("5 square Dr Guerin",chList1,50,2,Yvann);
			Maison maison2 = new Maison("64 boulevard Raymond Poincarré",chList2,80,3,HTSA);
			Maison maison3 = new Maison("4 boulevard Solferino",chList3,60,2,Thomas);
			
			ch1.setMaison(maison1);
			ch2.setMaison(maison1);
			ch7.setMaison(maison1);
			
			ch3.setMaison(maison2);
			ch4.setMaison(maison2);
			
			ch6.setMaison(maison3);
			ch5.setMaison(maison3);
			
			
			chList1.add(ch1);
			chList1.add(ch2);
			chList1.add(ch7);
			
			chList2.add(ch3);
			chList2.add(ch4);
			
			chList3.add(ch5);
			chList3.add(ch6);
			
			
			maison1.setChauffages(chList1);
			maison2.setChauffages(chList2);
			maison3.setChauffages(chList3);
			
			Collection<Personne> poteHtsa = new ArrayList<Personne>();
			Collection<Personne> poteYvann = new ArrayList<Personne>();
			Collection<Personne> poteThomas = new ArrayList<Personne>();
			
			Collection<Maison> maisonHtsa = new ArrayList<Maison>();
			Collection<Maison> maisonYvann = new ArrayList<Maison>();
			Collection<Maison> maisonThomas = new ArrayList<Maison>();
			
			maisonHtsa.add(maison3);
			maisonThomas.add(maison2);
			maisonYvann.add(maison1);
			
			
			HTSA.setPrenom("Hedi Theo");
			HTSA.setNom("Sahraoui");
			HTSA.setAppareils(appList1);
			HTSA.setMaisons(maisonHtsa);
			
			
			Yvann.setPrenom("Yvann");
			Yvann.setNom("Josso");
			Yvann.setAppareils(appList2);
			Yvann.setMaisons(maisonYvann);
			
			
			Thomas.setPrenom("Thomas");
			Thomas.setNom("Gregoire");
			Thomas.setAppareils(appList3);
			Thomas.setMaisons(maisonThomas);
			
			
			poteHtsa.add(Yvann);
			poteHtsa.add(Thomas);
			
			poteYvann.add(Thomas);
			poteYvann.add(HTSA);
			
			poteThomas.add(Yvann);
			poteThomas.add(HTSA);
			
			HTSA.setAmis(poteHtsa);
			Yvann.setAmis(poteYvann);
			Thomas.setAmis(poteThomas);
			
			manager.persist(HTSA);
			manager.persist(Yvann);
			manager.persist(Thomas);		
			
		}
	}

}
