package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.example.shdemo.domain.Song;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Artist;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class SellingManagerTest {

	@Autowired
	SellingManager sellingManager;

	private final String NAME_1 = "Bolek";
	private final Long PIN_1 = 1234L;

	private final String NAME_2 = "Lolek";
	private final Long PIN_2 = 123L;

	private final String MODEL_1 = "126p";
	private final String MAKE_1 = "Fiat";

	private final String MODEL_2 = "Mondeo";
	private final String MAKE_2 = "Ford";

	@Test
	public void addArtistCheck() {

		List<Artist> retrievedClients = sellingManager.getAllArtists();

		// If there is a client with PIN_1 delete it
		/*
		for (Artist client : retrievedClients) {

				sellingManager.deleteArtist(client);

		}
*/
		Artist artist = new Artist();
		artist.setFirstName(NAME_1);
		// ... other properties here

		// Pin is Unique
		sellingManager.addArtist(artist);

		Artist retrievedClient = sellingManager.findArtistById(artist.getId());

		assertEquals(NAME_1, retrievedClient.getFirstName());
		// ... check other properties here
	}

	@Test
	public void addSongCheck() {

		Song song = new Song();
		song.setTitle(MAKE_1);
		song.setModel(MODEL_1);
		// ... other properties here

		Long carId = sellingManager.addNewSong(song);

		Song retrievedSong = sellingManager.findSongById(carId);
		assertEquals(MAKE_1, retrievedSong.getTitle());
		assertEquals(MODEL_1, retrievedSong.getModel());
		// ... check other properties here

	}

	@Test
	/*
	public void sellCarCheck() {

		Artist artist = new Artist();
		artist.setFirstName(NAME_2);

		sellingManager.addArtist(artist);

		Artist retrievedArtist = sellingManager.findArtistById(2L);

		Song song = new Song();
		song.setTitle(MAKE_2);
		song.setModel(MODEL_2);

		Long carId = sellingManager.addNewSong(song);

		sellingManager.sellSong(retrievedArtist.getId(), carId);

		List<Song> ownedSongs = sellingManager.getOwnedSongs(retrievedArtist);

		assertEquals(1, ownedSongs.size());
		assertEquals(MAKE_2, ownedSongs.get(0).getTitle());
		assertEquals(MODEL_2, ownedSongs.get(0).getModel());
	}
*/
	// @Test -
	public void disposeCarCheck() {
		// Do it yourself
	}

}
