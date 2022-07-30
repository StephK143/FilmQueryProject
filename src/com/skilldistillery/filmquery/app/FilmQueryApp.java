package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

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
	}

}
