package compatitions;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import model.Stadium;
import persons.Athlet;
import persons.Judge;

public class PersonalCompatition extends Compatition {

	private eType type;
	private ArrayList<Athlet> allAthlets;
	private int numOfMaxParticipants;
	private ArrayList<Athlet> winners;

	public PersonalCompatition(Stadium stadium, String sport, Judge judge, ArrayList<Athlet> allParticipants) {
		super(stadium, sport, judge);
		this.type = eType.Personal;
		this.allAthlets = new ArrayList<Athlet>();
		this.winners = new ArrayList<Athlet>();
		this.numOfMaxParticipants = ThreadLocalRandom.current().nextInt(4, 7);
		createMe(allParticipants);
		findWinners();

	}

	@Override
	public eSportComp getSport() {
		return sport;
	}
//create random compatition with sorted array by sport
	public void createMe(ArrayList<Athlet> allParticipants) {
		if (allParticipants.size() <= numOfMaxParticipants) {
			for (int i = 0; i < allParticipants.size(); i++) {
				allAthlets.add(allParticipants.get(i));
			}
		} else {
			int counter = 0;
			while (counter < numOfMaxParticipants) {
				int random = ThreadLocalRandom.current().nextInt(0, allParticipants.size());
				if (canAdd(allParticipants.get(random))) {
					allAthlets.add(allParticipants.get(random));
					counter++;
				}
			}
		}
	}
// to make sure we dont enter the same athlet twice
	private boolean canAdd(Athlet athlet) {
		for (int i = 0; i < allAthlets.size(); i++) {
			if (athlet.getName().equalsIgnoreCase(allAthlets.get(i).getName()))
				return false;
		}
		return true;
	}
// random winners index for compatition 
	public void findWinners() {
		int counter = 0;
		while (counter < NUM_OF_WINNERS) {
			int winnerIndex = ThreadLocalRandom.current().nextInt(0, allAthlets.size());
			if (addWinner(allAthlets.get(winnerIndex))) {
				allAthlets.get(winnerIndex).getCountry().updateMedals();
				counter++;

			}

		}

	}

	public ArrayList<Athlet> getWinners() {
		return winners;
	}
// to make sure we dont duplicate winners
	private boolean checkAthlet(Athlet athlet) {
		for (int i = 0; i < winners.size(); i++) {
			if (athlet.getName().equalsIgnoreCase(winners.get(i).getName())) {
				return false;
			}
		}
		return true;

	}

	private boolean addWinner(Athlet athlet) {
		if (checkAthlet(athlet)) {
			winners.add(athlet);
			return true;
		}
		return false;
	}

	private String printWinners() {
		StringBuffer sb = new StringBuffer("\nThe winners are:\n");
		for (int i = 0; i < winners.size(); i++) {
			sb.append(winners.get(i).toString() + "\n");

		}
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("\nInformation of each participant:\n");
		for (int i = 0; i < allAthlets.size(); i++) {
			sb.append(allAthlets.get(i).toString() + "\n");
		}
		return super.toString() + "compatition type: personal\n" + sb.toString() + printWinners();
	}

}
