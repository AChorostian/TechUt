package musicproject.service;

import musicproject.domain.Song;

import java.sql.*;

public class SongService  {

    private Connection connection;
    private String url = "jdbc:hsqldb:hsql://localhost/workdb";
    private String createTableSong = "CREATE TABLE Song(id INTEGER IDENTITY, artist varchar(50), title varchar(50), Length double, dateOfRelease integer,original boolean)";
    private Statement statement;

    public SongService(){
        try{
           connection = DriverManager.getConnection(url);
           statement = connection.createStatement();

            ResultSet resultSet = connection.getMetaData().getTables(null,null,null,null);
            boolean tableExists = false;
            while (resultSet.next()){
                if("Song".equalsIgnoreCase(resultSet.getString("table_name"))){
                    tableExists = true;
                    break;
                }
            }
            if(!tableExists){
                statement.executeUpdate(createTableSong);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addSong( Song song )
    {

    }

}
