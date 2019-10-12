package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
public class Artists {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ARTIST_ID")
	private int artist_id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	
//	@OneToMany(mappedBy="artistObj",targetEntity=AlbumList.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private List<AlbumList> artist;
	
	public Artists() {
		
	}

	
	public Artists(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}


	public int getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(int artist_id) {
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
	
	@Override
	public String toString() {
		return "Artists [artist_id=" + artist_id + ", name=" + name + ", description=" + description + "]";
	}
}
