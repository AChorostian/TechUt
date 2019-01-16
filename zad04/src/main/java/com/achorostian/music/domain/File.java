package com.achorostian.music.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "file.all", query = "Select f from File f"),
        @NamedQuery(name = "file.byName", query = "Select f from File f where f.name = :name")
})
public class File
{

    private Long id;
    private String name;
    private String location;
    private long size;
    private int bitrate;
    private Song song;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(nullable = false)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Column(nullable = false)
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    @Column(nullable = false)
    public long getSize() { return size; }
    public void setSize(long size) { this.size = size; }

    public int getBitrate() { return bitrate; }
    public void setBitrate(int bitrate) { this.bitrate = bitrate; }

    @OneToOne(fetch = FetchType.LAZY)
    public Song getSong() {
        return song;
    }
    public void setSong(Song song) {
        this.song = song;
    }

}
