package fr.istic.sir.rest;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import jpa.EntityManagerHelper;

import domain.Maison;
import domain.Personne;

@Path("/API")
public class SampleWebService {
	EntityManager manager = EntityManagerHelper.getEntityManager();
	EntityTransaction tx = manager.getTransaction();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String bienvenu() {
		return "Bienvenu sur notre API voici les routes possibles : \n personnes \n maisons ";
	}

	@GET
	@Path("/personnes")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Personne> getPersonnes() {

		Collection<Personne> result = manager.createQuery("Select p from Personne p", Personne.class).getResultList();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(result.toString());

		return result;
	}

	@GET
	@Path("/personnes/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Personne getPersonne(@PathParam("id") int id) {

		Personne result = manager.createQuery("Select p from Personne p where p.id = :id", Personne.class)
				.setParameter("id", id).getResultList().get(0);

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		return result;
	}

	@GET
	@Path("/maisons")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Maison> getMaison() {

		Collection<Maison> result = manager.createQuery("Select m from Maison m", Maison.class).getResultList();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();

		return result;
	}

	@POST
	@Path("/personnes")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPerson(@QueryParam("prenom") String prenom, @QueryParam("nom") String nom,
			@QueryParam("age") int age) {
		Personne p = new Personne();
		p.setAge(age);
		p.setNom(nom);
		p.setPrenom(prenom);

		tx.begin();
		manager.persist(p);
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();

		String result = "Nom: " + nom + "\n Prenom : " + prenom + "\n Age : " + age;
		return Response.status(200).entity(result).build();
	}

	@POST
	@Path("/maisons")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMaison(@QueryParam("adresse") String adresse, 
			@QueryParam("nbpiece") int nbPieces, @QueryParam("idProp") long idP) {
		Maison maison = new Maison();

		maison.setAdresse(adresse);
		maison.setNbPieces(nbPieces);

		Personne proprio = manager.createQuery("Select p from Personne p where p.id = :id", Personne.class)
				.setParameter("id", idP).getResultList().get(0);

		maison.setProprio(proprio);

		tx.begin();
		manager.persist(maison);
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();

		String result = "Adresse : " + adresse + "; Nombre de piece : " + nbPieces + "; Home ID : " + idP;
		return Response.status(200).entity(result).build();
	}
}
