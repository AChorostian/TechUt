package com.example.shdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.shdemo.domain.Artist;
import com.example.shdemo.domain.Song;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SellingMangerHibernateImpl implements SellingManager {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addArtist(Artist artist) {
		artist.setId(null);
		sessionFactory.getCurrentSession().persist(artist);
	}
	
	@Override
	public void deleteArtist(Artist artist) {
		artist = (Artist) sessionFactory.getCurrentSession().get(Artist.class,
				artist.getId());
		
		// lazy loading here
		for (Song song : artist.getSongs()) {
			song.setSold(false);
			sessionFactory.getCurrentSession().update(song);
		}
		sessionFactory.getCurrentSession().delete(artist);
	}

	@Override
	public List<Song> getOwnedSongs(Artist artist) {
		artist = (Artist) sessionFactory.getCurrentSession().get(Artist.class,
				artist.getId());
		// lazy loading here - try this code without (shallow) copying
		List<Song> songs = new ArrayList<Song>(artist.getSongs());
		return songs;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Artist> getAllArtists() {
		return sessionFactory.getCurrentSession().getNamedQuery("artist.all")
				.list();
	}

	@Override
	public Artist findArtistById(Long id) {
		return (Artist) sessionFactory.getCurrentSession().getNamedQuery("artist.byId").setLong("id", id).uniqueResult();
	}


	@Override
	public Long addNewSong(Song song) {
		song.setId(null);
		return (Long) sessionFactory.getCurrentSession().save(song);
	}

	@Override
	public void sellSong(Long personId, Long carId) {
		Artist artist = (Artist) sessionFactory.getCurrentSession().get(
				Artist.class, personId);
		Song song = (Song) sessionFactory.getCurrentSession()
				.get(Song.class, carId);
		song.setSold(true);
		artist.getSongs().add(song);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Song> getAvailableSongs() {
		return sessionFactory.getCurrentSession().getNamedQuery("song.unsold")
				.list();
	}
	@Override
	public void disposeSong(Artist artist, Song song) {

		artist = (Artist) sessionFactory.getCurrentSession().get(Artist.class,
				artist.getId());
		song = (Song) sessionFactory.getCurrentSession().get(Song.class,
				song.getId());

		Song toRemove = null;
		// lazy loading here (artist.getSongs)
		for (Song aSong : artist.getSongs())
			if (aSong.getId().compareTo(song.getId()) == 0) {
				toRemove = aSong;
				break;
			}

		if (toRemove != null)
			artist.getSongs().remove(toRemove);

		song.setSold(false);
	}

	@Override
	public Song findSongById(Long id) {
		return (Song) sessionFactory.getCurrentSession().get(Song.class, id);
	}

}
