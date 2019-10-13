package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "albums")
public class AlbumList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "album_id")
	private Long album_id;

	@Column(name = "title")
	private String title;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "created_on")
	private LocalDate createdOn;
	
	@ManyToOne
	@JoinColumn(name="genres_id")
	private Genres genres;
	
	@ManyToOne
	@JoinColumn(name="artist_id")
	private Artists artist;
	
	public AlbumList() {
		super();		
	}
	
	public AlbumList(Artists artist, String title, String year) {
		super();
		this.artist = artist;
		this.title = title;
		this.year = year;
	}
	
	public AlbumList(Artists artist, String title, String year, LocalDate createdOn) {
		super();
		this.artist = artist;
		this.title = title;
		this.year = year;
		this.createdOn = createdOn;
	}

	public Long getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(Long album_id) {
		this.album_id = album_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public Genres getGenres() {
		return genres;
	}

	public void setGenres(Genres genres) {
		this.genres = genres;
	}

	public Artists getArtist() {
		return artist;
	}

	public void setArtist(Artists artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "AlbumList [album_id=" + getAlbum_id() + ", title=" + getTitle() + ", year=" + getYear() + ", createdOn=" + getCreatedOn()
				+ ", genres=" + getGenres() + ", artist=" + getArtist().toString() + "]";
	}
//	return "AlbumList [album_id=" + getAlbum_id() + album_id + ", title=" + title + ", year=" + year + ", createdOn=" + createdOn
//			+ ", genres=" + genres + ", artist=" + artist.toString() + "]";
}
//@Entity
//@Table(name = "albums")
//public class AlbumList {
//	
//	@Id
////	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name = "album_id")
//	private Long album_id;
//	
////	@Column(name = "ARTIST") //remove field and create table artist
////	private String artist;
//	
//	@Column(name = "title")
//	private String title;
//	
//	@Column(name = "year")
//	private String year;
//	
//	@Column(name= "created_on")
//	private LocalDate createdOn;
//	
//	@ManyToOne
//	@JoinColumn(name="genres_id")
//	private Genres genres;
//	
//	@ManyToOne
//	@JoinColumn(name="artist_id")
//	private Artists artist;
//	
//	public AlbumList() {
//		super();		
//	}
//	
//	public AlbumList(Artists artist, String title, String year) {
//		super();
//		this.artist = artist;
//		this.title = title;
//		this.year = year;
//	}
//	
//	public AlbumList(Artists artist, String title, String year, Date createdOn) {
//		super();
//		this.artist = artist;
//		this.title = title;
//		this.year = year;
//		this.createdOn = createdOn;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getArtist() {
//		return artist;
//	}
//
//	public void setArtist(String artist) {
//		this.artist = artist;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	
//	public String getYear() {
//		return year;
//	}
//	
//	public void setYear(String year) {
//		this.year = year;
//	}
//	
//	public LocalDate getDateCreated() {
//		return dateCreated;
//	}
//
//	public void setDateCreated(LocalDate dateCreated) {
//		this.dateCreated = dateCreated;
//	}
//
//	public String returnAlbumDetails() {
//		return "artist[ " + artist + " ] title[ " + title + " , year[ " + year + " ] , Created[ " + dateCreated + " ]";
//	}
//}
//
