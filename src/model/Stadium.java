package model;

import java.util.concurrent.ThreadLocalRandom;

public class Stadium {

	private String stadiumName;
	private String location;
	private int numberOfSeats;

	public Stadium(String stadiumName, String location) {
		this.stadiumName = stadiumName;
		this.location = location;
		this.numberOfSeats = ThreadLocalRandom.current().nextInt(3000, 6001);
	}

	public String getStadiumName() {
		return stadiumName;

	}

	public String getLocation() {
		return location;
	}

	public int getNumOfSeats() {
		return numberOfSeats;
	}

	@Override
	public String toString() {
		return stadiumName + " stadium which located in " + location + " and has " + numberOfSeats + " seats.";
	}
}
