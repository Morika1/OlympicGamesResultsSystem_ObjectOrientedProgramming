package persons;

import model.Country;

public abstract class Athlet extends Person {
	public enum eSport {
		Running, Jumping, RunningAndJumping
	}

	public Athlet(String name, Country countryName) {

		super(name, countryName);
	}

	public abstract eSport getSport();

	@Override
	public String toString() {
		return super.toString() + " is an athlet";
	}
}
