package com.achorostian.music.service;

import java.util.List;

import com.achorostian.music.domain.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class MusicServiceImplementation implements MusicService {

	@Autowired
	private SessionFactory sessionFactory;

	// CREATE

	@Override
	public void addAlbum(Album album)
	{
		album.setId(null);
		sessionFactory.getCurrentSession().persist(album);
	}

	@Override
	public void addArtist(Artist artist)
	{
		artist.setId(null);
		sessionFactory.getCurrentSession().persist(artist);
	}

	@Override
	public void addFile(File file)
	{
		file.setId(null);
		sessionFactory.getCurrentSession().persist(file);
	}

	@Override
	public void addGenre(Genre genre)
	{
		genre.setId(null);
		sessionFactory.getCurrentSession().persist(genre);
	}

	@Override
	public void addPlaylist(Playlist playlist)
	{
		playlist.setId(null);
		sessionFactory.getCurrentSession().persist(playlist);
	}

	@Override
	public void addSong(Song song)
	{
		song.setId(null);
		sessionFactory.getCurrentSession().persist(song);
	}

	// READ

		// FIND ONE

		@Override
		public Artist findArtistByName(String name)
		{
			return (Artist) sessionFactory.getCurrentSession().getNamedQuery("artist.byName").setString("name", name).uniqueResult();
		}

		@Override
		public Genre findGenreByName(String name)
		{
			return (Genre) sessionFactory.getCurrentSession().getNamedQuery("genre.byName").setString("name", name).uniqueResult();
		}

		// FIND MANY

		@Override
		@SuppressWarnings("unchecked")
		public List<Album> findAlbumsByName(String name)
		{
			return sessionFactory.getCurrentSession().getNamedQuery("album.byName").setString("name", name).list();
		}

		@Override
		@SuppressWarnings("unchecked")
		public List<File> findFilesByName(String name)
		{
			return sessionFactory.getCurrentSession().getNamedQuery("file.byName").setString("name", name).list();
		}

		@Override
		@SuppressWarnings("unchecked")
		public List<Playlist> findPlaylistsByName(String name)
		{
			return sessionFactory.getCurrentSession().getNamedQuery("playlist.byName").setString("name", name).list();
		}

		@Override
		@SuppressWarnings("unchecked")
		public List<Song> findSongsByName(String name)
		{
			return sessionFactory.getCurrentSession().getNamedQuery("song.byName").setString("name", name).list();
		}

		// FIND BY REFERENCE

//		@Override
//		@SuppressWarnings("unchecked")
//		public List<Album> findAlbumsByArtist(Artist artist)
//		{
//			return sessionFactory.getCurrentSession().getNamedQuery("album.byArtistId").setLong("artist_id", artist.getId() ).list();
//		}
//
//		@Override
//		@SuppressWarnings("unchecked")
//		public List<Playlist> findPlaylistsByArtist(Artist artist)
//		{
//			return sessionFactory.getCurrentSession().getNamedQuery("playlists.byArtistId").setLong("artist_id", artist.getId() ).list();
//		}
//
//		@Override
//		@SuppressWarnings("unchecked")
//		public List<Song> findSongsByArtist(Artist artist)
//		{
//			return sessionFactory.getCurrentSession().getNamedQuery("song.byArtistId").setLong("artist_id", artist.getId() ).list();
//		}

		// FIND ALL

		@Override
		@SuppressWarnings("unchecked")
		public List<Album> getAllAlbums()
		{
			return sessionFactory.getCurrentSession().getNamedQuery("album.all").list();
		}

		@Override
		@SuppressWarnings("unchecked")
		public List<Artist> getAllArtists()
		{
			return sessionFactory.getCurrentSession().getNamedQuery("artist.all").list();
		}

		@Override
		@SuppressWarnings("unchecked")
		public List<File> getAllFiles()
		{
			return sessionFactory.getCurrentSession().getNamedQuery("file.all").list();
		}

		@Override
		@SuppressWarnings("unchecked")
		public List<Genre> getAllGenres()
		{
			return sessionFactory.getCurrentSession().getNamedQuery("genre.all").list();
		}

		@Override
		@SuppressWarnings("unchecked")
		public List<Playlist> getAllPlaylists()
		{
			return sessionFactory.getCurrentSession().getNamedQuery("playlist.all").list();
		}

		@Override
		@SuppressWarnings("unchecked")
		public List<Song> getAllSongs()
		{
			return sessionFactory.getCurrentSession().getNamedQuery("song.all").list();
		}

	// UPDATE

	@Override
	public void updateAlbum(Album album)
	{
		album = (Album) sessionFactory.getCurrentSession().get(Album.class, album.getId());
		sessionFactory.getCurrentSession().update(album);
	}

	@Override
	public void updateArtist(Artist artist)
	{
		artist = (Artist) sessionFactory.getCurrentSession().get(Artist.class, artist.getId());
		sessionFactory.getCurrentSession().update(artist);
	}

	// DELETE

	@Override
	public void deleteAlbum(Album album)
	{
		album = (Album) sessionFactory.getCurrentSession().get(Album.class, album.getId());
//		// cascade delete
//		for (Album album : artist.getAlbums())
//		{
//			sessionFactory.getCurrentSession().delete(album);
//		}
		sessionFactory.getCurrentSession().delete(album);
	}

	@Override
	public void deleteArtist(Artist artist)
	{
		artist = (Artist) sessionFactory.getCurrentSession().get(Artist.class, artist.getId());
		sessionFactory.getCurrentSession().delete(artist);
	}

	@Override
	public void deleteFile(File file)
	{
		file = (File) sessionFactory.getCurrentSession().get(File.class, file.getId());
		sessionFactory.getCurrentSession().delete(file);
	}

	@Override
	public void deleteGenre(Genre genre)
	{
		genre = (Genre) sessionFactory.getCurrentSession().get(Genre.class, genre.getId());
		sessionFactory.getCurrentSession().delete(genre);
	}

	@Override
	public void deletePlaylist(Playlist playlist)
	{
		playlist = (Playlist) sessionFactory.getCurrentSession().get(Playlist.class, playlist.getId());
		sessionFactory.getCurrentSession().delete(playlist);
	}

	@Override
	public void deleteSong(Song song)
	{
		song = (Song) sessionFactory.getCurrentSession().get(Song.class, song.getId());
		sessionFactory.getCurrentSession().delete(song);
	}



//	@Override
//	public List<Album> getOwnedCars(Artist artist) {
//		artist = (Artist) sessionFactory.getCurrentSession().get(Artist.class,
//				artist.getId());
//		// lazy loading here - try this code without (shallow) copying
//		List<Album> albums = new ArrayList<Album>(artist.getAlbums());
//		return albums;
//	}
//
//
//	@Override
//	public Long addNewCar(Album album) {
//		album.setId(null);
//		return (Long) sessionFactory.getCurrentSession().save(album);
//	}
//
//	@Override
//	public void sellCar(Long personId, Long carId) {
//		Artist artist = (Artist) sessionFactory.getCurrentSession().get(
//				Artist.class, personId);
//		Album album = (Album) sessionFactory.getCurrentSession()
//				.get(Album.class, carId);
//		album.setSold(true);
//		artist.getAlbums().add(album);
//	}
//
//	@Override
//	@SuppressWarnings("unchecked")
//	public List<Album> getAvailableCars() {
//		return sessionFactory.getCurrentSession().getNamedQuery("album.unsold")
//				.list();
//	}
//	@Override
//	public void disposeCar(Artist artist, Album album) {
//
//		artist = (Artist) sessionFactory.getCurrentSession().get(Artist.class,
//				artist.getId());
//		album = (Album) sessionFactory.getCurrentSession().get(Album.class,
//				album.getId());
//
//		Album toRemove = null;
//		// lazy loading here (artist.getAlbums)
//		for (Album aAlbum : artist.getAlbums())
//			if (aAlbum.getId().compareTo(album.getId()) == 0) {
//				toRemove = aAlbum;
//				break;
//			}
//
//		if (toRemove != null)
//			artist.getAlbums().remove(toRemove);
//
//		album.setSold(false);
//	}
//
//	@Override
//	public Album findCarById(Long id) {
//		return (Album) sessionFactory.getCurrentSession().get(Album.class, id);
//	}

}
