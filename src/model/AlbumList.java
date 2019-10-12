package model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "ARTIST") //remove field and create table artist
	private String artist;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "YEAR")
	private String year;
	@Column(name= "DATE_CREATED")
	private LocalDate dateCreated;
	
//	@ManyToOne(optional=false)
//	@JoinColumn(name="ID",referencedColumnName="ID")
//	private Genres gener;
	
//	@ManyToOne(optional=false)
//	@JoinColumn(name="ID", referencedColumnName="ARTIST_ID")
//	private Artists artistObj;
	
	public AlbumList() {
		super();		
	}
	
	public AlbumList(String artist, String title, String year) {
		super();
		this.artist = artist;
		this.title = title;
		this.year = year;
	}
	
	public AlbumList(String artist, String title, String year, LocalDate date) {
		super();
		this.artist = artist;
		this.title = title;
		this.year = year;
		this.dateCreated = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
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
	public String returnAlbumDetails() {
		return "artist[ " + artist + " ] title[ " + title + " , year[ " + year + " ] , Created[ " + dateCreated + " ]";
	}
	

}

