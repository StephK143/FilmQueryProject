package com.skilldistillery.filmquery.entities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.skilldistillery.filmquery.database.DatabaseAccessorObject;

public class Film {
	private int filmId;
	private String filmTitle;
	private String filmDescription;
	private int filmReleaseYear;
	private int filmLanguageId;
	private int filmRentalDuration;
	private double filmRentalRate;
	private int filmLength;
	private double filmReplacementCost;
	private String filmRating;
	private String filmSpecialFeatures;
	private List<Actor> la = new ArrayList<>();
	

	public Film() {
		super();
	}

	public Film(int filmId, String filmTitle, String filmDescription, int filmReleaseYear, int filmLanguageId,
			int filmRentalDuration, double filmRentalRate, int filmLength, double filmReplacementCost, String filmRating,
			String filmSpecialFeatures) {
		super();
		this.filmId = filmId;
		this.filmTitle = filmTitle;
		this.filmDescription = filmDescription;
		this.filmReleaseYear = filmReleaseYear;
		this.filmLanguageId = filmLanguageId;
		this.filmRentalDuration = filmRentalDuration;
		this.filmRentalRate = filmRentalRate;
		this.filmLength = filmLength;
		this.filmReplacementCost = filmReplacementCost;
		this.filmRating = filmRating;
		this.filmSpecialFeatures = filmSpecialFeatures;
	}

	public Film(String filmTitle, int filmReleaseYear) {
		super();
		this.filmTitle = filmTitle;
		this.filmReleaseYear = filmReleaseYear;
		
	}
	public List<Actor> getLa() {
		return la;
	}

	public void setLa(List<Actor> la) {
		this.la = la;
	}
	
	

	public void getActorsInFilm() {

	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public String getFilmDescription() {
		return filmDescription;
	}

	public void setFilmDescription(String filmDescription) {
		this.filmDescription = filmDescription;
	}

	public int getFilmReleaseYear() {
		return filmReleaseYear;
	}

	public void setFilmReleaseYear(int filmReleaseYear) {
		this.filmReleaseYear = filmReleaseYear;
	}

	public int getFilmLanguageId() {
		return filmLanguageId;
	}

	public void setFilmLanguageId(int filmLanguageId) {
		this.filmLanguageId = filmLanguageId;
	}

	public int getFilmRentalDuration() {
		return filmRentalDuration;
	}

	public void setFilmRentalDuration(int filmRentalDuration) {
		this.filmRentalDuration = filmRentalDuration;
	}

	public double getFilmRentalRate() {
		return filmRentalRate;
	}

	public void setFilmRentalRate(double d) {
		this.filmRentalRate = d;
	}

	public int getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(int filmLength) {
		this.filmLength = filmLength;
	}

	public double getFilmReplacementCost() {
		return filmReplacementCost;
	}

	public void setFilmReplacementCost(double filmReplacementCost) {
		this.filmReplacementCost = filmReplacementCost;
	}

	public String getFilmRating() {
		return filmRating;
	}

	public void setFilmRating(String filmRating) {
		this.filmRating = filmRating;
	}

	public String getFilmSpecialFeatures() {
		return filmSpecialFeatures;
	}

	public void setFilmSpecialFeatures(String filmSpecialFeatures) {
		this.filmSpecialFeatures = filmSpecialFeatures;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmDescription, filmId, filmLanguageId, filmLength, filmRating, filmReleaseYear,
				filmRentalDuration, filmRentalRate, filmReplacementCost, filmSpecialFeatures, filmTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(filmDescription, other.filmDescription) && filmId == other.filmId
				&& filmLanguageId == other.filmLanguageId && filmLength == other.filmLength
				&& Objects.equals(filmRating, other.filmRating) && filmReleaseYear == other.filmReleaseYear
				&& filmRentalDuration == other.filmRentalDuration && filmRentalRate == other.filmRentalRate
				&& Double.doubleToLongBits(filmReplacementCost) == Double.doubleToLongBits(other.filmReplacementCost)
				&& Objects.equals(filmSpecialFeatures, other.filmSpecialFeatures)
				&& Objects.equals(filmTitle, other.filmTitle);
	}

	@Override
	public String toString() {
		return "Film Id: " + filmId + ", Title: " + filmTitle + ",\nDescription: " + filmDescription
				+ ",\nYear released: " + filmReleaseYear + ", Language Id= " + filmLanguageId
				+ ", Rental Duration: " + filmRentalDuration + ", Rental Rate: $" + filmRentalRate + ", Length: "
				+ filmLength + "minutes, Replacement Cost: $" + filmReplacementCost + ",\nRating=" + filmRating
				+ ", Special Features=" + filmSpecialFeatures + "\nActors in the film include: " + la + "";
	}

}
