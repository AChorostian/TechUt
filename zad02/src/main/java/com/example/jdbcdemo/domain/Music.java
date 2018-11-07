package com.example.jdbcdemo.domain;

public class Music {
	
	private String autor;
	private String title;
	
	public Music( String autor , String title )
	{
		this.autor = autor;
		this.title = title;
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
