package com.achorostian.music.service;

import static org.junit.Assert.assertEquals;

import java.util.*;

import com.achorostian.music.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class MusicServiceTest
{

	@Autowired
	MusicService musicService;

	// CREATE

	@Test
	public void addAlbum()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Album album = new Album();
		album.setName("A Year In The Life");
		album.setReleaseYear(2016);
		album.setEp(false);
		album.setArtist( artist );
		musicService.addAlbum(album);

		Album retrievedAlbum = musicService.findAlbumsByName("A Year In The Life").get(0);
		assertEquals("A Year In The Life", retrievedAlbum.getName());
		assertEquals("Mark Knight", retrievedAlbum.getArtist().getName());
	}

	@Test
	public void addArtist()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Artist retrievedArtist = musicService.findArtistByName("Mark Knight");
		assertEquals("Mark Knight", retrievedArtist.getName());
	}

	@Test
	public void addFile()
	{
		File file = new File();
		file.setName("track02.mp3");
		file.setLocation("MarkKnight/tracks/");
		file.setSize(5603);
		file.setBitrate(320);
		musicService.addFile(file);

		File retrievedFile = musicService.findFilesByName("track02.mp3").get(0);
		assertEquals("MarkKnight/tracks/", retrievedFile.getLocation() );
	}

	@Test
	public void addGenre()
	{
		Genre genre = new Genre();
		genre.setName("Electronic");
		musicService.addGenre(genre);

		Genre retrievedGenre = musicService.findGenreByName("Electronic");
		assertEquals("Electronic", retrievedGenre.getName() );
	}

	@Test
	public void addPlaylist()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Playlist playlist = new Playlist();
		playlist.setName("Saturday Party");
		playlist.setArtist(artist);
		musicService.addPlaylist(playlist);

		Playlist retrievedPlaylist = musicService.findPlaylistsByName("Saturday Party").get(0);
		assertEquals("Saturday Party", retrievedPlaylist.getName() );
	}

	@Test
	public void addSong()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Album album = new Album();
		album.setName("A Year In The Life");
		album.setReleaseYear(2016);
		album.setEp(false);
		album.setArtist( artist );
		musicService.addAlbum(album);

		Song song = new Song();
		song.setName("Rocket Man");
		song.setLength(218);
		song.setAlbum( album );
		musicService.addSong(song);

		Song retrievedSong = musicService.findSongsByName("Rocket Man").get(0);
		assertEquals(218, retrievedSong.getLength() );
	}

	// READ

	@Test
	public void getAllAlbums()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Album album = new Album();
		album.setName("A Year In The Life");
		album.setReleaseYear(2016);
		album.setEp(false);
		album.setArtist( artist );
		musicService.addAlbum(album);

		Album album2 = new Album();
		album2.setName("New Direction");
		album2.setReleaseYear(2012);
		album2.setEp(false);
		album2.setArtist( artist );
		musicService.addAlbum(album2);

		assertEquals(2, musicService.getAllAlbums().size());
	}

	@Test
	public void getAllArtists()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Artist artist2 = new Artist();
		artist2.setName("Harry Romero");
		artist2.setBirthDate( new Date() );
		musicService.addArtist(artist2);

		Artist artist3 = new Artist();
		artist3.setName("Riva Starr");
		artist3.setBirthDate( new Date() );
		musicService.addArtist(artist3);

		assertEquals(3, musicService.getAllArtists().size());
	}

	@Test
	public void getAllFiles()
	{
		File file = new File();
		file.setName("track02.mp3");
		file.setLocation("MarkKnight/tracks/");
		file.setSize(5603);
		file.setBitrate(320);
		musicService.addFile(file);

		assertEquals(1 , musicService.getAllFiles().size() );
	}

	@Test
	public void getAllGenres()
	{
		Genre genre = new Genre();
		genre.setName("Electronic");
		musicService.addGenre(genre);

		Genre genre2 = new Genre();
		genre2.setName("House");
		musicService.addGenre(genre2);

		Genre genre3 = new Genre();
		genre3.setName("Techno");
		musicService.addGenre(genre3);

		Genre genre4 = new Genre();
		genre4.setName("Tech-House");
		musicService.addGenre(genre4);

		assertEquals(4 , musicService.getAllGenres().size() );
	}

	@Test
	public void GetAllPlaylists()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Playlist playlist = new Playlist();
		playlist.setName("Saturday Party");
		playlist.setArtist(artist);
		musicService.addPlaylist(playlist);

		Playlist playlist2 = new Playlist();
		playlist2.setName("Lazy Morning");
		playlist2.setArtist(artist);
		musicService.addPlaylist(playlist2);

		assertEquals(2 , musicService.getAllPlaylists().size() );
	}

	@Test
	public void GetAllSongs()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Album album = new Album();
		album.setName("A Year In The Life");
		album.setReleaseYear(2016);
		album.setEp(false);
		album.setArtist( artist );
		musicService.addAlbum(album);

		Song song = new Song();
		song.setName("Rocket Man");
		song.setLength(218);
		song.setAlbum( album );
		musicService.addSong(song);

		Song song2 = new Song();
		song2.setName("Suzee");
		song2.setLength(275);
		song2.setAlbum( album );
		musicService.addSong(song2);

		assertEquals(2 , musicService.getAllSongs().size() );
	}

	// UPDATE

	@Test
	public void updateAlbum()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Album album = new Album();
		album.setName("A Year In Life");
		album.setReleaseYear(2016);
		album.setEp(false);
		album.setArtist( artist );
		musicService.addAlbum(album);

		album.setName("A Year In The Life");
		musicService.updateAlbum(album);

		Album retrievedAlbum = musicService.findAlbumsByName("A Year In The Life").get(0);
		assertEquals("A Year In The Life", retrievedAlbum.getName());
	}

	@Test
	public void updateArtist()
	{
		Artist artist = new Artist();
		artist.setName("Mark night");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		artist.setName("Mark Knight");
		musicService.updateArtist(artist);

		Artist retrievedArtist = musicService.findArtistByName("Mark Knight");
		assertEquals("Mark Knight", retrievedArtist.getName());
	}

	@Test
	public void updateFile()
	{
		File file = new File();
		file.setName("tr.mp3");
		file.setLocation("MarkKnight/tracks/");
		file.setSize(5603);
		file.setBitrate(320);
		musicService.addFile(file);

		file.setName("track02.mp3");
		musicService.updateFile(file);

		File retrievedFile = musicService.findFilesByName("track02.mp3").get(0);
		assertEquals("track02.mp3", retrievedFile.getName() );
	}

	@Test
	public void updateGenre()
	{
		Genre genre = new Genre();
		genre.setName("Electron");
		musicService.addGenre(genre);

		genre.setName("Electronic");
		musicService.updateGenre(genre);

		Genre retrievedGenre = musicService.findGenreByName("Electronic");
		assertEquals("Electronic", retrievedGenre.getName() );
	}

	@Test
	public void updatePlaylist()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Playlist playlist = new Playlist();
		playlist.setName("Saturday");
		playlist.setArtist(artist);
		musicService.addPlaylist(playlist);

		playlist.setName("Saturday Party");
		musicService.updatePlaylist(playlist);

		Playlist retrievedPlaylist = musicService.findPlaylistsByName("Saturday Party").get(0);
		assertEquals("Saturday Party", retrievedPlaylist.getName() );
	}

	@Test
	public void updateSong()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Album album = new Album();
		album.setName("A Year In The Life");
		album.setReleaseYear(2016);
		album.setEp(false);
		album.setArtist( artist );
		musicService.addAlbum(album);

		Song song = new Song();
		song.setName("Rocket");
		song.setLength(218);
		song.setAlbum( album );
		musicService.addSong(song);

		song.setName("Rocket Man");
		musicService.updateSong(song);

		Song retrievedSong = musicService.findSongsByName("Rocket Man").get(0);
		assertEquals("Rocket Man", retrievedSong.getName() );
	}

	// ADVANCED UPDATE

	@Test
	public void updateFilesLocation()
	{
		File file = new File();
		file.setName("track02.mp3");
		file.setLocation("MarkKnight/tracks/");
		file.setSize(5603);
		file.setBitrate(320);
		musicService.addFile(file);

		File file2 = new File();
		file2.setName("track05.mp3");
		file2.setLocation("MarkKnight/tracks/");
		file2.setSize(5603);
		file2.setBitrate(320);
		musicService.addFile(file2);

		musicService.updateFilesLocation("MarkKnight/tracks/", "Mark/tracks/");

		File retrievedFile1 = musicService.findFilesByName("track02.mp3").get(0);
		File retrievedFile2 = musicService.findFilesByName("track05.mp3").get(0);

		assertEquals("Mark/tracks/", retrievedFile1.getLocation() );
		assertEquals("Mark/tracks/", retrievedFile2.getLocation() );
	}

	// DELETE

	@Test
	public void deleteAlbum()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Album album = new Album();
		album.setName("A Year In The Life");
		album.setReleaseYear(2016);
		album.setEp(false);
		album.setArtist( artist );
		musicService.addAlbum(album);

		musicService.deleteAlbum(album);

		assertEquals(0, musicService.getAllAlbums().size());
	}

	@Test
	public void deleteArtist()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		musicService.deleteArtist(artist);

		assertEquals(0, musicService.getAllArtists().size());
	}

	@Test
	public void deleteFile()
	{
		File file = new File();
		file.setName("track02.mp3");
		file.setLocation("MarkKnight/tracks/");
		file.setSize(5603);
		file.setBitrate(320);
		musicService.addFile(file);

		musicService.deleteFile(file);

		assertEquals(0, musicService.getAllFiles().size());
	}

	@Test
	public void deleteGenre()
	{
		Genre genre = new Genre();
		genre.setName("Electronic");
		musicService.addGenre(genre);

		musicService.deleteGenre(genre);

		assertEquals(0, musicService.getAllGenres().size());
	}

	@Test
	public void deletePlaylist()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Playlist playlist = new Playlist();
		playlist.setName("Saturday Party");
		playlist.setArtist(artist);
		musicService.addPlaylist(playlist);

		musicService.deletePlaylist(playlist);

		assertEquals(0, musicService.getAllPlaylists().size());
	}

	@Test
	public void deleteSong()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Album album = new Album();
		album.setName("A Year In The Life");
		album.setReleaseYear(2016);
		album.setEp(false);
		album.setArtist( artist );
		musicService.addAlbum(album);

		Song song = new Song();
		song.setName("Rocket Man");
		song.setLength(218);
		song.setAlbum( album );
		musicService.addSong(song);

		musicService.deleteSong(song);

		assertEquals(0, musicService.getAllSongs().size());
	}

//	@Test
//	public void cascadeDelete()
//	{
//		Artist artist = new Artist();
//		artist.setName("Mark Knight");
//		artist.setBirthDate( new Date() );
//		musicService.addArtist(artist);
//
//		Album album = new Album();
//		album.setName("A Year In The Life");
//		album.setReleaseYear(2016);
//		album.setEp(false);
//		album.setArtist( artist );
//		musicService.addAlbum(album);
//
//		Song song = new Song();
//		song.setName("Rocket Man");
//		song.setLength(218);
//		song.setAlbum( album );
//		musicService.addSong(song);
//
//		musicService.deleteArtist(artist);
//
//		assertEquals(0, musicService.getAllSongs().size());
//		assertEquals(0, musicService.getAllAlbums().size());
//		assertEquals(0, musicService.getAllArtists().size());
//	}

}
