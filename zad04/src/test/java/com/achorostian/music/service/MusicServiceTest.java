package com.achorostian.music.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import com.achorostian.music.domain.Artist;
import com.achorostian.music.domain.Album;
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
public class MusicServiceTest {

	@Autowired
	MusicService musicService;

	@Test
	public void addArtist()
	{
		Artist artist = new Artist();
		artist.setName("Mark Knight");
		artist.setBirthDate( new Date() );
		musicService.addArtist(artist);

		Artist retrievedClient = musicService.findArtistByName("Mark Knight");

		assertEquals("Mark Knight", retrievedClient.getName());
	}

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
		album.setArtist( musicService.findArtistByName("Mark Knight") );
		musicService.addAlbum(album);

		Album retrievedAlbum = musicService.findAlbumsByName("A Year In The Life").get(0);
		Artist connectedArtist = retrievedAlbum.getArtist();

		assertEquals("A Year In The Life", retrievedAlbum.getName());
		assertEquals("Mark Knight", connectedArtist.getName());
	}

//	@Test
//	public void addCarCheck() {
//
//		Album album = new Album();
//		album.setName("Mark Knight");
//		album.setModel("Mark Knight");
//		// ... other properties here
//
//		Long carId = musicService.addNewCar(album);
//
//		Album retrievedAlbum = musicService.findCarById(carId);
//		assertEquals("Mark Knight", retrievedAlbum.getName());
//		assertEquals("Mark Knight", retrievedAlbum.getModel());
//		// ... check other properties here
//
//	}
//
//	@Test
//	public void sellCarCheck() {
//
//		Artist artist = new Artist();
//		artist.setName("Mark Knight");
//		//artist.setPin(PIN_2);
//
//		musicService.addArtist(artist);
//
//		Artist retrievedArtist = musicService.findArtistByName("Mark Knight");
//
//		Album album = new Album();
//		album.setName("Mark Knight");
//		album.setModel("Mark Knight");
//
//		Long carId = musicService.addNewCar(album);
//
//		musicService.sellCar(retrievedArtist.getId(), carId);
//
//		List<Album> ownedAlbums = musicService.getOwnedCars(retrievedArtist);
//
//		assertEquals(1, ownedAlbums.size());
//		assertEquals("Mark Knight", ownedAlbums.get(0).getName());
//		assertEquals("Mark Knight", ownedAlbums.get(0).getModel());
//	}
//
//	// @Test -
//	public void disposeCarCheck() {
//		// Do it yourself
//	}

}
