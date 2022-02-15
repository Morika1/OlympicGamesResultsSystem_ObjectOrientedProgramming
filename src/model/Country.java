package model;

public class Country implements Comparable<Country> {
	private String countryName;
	private int numOfMedals;

	public Country(String countryName) {
		this.countryName = countryName;
		this.numOfMedals = 0;

	}

	public String getCountryName() {
		return countryName;

	}

	public int getNumOfMedals() {
		return numOfMedals;
	}

	public String toString() {
		return countryName + " holds " + numOfMedals + " medals";
	}
// to update medals when winning
	public void updateMedals() {
		numOfMedals++;
	}
//sort countries by medals in sort decsending
	@Override
	public int compareTo(Country country) {
		if (numOfMedals > country.numOfMedals) {
			return -1;
		} else if (numOfMedals > country.numOfMedals) {
			return 1;
		} else {
			return 0;
		}
	}
}
