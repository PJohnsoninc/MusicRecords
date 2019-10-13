package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
public class Artists {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "artist_id")
	private Long artist_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_on")
	private LocalDate createdOn;
	
	
	public Artists() {
		super();
	}

	public Artists(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Long getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(Long artist_id) {
		this.artist_id = artist_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Artists [artist_id=" + artist_id + ", name=" + name + ", description=" + description + ", createdOn="
				+ createdOn + "]";
	}
}
//@Entity
//@Table(name = "artists")
//public class Artists {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ARTIST_ID")
//	private int artist_id;
//	@Column(name = "NAME")
//	private String name;
//	@Column(name = "DESCRIPTION")
//	private String description;
//	
////	@OneToMany()
////	private List<AlbumList> albums = new ArrayList<>();
//	
//	public Artists() {
//		
//	}
//
//	
//	public Artists(String name, String description) {
//		super();
//		this.name = name;
//		this.description = description;
//	}
//
//
//	public int getArtist_id() {
//		return artist_id;
//	}
//
//	public void setArtist_id(int artist_id) {
//		this.artist_id = artist_id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	
//	
//	public List<AlbumList> getAlbums() {
//		return albums;
//	}
//
//
//	public void setAlbums(List<AlbumList> albums) {
//		this.albums = albums;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Artists [artist_id=" + artist_id + ", name=" + name + ", description=" + description + "]";
//	}
//}
