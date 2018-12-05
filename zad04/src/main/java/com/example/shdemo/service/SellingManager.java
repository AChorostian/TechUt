package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Song;
import com.example.shdemo.domain.Artist;

public interface SellingManager {
	
	void addArtist(Artist artist);
	List<Artist> getAllArtists();
	void deleteArtist(Artist artist);
	Artist findArtistById(Long id);
	
	Long addNewSong(Song song);
	List<Song> getAvailableSongs();
	void disposeSong(Artist artist, Song song);
	Song findSongById(Long id);

	List<Song> getOwnedSongs(Artist artist);
	void sellSong(Long personId, Long carId);

}
