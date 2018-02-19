package game.release;

import java.util.Random;

//Enum Decision is needed for few reasons: logging, making random decision and control of possible decisions 
public enum Decision {

	ROCK("ROCK"), PAPER("PAPER"), SCISSORS("SCISSORS");

	private String variant;

	Decision(String variant) {
		this.variant = variant;
	}

	public static Decision makeRndDecision() {
		Random rnd = new Random();
		int choise = rnd.nextInt(3);
		if (choise == 2) {
			return Decision.ROCK;
		} else if (choise == 1) {
			return Decision.PAPER;
		} else {
			return Decision.SCISSORS;
		}
	}

	public String getVariant() {
		return variant;
	}

}
