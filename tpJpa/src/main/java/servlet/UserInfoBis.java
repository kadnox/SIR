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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		try {
		
				
				Personne HTSA = new Personne();
				
				HTSA.setPrenom(request.getParameter("firstname"));
				HTSA.setNom(request.getParameter("name"));

				
				manager.persist(HTSA);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tx.commit();
		
		manager.close();
		factory.close();
		
	}
}
