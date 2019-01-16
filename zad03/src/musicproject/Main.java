package musicproject;

import musicproject.service.SongService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        SongService songService = new SongService();
        //initWithSampleData(songService);
        //testImplementation(songService);

    }
    
}
