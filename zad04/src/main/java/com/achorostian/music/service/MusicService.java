package com.achorostian.music.service;

import java.util.List;
import com.achorostian.music.domain.*;

public interface MusicService
{

	// CREATE

	void addAlbum(Album album);
	void addArtist(Artist artist);
	void addFile(File file);
	void addGenre(Genre genre);
	void addPlaylist(Playlist playlist);
	void addSong(Song song);

	// READ

		// FIND ONE
		Artist findArtistByName(String name);
		Genre findGenreByName(String name);

		// FIND MANY
		List<Album> findAlbumsByName(String name);
		List<File> findFilesByName(String name);
		List<Playlist> findPlaylistsByName(String name);
		List<Song> findSongsByName(String name);

		// FIND BY REFERENCE
//		List<Album> findAlbumsByArtist(Artist artist);
//		List<Song> findSongsByArtist(Artist artist);
//		List<Playlist> findPlaylistsByArtist(Artist artist);

		// FIND ALL
		List<Album> getAllAlbums();
		List<Artist> getAllArtists();
		List<File> getAllFiles();
		List<Genre> getAllGenres();
		List<Playlist> getAllPlaylists();
		List<Song> getAllSongs();

	// UPDATE

	void updateAlbum(Album album);
	void updateArtist(Artist artist);

	// DELETE

	void deleteAlbum(Album album);
	void deleteArtist(Artist artist);
	void deleteFile(File file);
	void deleteGenre(Genre genre);
	void deletePlaylist(Playlist playlist);
	void deleteSong(Song song);

}
