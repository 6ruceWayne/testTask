package game.release;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*	This class is responsible to all game. It manipulates players, writes log into console and announces the winner
 * Game also can't exist without players - so there is only parameters constructor
 */
public class GameProcess {
	private List<Player> players;

	public GameProcess(List<Player> players) {
		this.players = players;
	}

	// The main method which starts the game until the players in list are more than
	// one
	public void startGame() {
		do {
			doOneIteration();
		} while (players.size() > 1);
		System.out.println(players.get(0).getName() + " is the winner!");
	}

	/*
	 * Each of bet is "iteration", firth of all the method groups all decisions in
	 * one map. The reason why I decided to use map is pretty simple - the game need
	 * to know who decided something and manipulate with this data. Also it makes
	 * the game more flexible. After collecting data the game checks it for terms of
	 * draw. If they exists - print it. If they don't - clear players who survived
	 * in this iteration;
	 */
	private void doOneIteration() {
		Map<Decision, List<Player>> decisions = getDecisions();
		if (checkDraw(decisions)) {
			System.out.println("Draw" + "\n");
		} else {
			filtr(decisions);
			printRemaining();
		}
	}

	// Method which returns map of decisions
	private Map<Decision, List<Player>> getDecisions() {
		Map<Decision, List<Player>> decisions = new HashMap<Decision, List<Player>>();
		decisions.put(Decision.PAPER, new ArrayList<Player>());
		decisions.put(Decision.ROCK, new ArrayList<Player>());
		decisions.put(Decision.SCISSORS, new ArrayList<Player>());
		List<Player> playerWhoChose = null;
		for (Player player : players) {
			player.makeDecision();
			playerWhoChose = decisions.get(player.getDecision());
			playerWhoChose.add(player);
			decisions.put(player.getDecision(), playerWhoChose);
		}
		return decisions;
	}

	/*
	 * Method checks conditions of draw. If they match - return true. If they don't
	 * - return false
	 */
	private boolean checkDraw(Map<Decision, List<Player>> decisions) {
		// If all players choose all combination
		if (decisions.get(Decision.PAPER).size() > 0 && decisions.get(Decision.ROCK).size() > 0
				&& decisions.get(Decision.SCISSORS).size() > 0) {
			return true;
		}
		// Conditions about all players choose only one combination
		if (decisions.get(Decision.PAPER).size() == players.size()) {
			return true;
		}
		if (decisions.get(Decision.ROCK).size() == players.size()) {
			return true;
		}
		if (decisions.get(Decision.SCISSORS).size() == players.size()) {
			return true;
		}
		return false;
	}

	/*
	 * Method cleans the list of players. This method has to be called only when we
	 * use it with previous method.
	 */
	private void filtr(Map<Decision, List<Player>> decisions) {
		if (decisions.get(Decision.PAPER).size() == 0) {
			this.players = decisions.get(Decision.ROCK);
		}
		if (decisions.get(Decision.ROCK).size() == 0) {
			this.players = decisions.get(Decision.SCISSORS);
		}
		if (decisions.get(Decision.SCISSORS).size() == 0) {
			this.players = decisions.get(Decision.PAPER);
		}
	}

	// Method which prints players who survived in an iteration
	private void printRemaining() {
		System.out.print("\n" + "Remaining players: ");
		for (Player player : players) {
			System.out.print(player.getName() + " ");
		}
		System.out.println("\n");
	}
}
