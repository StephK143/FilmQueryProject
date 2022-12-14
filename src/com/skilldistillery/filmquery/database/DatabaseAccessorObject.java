package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	public void userLookUpByFilmId(Scanner kb) {
		Film film = null;
		System.out.println("Please enter the film Id you would like to look up:");
		int fi = kb.nextInt();

		try {
			film = findFilmById(fi);

		}

		catch (SQLException e) {

			e.printStackTrace();

		}
		if (film == null) {
			System.out.println("That is not a valid film id. Please try again.");
		} else {
			System.out.println(film);
		}
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = null;
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql;
		sql = "SELECT * FROM film " + "WHERE id = ? ";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			film = new Film();
			film.setFilmId(rs.getInt("id"));
			film.setFilmTitle(rs.getString("title"));
			film.setFilmDescription(rs.getString("description"));
			film.setFilmReleaseYear(rs.getInt("release_year"));
			film.setFilmLanguageId(rs.getInt("language_id"));
			film.setFilmLanguage(findLanguageByFilmId(film.getFilmId()));
			film.setFilmRentalDuration(rs.getInt("rental_duration"));
			film.setFilmRentalRate(rs.getDouble("rental_rate"));
			film.setFilmLength(rs.getInt("length"));
			film.setFilmReplacementCost(rs.getInt("language_id"));
			film.setFilmRating(rs.getString("rating"));
			film.setFilmSpecialFeatures(rs.getString("special_features"));
			film.setLa(findActorsByFilmId(filmId));
		}
		rs.close();
		stmt.close();
		conn.close();

		return film;
	}

	public void userLookUpByKeyword(Scanner kb) {
		List<Film> filmWithKeyword = new ArrayList<>();
		System.out.println("Please enter a keyword");
		String kw = kb.next();
		kw = "%" + kw + "%";

		try {
			filmWithKeyword = findFilmByKw(kw);

		} catch (SQLException e) {

			e.printStackTrace();

		}
		if (filmWithKeyword == null) {
			System.out.println("There are no movies with that keyword. Please try again.");
		} else {
			System.out.println(filmWithKeyword);
		}
	}

	public List<Film> findFilmByKw(String kw) throws SQLException {
		List<Film> filmWithKeyword = new ArrayList<>();
		Film film;

		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql;
		sql = "SELECT * FROM film " + "WHERE title LIKE ? OR description LIKE ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, kw);
		stmt.setString(2, kw);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			film = new Film();
			film.setFilmId(rs.getInt("id"));
			film.setFilmTitle(rs.getString("title"));
			film.setFilmDescription(rs.getString("description"));
			film.setFilmReleaseYear(rs.getInt("release_year"));
			film.setFilmLanguageId(rs.getInt("language_id"));
			film.setFilmLanguage(findLanguageByFilmId(film.getFilmId()));
			film.setFilmRentalDuration(rs.getInt("rental_duration"));
			film.setFilmRentalRate(rs.getDouble("rental_rate"));
			film.setFilmLength(rs.getInt("length"));
			film.setFilmReplacementCost(rs.getInt("language_id"));
			film.setFilmRating(rs.getString("rating"));
			film.setFilmSpecialFeatures(rs.getString("special_features"));
			filmWithKeyword.add(film);
		}

		rs.close();
		stmt.close();
		conn.close();

		return filmWithKeyword;

	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = null;
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql;
		sql = "SELECT id, first_name, last_name FROM actor";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
		}
		rs.close();
		stmt.close();
		conn.close();

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		List<Actor> actorListByFilm = new ArrayList<>();
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql;
		sql = "SELECT a.id, a.first_name, a.last_name FROM film f " + "JOIN film_actor fa ON f.id = fa.film_id "
				+ "JOIN actor a ON fa.actor_id = a.id " + "WHERE f.id = ? ";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Actor a = new Actor();
			a.setActorId(rs.getInt("id"));
			a.setActorFirstName(rs.getString("first_name"));
			a.setActorLastName(rs.getString("last_name"));
			actorListByFilm.add(a);
		}
		rs.close();
		stmt.close();
		conn.close();
		return actorListByFilm;
	}

	public String findLanguageByFilmId(int filmId) throws SQLException {
		String filmLanguage = "";
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql;
		sql = "SELECT l.name FROM language l JOIN film f ON l.id = f.language_id WHERE f.id = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			filmLanguage = rs.getString("name");
		}
		rs.close();
		stmt.close();
		conn.close();
		return filmLanguage;
	}

}
