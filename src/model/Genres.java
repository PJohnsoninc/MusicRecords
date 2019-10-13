package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genres {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "genres_id")
	private Long genres_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	public Genres() {
		super();
	}
	
	public Genres(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Long getGenres_id() {
		return genres_id;
	}
	
	public void setGenres_id(Long genres_id) {
		this.genres_id = genres_id;
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
		return "Genres [genres_id=" + genres_id + ", name=" + name + ", description=" + description + "]";
	}
	
}
//@Entity
//@Table(name = "genres")
//public class Genres {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID")
//	private int id;
//	@Column(name = "NAME")
//	private String name;
//	@Column(name = "DESCRIPTION")
//	private String description;
//	
////	@OneToMany()
////	private List<AlbumList> albums = new ArrayList<>();
//	
//	public Genres() {
//		super();
//	}
//	public Genres(String name, String description) {
//		super();
//		this.name = name;
//		this.description = description;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	
//	public List<AlbumList> getAlbums() {
//		return albums;
//	}
//	public void setAlbums(List<AlbumList> albums) {
//		this.albums = albums;
//	}
//	@Override
//	public String toString() {
//		return "Genres [id=" + id + ", name=" + name + ", description=" + description + "]";
//	}
//}
