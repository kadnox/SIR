package domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Maison {
	
	private int id;
	private String adresse;
	private Collection<Chauffage> chauffages;
	private float taille;
	private int nbPieces;
	private Personne proprio;

	public Maison() {

	}

	public Maison(String adresse, Collection<Chauffage> chauffages, float taille, int nbPieces) {
		
		this.adresse = adresse;
		this.chauffages = chauffages;
		this.taille = taille;
		this.nbPieces = nbPieces;
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	@OneToMany(mappedBy="maison", cascade = CascadeType.PERSIST)
	public Collection<Chauffage> getChauffages() {
		return chauffages;
	}

	public void setChauffages(Collection<Chauffage> chauffages) {
		this.chauffages = chauffages;
	}

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}
	
	@ManyToOne
	public Personne getProprio() {
		return proprio;
	}

	public void setProprio(Personne proprio) {
		this.proprio = proprio;
	}

}
