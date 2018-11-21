package musicproject.domain;

public class Song {

    private int id;
    private String artist;
    private String title;
    private float length; // in seconds
    private int dateOfRelease;
    private boolean original;

    public Song(String artist, String title, float length , int dateOfRelease, boolean original)
    {
        this.id = 0;
        this.artist = artist;
        this.title = title;
        this.length = length;
        this.dateOfRelease = dateOfRelease;
        this.original = original;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public float getLength() { return length; }
    public void setLength(float length) { this.length = length; }

    public int getDateOfRelease() { return dateOfRelease; }
    public void setDateOfRelease(int dateOfRelease) { this.dateOfRelease = dateOfRelease; }

    public boolean isOriginal() { return original; }
    public void setOriginal(boolean original) { this.original = original; }

}
