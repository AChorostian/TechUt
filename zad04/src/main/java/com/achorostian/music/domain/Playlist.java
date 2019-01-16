package com.achorostian.music.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "playlist.all", query = "Select p from Playlist p"),
        @NamedQuery(name = "playlist.byName", query = "Select p from Playlist p where p.name = :name")
})
public class Playlist
{
    private Long id;
    private String name;
    private Artist artist;
    private List<Song> songList = new ArrayList<Song>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(nullable = false)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Artist getArtist() { return artist; }
    public void setArtist(Artist artist) { this.artist = artist; }

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    public List<Song> getSongList() {
        return songList;
    }
    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
