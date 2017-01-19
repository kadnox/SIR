package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//do

@Entity
public class Appareil {
	
	private int id;
	private String nom;
	private float consomation;
	private Personne proprio;
	
	public Appareil(){
		
	}
	
	public Appareil(String nom, float consomation) {
		this.nom = nom;
		this.consomation = consomation;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getConsomation() {
		return consomation;
	}
	public void setConsomation(float consomation) {
		this.consomation = consomation;
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	public Personne getProprio() {
		return proprio;
	}

	public void setProprio(Personne proprio) {
		this.proprio = proprio;
	}
}
