package com.achorostian.music.domain;

import java.util.*;
import javax.persistence.*;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "artist.all", query = "Select a from Artist a"),
	@NamedQuery(name = "artist.byName", query = "Select a from Artist a where a.name = :name")
})
public class Artist
{

	private Long id;
	private String name;
	private Date birthDate = new Date();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, unique = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
