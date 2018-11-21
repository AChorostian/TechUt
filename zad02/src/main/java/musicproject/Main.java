package musicproject;

import musicproject.domain.Music;
import musicproject.service.MusicService;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        DriverManager.registerDriver(new );
        MusicService musicService = new MusicService();
        Music utwor = new Music("author","title");
        musicService.addMusic(utwor);

        System.out.println("shit");
        
    }
}
