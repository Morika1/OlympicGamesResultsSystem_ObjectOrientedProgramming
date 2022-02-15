package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import compatitions.Compatition;
import compatitions.PersonalCompatition;
import compatitions.TeamCompatition;
import persons.Athlet;
import persons.Judge;
import persons.Jumper;
import persons.Runner;
import persons.RunnerAndJumper;
import persons.Team;

public class OlympicGames {

	private ArrayList<Compatition> allCompatitions;
	private ArrayList<Athlet> allAthlets;
	private ArrayList<Judge> allJudges;
	private ArrayList<Stadium> stadiums;
	private ArrayList<Team> allTeams;
	private ArrayList<Country> allCountries;
	private static int currentYear=2020;
	private int year;
	private String startDate;
	private String endDate;
	
	

	public OlympicGames(File athletsInfo, File judgesInfo, File stadiumsInfo) throws FileNotFoundException {
		this.allCompatitions = new ArrayList<Compatition>();
		this.allAthlets = new ArrayList<Athlet>();
		this.allJudges = new ArrayList<Judge>();
		this.stadiums = new ArrayList<Stadium>();
		this.allTeams = new ArrayList<Team>();
		this.allCountries = new ArrayList<Country>();
		readAthletsInfo(athletsInfo);
		readStadiumsInfo(stadiumsInfo);
		readJudgesInfo(judgesInfo);
		saveCountries();
		createTeams();
		createCompatitions();
		this.startDate="02/11/"+currentYear;
		this.endDate="12/11/"+currentYear;
		currentYear+=4;
		year=currentYear;
	}
// each country has one team for each sport- create the teams by sport 
	private void createTeamsBySport(String sport) {
		for (int i = 0; i < allCountries.size(); i++) {
			allTeams.add(
					new Team(allCountries.get(i), sport, getMinimized(allCountries.get(i).getCountryName(), sport)));

		}
	}
// team creation.if another sport types will be added to the program we can call the upper function with the new sport branch
	public void createTeams() {
		createTeamsBySport("Running");
		createTeamsBySport("Jumping");
	}
// minimize athlets array by relevant sport and country
	private ArrayList<Athlet> getMinimized(String country, String sport) {
		ArrayList<Athlet> minimized = new ArrayList<Athlet>();
		for (int i = 0; i < allAthlets.size(); i++) {
			if (country.equalsIgnoreCase(allAthlets.get(i).getCountry().getCountryName())
					&& (sport.equalsIgnoreCase(allAthlets.get(i).getSport().name())
							|| allAthlets.get(i) instanceof RunnerAndJumper)) {
				minimized.add(allAthlets.get(i));
			}
		}
		return minimized;

	}
// minimize teams array by sport
	private ArrayList<Team> getMinimizedTeam(String sport) {
		ArrayList<Team> minimized = new ArrayList<Team>();
		for (int i = 0; i < allTeams.size(); i++) {
			if (sport.equalsIgnoreCase(allTeams.get(i).getTeamSport().name())) {
				minimized.add(allTeams.get(i));
			}

		}
		return minimized;

	}
// choose sport randomly
	private String chooseSport() {
		int number = ThreadLocalRandom.current().nextInt(1, 3);

		String sport = "";
		if (number == 1) {
			sport = "running";
		} else if (number == 2) {
			sport = "jumping";
		}
		return sport;
	}
// find all countries on board
	public void saveCountries() {
		for (int i = 0; i < allAthlets.size(); i++) {
			if (checkCountries(allAthlets.get(i).getCountry().getCountryName())) {
				allCountries.add(new Country(allAthlets.get(i).getCountry().getCountryName()));

			}
		}
	}
// verify countries are not duplicated
	private boolean checkCountries(String countryName) {
		for (int i = 0; i < allCountries.size(); i++) {
			if (allCountries.get(i).getCountryName().equalsIgnoreCase(countryName))
				return false;
		}

		return true;
	}
// choose judge randomly by sport type
	private Judge chooseJudge(String sportType) {
		ArrayList<Judge> sportBranch = new ArrayList<Judge>();
		for (int i = 0; i < allJudges.size(); i++) {
			if (allJudges.get(i).getJurisdiction().name().equalsIgnoreCase(sportType))
				sportBranch.add(allJudges.get(i));
		}
		int chosenJudgeIndex = ThreadLocalRandom.current().nextInt(0, sportBranch.size());

		return sportBranch.get(chosenJudgeIndex);

	}
// choose stadium randomly
	private Stadium chooseStadium() {
		int chosenStadiumIndex = ThreadLocalRandom.current().nextInt(0, stadiums.size());
		return stadiums.get(chosenStadiumIndex);
	}
// get minimized athlet array by sport type only
	private ArrayList<Athlet> getMinimized(String sport) {
		ArrayList<Athlet> minimized = new ArrayList<Athlet>();
		for (int i = 0; i < allAthlets.size(); i++) {
			if (sport.equalsIgnoreCase(allAthlets.get(i).getSport().name())
					|| allAthlets.get(i) instanceof RunnerAndJumper)
				minimized.add(allAthlets.get(i));

		}
		return minimized;
	}
// randomly creation of compatitions
	public void createCompatitions() {
		createPersonalCompatitions();
		createTeamCompatitions();
	}
// help to cteate personal compatition randomly
	private void createPersonalCompatitions() {
		int numOfPersonalCompatitions = ThreadLocalRandom.current().nextInt(2, 6);
		for (int i = 0; i < numOfPersonalCompatitions; i++) {
			String sport = chooseSport();
			allCompatitions
					.add(new PersonalCompatition(chooseStadium(), sport, chooseJudge(sport), getMinimized(sport)));
		}
	}
	// help to cteate personal compatition randomly
	private void createTeamCompatitions() {
		int numOfTeamCompatitions = ThreadLocalRandom.current().nextInt(2, 6);
		for (int i = 0; i < numOfTeamCompatitions; i++) {
			String sport = chooseSport();
			allCompatitions
					.add(new TeamCompatition(chooseStadium(), sport, chooseJudge(sport), getMinimizedTeam(sport)));
		}

	}

