package SAHRAOUI_JOSSO.tp3;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Person {
	
	
	@Id
	ObjectId id ;
	String name;
	@Embedded
	ArrayList<Address> adress;
	
	public Person() {
		this.adress = new ArrayList<Address>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Address> getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress.add(adress);
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	
}
