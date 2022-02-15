package compatitions;

import model.Stadium;
import persons.Judge;

public abstract class Compatition {
	private Judge judge;
	private Stadium stadium;
	protected final static int NUM_OF_WINNERS = 3;

	protected enum eSportComp {
		Running, Jumping
	};

	protected enum eType {
		Personal, Team
	};

	protected eSportComp sport;

	public Compatition(Stadium stadium, String sport, Judge judge) {
		this.stadium = stadium;
		this.judge = judge;
		setSport(sport);

	}

	public void setSport(String type) {
		if (type.equalsIgnoreCase("Running"))
			this.sport = eSportComp.Running;

		if (type.equalsIgnoreCase("Jumping"))
			this.sport = eSportComp.Jumping;

	}

	public Judge getJudge() {
		return judge;
	}

	public Stadium getStadium() {
		return stadium;
	}

	public abstract eSportComp getSport();

	public String toString() {
		return "Compatition info:\n" + "This compatition is from type: " + sport.name() + " \nstadium information: "
				+ stadium.toString() + "\njudge: " + judge.toString();
	}

	public abstract void findWinners();

}
