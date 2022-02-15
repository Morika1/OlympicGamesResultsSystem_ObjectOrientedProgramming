package compatitions;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import model.Stadium;
import persons.Judge;
import persons.Team;

public class TeamCompatition extends Compatition {

	private eType type;
	private ArrayList<Team> allTeams;
	private ArrayList<Team> winners;
	private int maxNumOfParticipantTeams;

	public TeamCompatition(Stadium stadium, String sport, Judge judge, ArrayList<Team> allGamesTeams) {
		super(stadium, sport, judge);
		this.type = eType.Team;
		this.allTeams = new ArrayList<Team>();
		this.winners = new ArrayList<Team>();
		this.maxNumOfParticipantTeams = ThreadLocalRandom.current().nextInt(4, 6);
		createMe(allGamesTeams);
		findWinners();
	}

	@Override
	public eSportComp getSport() {
		return sport;
	}

	public ArrayList<Team> getWinners() {
		return winners;
	}
// create teams compatition randomly from sorted team array by sport
	public void createMe(ArrayList<Team> allGamesTeams) {
		if (allGamesTeams.size() <= maxNumOfParticipantTeams) {
			for (int i = 0; i < allGamesTeams.size(); i++) {
				allTeams.add(allGamesTeams.get(i));

			}

		} else {
			int counter = 0;
			while (counter < maxNumOfParticipantTeams) {
				int random = ThreadLocalRandom.current().nextInt(0, allGamesTeams.size());
				if (canAdd(allGamesTeams.get(random))) {
					allTeams.add(allGamesTeams.get(random));
					counter++;
				}

			}

		}

	}
// verify that team is not added twice
	private boolean canAdd(Team team) {
		for (int i = 0; i < allTeams.size(); i++) {
			if (team.getCountry().getCountryName().equalsIgnoreCase(allTeams.get(i).getCountry().getCountryName()))
				return false;

		}
		return true;
	}
// verify that wont duplicate winners
	private boolean checkTeam(Team team) {
		for (int i = 0; i < winners.size(); i++) {
			if (team.getCountry().getCountryName().equalsIgnoreCase(winners.get(i).getCountry().getCountryName())) {
				return false;
			}
		}
		return true;

	}

	private boolean addWinner(Team team) {
		if (checkTeam(team)) {
			winners.add(team);
			return true;
		}
		return false;
	}
// find winners randomly by index
	public void findWinners() {
		int counter = 0;
		while (counter < NUM_OF_WINNERS) {
			int winnerIndex = ThreadLocalRandom.current().nextInt(0, allTeams.size());
			if (addWinner(allTeams.get(winnerIndex))) {
				allTeams.get(winnerIndex).getCountry().updateMedals();
				counter++;
			}
		}
	}

	private String printWinners() {
		StringBuffer sb = new StringBuffer("\nThe winners are: ");
		for (int i = 0; i < winners.size(); i++) {
			sb.append(winners.get(i).toString());

		}
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("\nInformation of each team:\n");
		for (int i = 0; i < allTeams.size(); i++) {
			sb.append(allTeams.get(i).toString() + "\n");
		}
		return super.toString() + "compatition type: team\n" + sb.toString() + printWinners();
	}

}
