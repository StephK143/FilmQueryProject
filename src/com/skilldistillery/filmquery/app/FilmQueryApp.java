package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
//    app.test2();
		app.launch();
	}

//	private void test() {
//		Film film = null;
//		try {
//			film = db.findFilmById(1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(film);
//	}
//
//	private void test2() {
//		List<Actor> actorByFilm = null;
//		try {
//			actorByFilm = db.findActorsByFilmId(1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(actorByFilm);
//	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException {
		DatabaseAccessorObject dao = new DatabaseAccessorObject();
		int choice = 1;

		while (choice > 0 && choice < 3) {
			System.out.println(" ___________________________________\n" + "|   Please make your selection:     |\n"
					+ "|                                   |\n" + "|   1. Look up a film by it's ID    |\n"
					+ "|   2. Search for a film by keyword |\n" + "|   3. Exit                         |\n"
					+ " -----------------------------------\n");

			choice = input.nextInt();

			switch (choice) {
			case 1:
				dao.userLookUpByFilmId(input);
				break;
			case 2:
				dao.userLookUpByKeyword(input);
				break;
			case 3:
				System.out.println("You have choosen to exit. GoodBye");
				break;
			default:
				System.out.println("Please choose a valid entry");
				break;
			}
		}
		// menu user story 1
		// hint for story 2 in Slack
		// if film is not found, java will print "film not found" not blank or null(if
		// or if else)
		// if story 3 pass to interface dai
		// like %keyword%
		// story 4 language id prints the actual language along with the title
		// story 5 to display a film the actors will also be displayed.
	}

}
