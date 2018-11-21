package musicproject.domain;


// 5 roznych typow
// transakcyjnosc - (na jego githubie masz xd)
// CRD - + ewentualnie update
// searche
// wiele do arraylist

public class Music {
	private String autor;
	private String title;
	private long id;


	public Music( String autor , String title )
	{
		this.autor = autor;
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAutor()
	{
		return this.autor;
	}
	public String getTitle() 
	{
		return this.title;
	}
	public void setAutor(String autor) 
	{
		this.autor = autor;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
}
