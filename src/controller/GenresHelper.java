package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Genres;

public class GenresHelper {

	public GenresHelper() {
		super();
	}

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MusicRecords");
	
	public void insertGenre(Genres genre) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(genre);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Genres>showAllGenres() {
		
		EntityManager em = emfactory.createEntityManager();
		List<Genres> allGenres = em.createQuery("SELECT i FROM Genres i").getResultList();
		return allGenres;
	}
	
	public void deleteGenre(Genres toDelete) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Genres>typedQuery = em.createQuery("select gn from Genres gn where gn.name = :selectedName", Genres.class);
		
//>>>>>>>>		// select id??????
		typedQuery.setParameter("selectedName", toDelete.getName());
		
		typedQuery.setMaxResults(1);
		
		Genres result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Genres searchForGenreById(int idToEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Genres found = em.find(Genres.class, idToEdit);
		em.close();
		return found;		
	}

	public void updateGenre(Genres toEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();		
	}

	public List<Genres> searchForGenreByName(String name) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Genres>typedQuery = em.createQuery("select gn from Genres gn where gn.name = :selectedName", Genres.class);
		typedQuery.setParameter("selectedName", name);
		List<Genres>foundGenres = typedQuery.getResultList();
		em.close();
		return foundGenres;		
	}
	
	public void cleanUp() {
		emfactory.close();
	}	
}
