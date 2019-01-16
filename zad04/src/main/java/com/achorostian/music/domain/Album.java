package com.achorostian.music.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
		@NamedQuery(name = "album.all", query = "Select a from Album a"),
		@NamedQuery(name = "album.byName", query = "Select a from Album a where a.name = :name")
		//@NamedQuery(name = "album.byArtistId", query = "Select a from Album a where a.artist_id = :artist_id")
})
public class Album
{

	private Long id;
	private String name;
	private int releaseYear;
	private Boolean ep = false;
	private Artist artist;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Boolean getEp() {
		return ep;
	}
	public void setEp(Boolean ep) {
		this.ep = ep;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

}
