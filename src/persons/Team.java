package persons;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import model.Country;

public class Team {
	private ArrayList<Athlet> allAthletsInTeam;
	private Country countryName;

	public enum eSportType {
		Running, Jumping
	};

	private eSportType sport;
	private int numOfMaxParticipants;

	public Team(Country countryName, String teamType, ArrayList<Athlet> allParticipants) {
		this.allAthletsInTeam = new ArrayList<Athlet>();
		this.countryName = countryName;
		this.numOfMaxParticipants = ThreadLocalRandom.current().nextInt(2, 6);
		setSport(teamType);
		createMe(allParticipants);

	}

	public Country getCountry() {
		return countryName;
	}

	public void setSport(String teamType) {
		if (teamType.equalsIgnoreCase("Running"))
			this.sport = eSportType.Running;

		if (teamType.equalsIgnoreCase("Jumping"))
			this.sport = eSportType.Jumping;
	}

	public eSportType getTeamSport() {
		return sport;
	}
//create team randomly by minimized array of participants by sport and country
	public void createMe(ArrayList<Athlet> allParticipants) {
		if (allParticipants.size() <= numOfMaxParticipants) {
			for (int i = 0; i < allParticipants.size(); i++) {
				allAthletsInTeam.add(allParticipants.get(i));

			}
		} else {
			int counter = 0;
			while (counter < numOfMaxParticipants) {
				int randomAthlet = ThreadLocalRandom.current().nextInt(0, allParticipants.size());
				if (canAdd(allParticipants.get(randomAthlet))) {
					allAthletsInTeam.add(allParticipants.get(randomAthlet));
					counter++;
				}
			}
		}

	}
// verify athlets in team are not duplicated
	private boolean canAdd(Athlet athlet) {
		for (int i = 0; i < allAthletsInTeam.size(); i++) {
			if (athlet.getName().equalsIgnoreCase(allAthletsInTeam.get(i).getName()))
				return false;

		}
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(
				"This team is from " + countryName.getCountryName() + " and their sport branch is " + sport + "\n");
		sb.append("Participants of this team are: \n");
		for (int i = 0; i < allAthletsInTeam.size(); i++) {
			sb.append(allAthletsInTeam.get(i).toString() + "\n");
		}

		return sb.toString();
	}
}
