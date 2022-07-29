package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;


public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
//sql text, url, anything touching the database here!
 
	@Override
  public Film findFilmById(int filmId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql;
		sql = "SELECT * FROM film";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
		}
		rs.close();
		stmt.close();
		conn.close();
		
    return null;
  }

@Override
public Actor findActorById(int actorId) {
	
	return null;
}

@Override
public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
	String user = "student";
	String pass = "student";
	Connection conn = DriverManager.getConnection(URL, user, pass);

	String sql;
	sql = "SELECT * FROM film JOIN film_actor fa ON f.id = fa.film_id"
							+ "JOIN actor a ON a.actor_id = fa.film_id"
			+ "WHERE actor = ?";

	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, filmId);
	ResultSet rs = stmt.executeQuery();
	while (rs.next()) {
		System.out.println(rs.getString("id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
	}
	rs.close();
	stmt.close();
	conn.close();
	return null;
}

}
