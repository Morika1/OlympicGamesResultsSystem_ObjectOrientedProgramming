package persons;

import model.Country;

public class Runner extends Athlet implements Runable {

	private eSport sport;

	public Runner(String name, Country countryName) {
		super(name, countryName);
		this.sport = eSport.Running;
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
	public String runnerInfo() {
		return sport.name();
	}
}
