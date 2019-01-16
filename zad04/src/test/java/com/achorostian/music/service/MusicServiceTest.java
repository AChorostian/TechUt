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
}
