package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AlbumList;
import model.Artists;

public class AlbumListHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MusicRecords");
	
	public void insertAlbum(AlbumList al) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(al);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<AlbumList>showAllAlbums() {
		EntityManager em = emfactory.createEntityManager();
		List<AlbumList> allAlbums = em.createQuery("SELECT al FROM AlbumList al").getResultList();
		
		return allAlbums;
	}
	
	public void deleteAlbum(AlbumList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<AlbumList>typedQuery = em.createQuery("select al from AlbumList al where al.album_id = :selectedId", AlbumList.class);
		
		typedQuery.setParameter("selectedId", toDelete.getAlbum_id());
		
		AlbumList result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public AlbumList searchForAlbumById(long idToEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AlbumList found = em.find(AlbumList.class, idToEdit);
		em.close();
		return found;		
	}

	public void updateAlbum(AlbumList toEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();		
	}

	public List<AlbumList> searchForAlbumByArtist(String artistName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AlbumList>typedQuery = em.createQuery("select al from AlbumList al where al.artist = :selectedArtist", AlbumList.class);
		typedQuery.setParameter("selectedArtist", artistName);
		List<AlbumList>foundAlbums = typedQuery.getResultList();
		em.close();
		return foundAlbums;		
	}

	public List<AlbumList> searchForAlbumsByTitle(String titleName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AlbumList>typedQuery = em.createQuery("select al from AlbumList al where al.title = :selectedTitle", AlbumList.class);
		typedQuery.setParameter("selectedTitle", titleName);
		List<AlbumList>foundAlbums = typedQuery.getResultList();
		em.close();
		return foundAlbums;		
	}
	
	public List<AlbumList> searchForAlbumsByYear(String yearName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AlbumList>typedQuery = em.createQuery("select al from AlbumList al where al.year = :selectedYear", AlbumList.class);
		typedQuery.setParameter("selectedYear", yearName);
		List<AlbumList>foundAlbums = typedQuery.getResultList();
		em.close();
		return foundAlbums;
		
	}
	
	public void cleanUp() {
		emfactory.close();
	}	
}

