package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Appareil;
import domain.Chauffage;
import domain.Maison;
import domain.Personne;

@WebServlet(name = "userinfobis", urlPatterns = { "/UserInfoBis" })
public class UserInfoBis extends HttpServlet {
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	public void init(){
		this.factory = Persistence.createEntityManagerFactory("example");
		this.manager = factory.createEntityManager();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			manager.persist(new Personne(request.getParameter("name"), request.getParameter("firstname")));

		} catch (Exception e) {
			e.printStackTrace();
		}

		tx.commit();
		
	}
	
	public void destroy(){
		manager.close();
		factory.close();
	}
}
