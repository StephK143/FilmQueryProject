package com.skilldistillery.filmquery.entities;

import java.util.List;

import com.skilldistillery.filmquery.database.DatabaseAccessor;


public class Actor implements DatabaseAccessor {
	private int actorId;
	private String actorFirstName;
	private String actorLastName;

	public Actor() {
		super();
	}

	public Actor(int actorId, String actorFirstName, String actorLastName) {
		super();
		this.actorId = actorId;
		this.actorFirstName = actorFirstName;
		this.actorLastName = actorLastName;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorFirstName() {
		return actorFirstName;
	}

	public void setActorFirstName(String actorFirstName) {
		this.actorFirstName = actorFirstName;
	}

	public String getActorLastName() {
		return actorLastName;
	}

	public void setActorLastName(String actorLastName) {
		this.actorLastName = actorLastName;
	}


	@Override
	public Film findFilmById(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Actor findActorById(int actorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Actor Id: " + actorId + " Name=" + actorFirstName + " " + actorLastName + " \n";
	}	

}
