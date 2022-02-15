package persons;

import model.Country;

public class RunnerAndJumper extends Athlet implements Runable, Jumpable {

	private eSport sport;
	private Runner runner;
	private Jumper jumper;

	public RunnerAndJumper(String name, Country countryName) {
		super(name, countryName);
		this.runner = new Runner(name, countryName);
		this.jumper = new Jumper(name, countryName);
		this.sport = eSport.RunningAndJumping;
	}

	@Override
	public eSport getSport() {
		return sport;
	}

	@Override
	public String toString() {
		return super.toString() + " from kind " + jumperInfo() + " and " + runnerInfo();
	}

	@Override
	public String jumperInfo() {
		return jumper.jumperInfo();
	}

	@Override
	public String runnerInfo() {
		return runner.runnerInfo();
	}

}
