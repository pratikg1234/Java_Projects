package com.spring.data.jpa.ex2;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {
	
	@Id
	private int id;
	@Column(name = "movie_name")
	private String movieName;
	@Column
	private double movieTicketPrice;
	@Column
	private String movieCategory;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(int id, String movieName, double movieTicketPrice, String movieCategory) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieTicketPrice = movieTicketPrice;
		this.movieCategory = movieCategory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public double getMovieTicketPrice() {
		return movieTicketPrice;
	}
	public void setMovieTicketPrice(double movieTicketPrice) {
		this.movieTicketPrice = movieTicketPrice;
	}
	public String getMovieCategory() {
		return movieCategory;
	}
	public void setMovieCategory(String movieCategory) {
		this.movieCategory = movieCategory;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, movieCategory, movieName, movieTicketPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return id == other.id && Objects.equals(movieCategory, other.movieCategory)
				&& Objects.equals(movieName, other.movieName)
				&& Double.doubleToLongBits(movieTicketPrice) == Double.doubleToLongBits(other.movieTicketPrice);
	}
	
	
}
