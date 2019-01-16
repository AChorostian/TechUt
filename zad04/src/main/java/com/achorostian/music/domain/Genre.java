package com.achorostian.music.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "genre.all", query = "Select g from Genre g"),
        @NamedQuery(name = "genre.byName", query = "Select g from Genre g where g.name = :name")
})
public class Genre
{

    private Long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(nullable = false, unique = true)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}
