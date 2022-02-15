package persons;

import model.Country;

public class Jumper extends Athlet implements Jumpable {

	private eSport sport;

	public Jumper(String name, Country countryName) {
		super(name, countryName);
		this.sport = eSport.Jumping;
	}

	@Override
	public eSport getSport() {
		return sport;
	}

	@Override
	public String toString() {
		return super.toString() + " from kind " + getClass().getSimpleName();
	}

	@Override
	public String jumperInfo() {
		return sport.name();
	}
}
