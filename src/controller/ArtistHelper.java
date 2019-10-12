package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Artists;

public class ArtistHelper {

static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MusicRecords");
	
	public void insertArtist(Artists artist) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(artist);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Artists>showAllArtists() {
		
		EntityManager em = emfactory.createEntityManager();
		List<Artists> allArtists = em.createQuery("SELECT a FROM Artists a").getResultList();
		return allArtists;
	}
	
	public void deleteArtist(Artists toDelete) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Artists>typedQuery = em.createQuery("select a from Artists a where a.name = :selectedName", Artists.class);
		
		typedQuery.setParameter("selectedName", toDelete.getName());
		
		typedQuery.setMaxResults(1);
		
		Artists result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Artists searchForArtistById(int idToEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Artists found = em.find(Artists.class, idToEdit);
		em.close();
		return found;		
	}

	public void updateArtist(Artists toEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();		
	}

	public List<Artists> searchForArtistByName(String name) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Artists>typedQuery = em.createQuery("select a from Artists a where gn.name = :selectedName", Artists.class);
		typedQuery.setParameter("selectedName", name);
		List<Artists>foundArtists = typedQuery.getResultList();
		em.close();
		return foundArtists;		
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
