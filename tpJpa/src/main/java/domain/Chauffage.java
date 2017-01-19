package domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Chauffage {
	
	private int id;
	private float conso;
	private Maison maison;

	public float getConso() {
		return conso;
	}
	
	public Chauffage(){
		
	}

	public Chauffage(float conso) {
		this.conso = conso;
	}

	public void setConso(float conso) {
		this.conso = conso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	public Maison getMaison() {
		return maison;
	}

	public void setMaison(Maison maison) {
		this.maison = maison;
	}
	
}
