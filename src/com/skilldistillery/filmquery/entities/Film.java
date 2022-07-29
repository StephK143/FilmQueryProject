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
	private int filmRentalRate;
	private int filmLength;
	private double filmReplacementCost;
	private String filmRating;
	private String filmSpecialFeatures;

	public Film() {
		super();
	}

	public Film(int filmId, String filmTitle, String filmDescription, int filmReleaseYear, int filmLanguageId,
			int filmRentalDuration, int filmRentalRate, int filmLength, double filmReplacementCost, String filmRating,
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

	// write method to list actors of a film
	public void getActorsInFilm() {
		DatabaseAccessorObject dba = new DatabaseAccessorObject();
		try {
			dba.findActorsByFilmId(filmId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public int getFilmRentalRate() {
		return filmRentalRate;
	}

	public void setFilmRentalRate(int filmRentalRate) {
		this.filmRentalRate = filmRentalRate;
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
		return "Film [filmId=" + filmId + ", filmTitle=" + filmTitle + ", filmDescription=" + filmDescription
				+ ", filmReleaseYear=" + filmReleaseYear + ", filmLanguageId=" + filmLanguageId
				+ ", filmRentalDuration=" + filmRentalDuration + ", filmRentalRate=" + filmRentalRate + ", filmLength="
				+ filmLength + ", filmReplacementCost=" + filmReplacementCost + ", filmRating=" + filmRating
				+ ", filmSpecialFeatures=" + filmSpecialFeatures + "]";
	}

}
//Complete the Film class with attributes that map to the columns of the film table. Use appropriate datatypes and Java naming conventions. Provide getters and setters, and appropriate constructors. Also add a good toString, and equals and hashCode methods.