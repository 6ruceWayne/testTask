package game.release;

import java.util.Random;

//	Class "Player" has 2 constructors - one for making player with random decisions and one to set default style of game

public class Player {
	private String name;
	private PlayerStyle style;
	private Decision decision;

	public Player(String name) {
		this.name = name;
		this.style = PlayerStyle.RANDOM;
	}

	public Player(String name, PlayerStyle style) {
		this.name = name;
		this.style = style;
	}

	// Method checks style and make decisions. Nothing really hard
	public void makeDecision() {
		switch (style) {
		case RANDOM:
			this.decision = Decision.makeRndDecision();
			break;
		case ONLY_PAPER:
			this.decision = Decision.PAPER;
			break;
		case ONLY_ROCK:
			this.decision = Decision.ROCK;
			break;
		case ONLY_SCISSORS:
			this.decision = Decision.SCISSORS;
			break;
		default:
			this.decision = Decision.makeRndDecision();
		}
		System.out.println("Player " + name + " chose " + decision.getVariant());
	}

	public String getName() {
		return name;
	}

	public Decision getDecision() {
		return decision;
	}
}
