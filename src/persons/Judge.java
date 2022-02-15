package persons;

import model.Country;

public class Judge extends Person {

	public enum eJurisdiction {
		Jumping, Running
	};

	private eJurisdiction jurisdiction;

	public Judge(String name, Country countryName, String sportType) {
		super(name, countryName);
		setJurisdiction(sportType);

	}

	public void setJurisdiction(String sportType) {
		if (sportType.equalsIgnoreCase("Jumping"))
			this.jurisdiction = eJurisdiction.Jumping;

		if (sportType.equalsIgnoreCase("Running"))
			this.jurisdiction = eJurisdiction.Running;
	}

	public eJurisdiction getJurisdiction() {
		return jurisdiction;
	}

	@Override
	public String toString() {
		return super.toString() + " is a judge of " + getJurisdiction() + "\n";
	}

}
