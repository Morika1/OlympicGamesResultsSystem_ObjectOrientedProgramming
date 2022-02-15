package persons;

import model.Country;

public class Person {
	private String name;
	private Country countryName;

	public Person(String name, Country countryName) {
		this.name = name;
		this.countryName = countryName;

	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return countryName;
	}

	@Override
	public String toString() {
		return name + " from " + countryName.getCountryName();
	}
}
