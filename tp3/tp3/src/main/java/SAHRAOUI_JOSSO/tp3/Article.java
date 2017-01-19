package SAHRAOUI_JOSSO.tp3;



import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Article {
	
	
	@Id
	ObjectId id ;
	@Embedded
	ArrayList<Person> perso;
	String name;
	int stars;
	
	public Article() {
		this.perso =  new ArrayList<Person>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public ArrayList<Person> getPerso() {
		return perso;
	}
	public void setPerso(ArrayList<Person> perso) {
		this.perso = perso;
	}

}
