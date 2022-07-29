package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
    app.test();
//   app.launch();
  }

  private void test() {
    Film film = null;
	try {
		film = db.findFilmById(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(film);
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
	  
	  //menu user story 1
	  //hint for story 2 in Slack
	  // if film is not found, java will print "film not found" not blank or null(if or if else)
    // if story 3 pass to interface dai 
	  //like %keyword%
	  //story 4 language id prints the actual language along with the title
	  //story 5 to display a film the actors will also be displayed.
  }

}
