package model;

import java.io.File;
import java.io.FileNotFoundException;
// the managment system
public class Model {

	private OlympicGames olympicGames;
	private File athletsInfo = new File("Athlets.txt");
	private File judgesInfo = new File("Judges.txt");
	private File stadiumsInfo = new File("Stadiums.txt");

	public Model() throws FileNotFoundException {
		this.olympicGames = new OlympicGames(athletsInfo, judgesInfo, stadiumsInfo);

	}

	public String showAllStadiums() {
		return olympicGames.showAllStadiums();
	}

	public String showAllParticipants() {
		return olympicGames.showAllParticipants();
	}

	public String showAthletsBySport(String sport) {
		return olympicGames.showAthletsBySport(sport);
	}

	public String showAllCompatitions() {
		return olympicGames.showAllCompatitions();
	}

	public String showAllCountriesChartByMedals() {
		return olympicGames.showAllCountriesChartByMedals();
	}

	public String showRunners() {
		return olympicGames.showRunners();
	}

	public String showJumpers() {
		return olympicGames.showJumpers();
	}

	public String showRunnersAndJumpers() {
		return olympicGames.showRunnersAndJumpers();
	}

	public String allCompatitions() {
		return olympicGames.allCompatitions();
	}

	public String showTeamCompatitions() {
		return olympicGames.showTeamCompatitions();
	}

	public String showIndividualCompatitions() {
		return olympicGames.showIndividualCompatitions();
	}

	public String showOlympicgamesDate() {
		return olympicGames.showDate();
	}

}