	public String showAllStadiums() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < stadiums.size(); i++) {
			sb.append(i + 1 + ". " + stadiums.get(i).toString() + "\n\n");
		}
		return sb.toString();
	}

	public String showAllParticipants() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < allAthlets.size(); i++) {
			sb.append(i + 1 + ". " + allAthlets.get(i).toString() + "\n\n");
		}
		return sb.toString();
	}

	public String showAllCompatitions() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < allCompatitions.size(); i++) {
			sb.append(allCompatitions.get(i).toString());
		}
		return sb.toString();
	}

	public String showAllCountriesChartByMedals() {
		Collections.sort(allCountries);
		StringBuffer sb = new StringBuffer("Countries view by medals:\n\n");
		for (int i = 0; i < allCountries.size(); i++) {
			if (i <= 2 && i >= 0) {
				sb.append(allCountries.get(i).toString() + " -place number: " + (i + 1) + "\n");
			} else {
				sb.append(allCountries.get(i).toString() + "\n");
			}

		}
		return sb.toString();
	}

	public String showAthletsBySport(String sport) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < allAthlets.size(); i++) {
			if (sport.equalsIgnoreCase(allAthlets.get(i).getSport().name())) {
				sb.append(allAthlets.get(i).toString() + "\n\n");
			}
		}
		return sb.toString();
	}

	public String showRunners() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < allAthlets.size(); i++) {
			if (allAthlets.get(i).getSport().name().equalsIgnoreCase("Running")) {
				sb.append(allAthlets.get(i).toString() + "\n\n");
			}

		}
		return sb.toString();
	}

	public String showJumpers() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < allAthlets.size(); i++) {
			if (allAthlets.get(i).getSport().name().equalsIgnoreCase("jumping")) {
				sb.append(allAthlets.get(i).toString() + "\n\n");
			}

		}
		return sb.toString();
	}

	public String showRunnersAndJumpers() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < allAthlets.size(); i++) {
			if (allAthlets.get(i).getSport().name().equalsIgnoreCase("jumping")
					|| allAthlets.get(i).getSport().name().equalsIgnoreCase("running")) {
				sb.append(allAthlets.get(i).toString() + "\n\n");
			}

		}
		return sb.toString();
	}

	public String allCompatitions() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < allCompatitions.size(); i++) {
			sb.append((i + 1) + ". " + allCompatitions.get(i).toString() + "\n\n");
		}
		return sb.toString();
	}
// insert info from file to arrays repositories
	public void readAthletsInfo(File athletsInfo) throws FileNotFoundException {
		Scanner fileScan = new Scanner(athletsInfo);
		while (fileScan.hasNext()) {
			int numOfParticipants = Integer.parseInt(fileScan.nextLine());
			for (int i = 0; i < numOfParticipants; i++) {
				String name = fileScan.nextLine();
				String countryName = fileScan.nextLine();
				String sport = fileScan.nextLine();
				if (sport.equalsIgnoreCase("Runner")) {
					this.allAthlets.add(new Runner(name, new Country(countryName)));
				} else if (sport.equalsIgnoreCase("Jumper")) {
					this.allAthlets.add(new Jumper(name, new Country(countryName)));
				} else
					this.allAthlets.add(new RunnerAndJumper(name, new Country(countryName)));

			}
		}

		fileScan.close();

	}
	// insert info from file to arrays repositories
	public void readStadiumsInfo(File stadiumsInfo) throws FileNotFoundException {
		Scanner fileScan = new Scanner(stadiumsInfo);
		while (fileScan.hasNext()) {
			int numberOfStadiums = Integer.parseInt(fileScan.nextLine());
			for (int i = 0; i < numberOfStadiums; i++) {
				String stadiumName = fileScan.nextLine();
				String location = fileScan.nextLine();
				this.stadiums.add(new Stadium(stadiumName, location));
			}
		}
		fileScan.close();
	}
	// insert info from file to arrays repositories
	public void readJudgesInfo(File judgesInfo) throws FileNotFoundException {
		Scanner fileScan = new Scanner(judgesInfo);
		while (fileScan.hasNext()) {
			int numOfJudges = Integer.parseInt(fileScan.nextLine());
			for (int i = 0; i < numOfJudges; i++) {
				String name = fileScan.nextLine();
				String countryName = fileScan.nextLine();
				String jurisdiction = fileScan.nextLine();
				allJudges.add(new Judge(name, new Country(countryName), jurisdiction));

			}
		}
		fileScan.close();
	}

	public String showIndividualCompatitions() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < allCompatitions.size(); i++) {
			if (allCompatitions.get(i) instanceof PersonalCompatition)
				sb.append(allCompatitions.get(i).toString() + "\n\n");
		}
		return sb.toString();
	}

	public String showTeamCompatitions() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < allCompatitions.size(); i++) {
			if (allCompatitions.get(i) instanceof TeamCompatition)
				sb.append(allCompatitions.get(i).toString() + "\n\n");
		}
		return sb.toString();
	}

	public String showDate() {
		return "Start date: "+startDate+"\n End date: "+endDate+"\n\nNext time will be on "+year;
	}

}
