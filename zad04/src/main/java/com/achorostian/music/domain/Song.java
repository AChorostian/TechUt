package com.achorostian.music.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "song.all", query = "Select s from Song s"),
        @NamedQuery(name = "song.byName", query = "Select s from Song s where s.name = :name")
})
public class Song
{

    private Long id;
    private String name;
    private int length = 0;
    private List<Genre> genreList = new ArrayList<Genre>();
    private Album album = null;
    private Artist artist;
    private File file;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(nullable = false)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Genre> getGenreList() {
        return genreList;
    }
    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Album getAlbum() { return album; }
    public void setAlbum(Album album) { this.album = album; this.artist = album.getArtist(); }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Artist getArtist() { return artist; }
    public void setArtist(Artist artist) { if (this.album == null) this.artist = artist; }

    @OneToOne(fetch = FetchType.LAZY)
    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        this.file = file;
    }
}
