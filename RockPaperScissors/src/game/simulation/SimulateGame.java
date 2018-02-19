package game.simulation;

import java.util.ArrayList;
import java.util.List;

import game.release.GameProcess;
import game.release.Player;
import game.release.PlayerStyle;

//The main class which was declared as second conditions of test task
public class SimulateGame {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			GameProcess game = makeProcess();
			game.startGame();
		}
	}

	private static GameProcess makeProcess() {
		List<Player> players = new ArrayList<Player>();
		Player misha = new Player("Misha", PlayerStyle.ONLY_ROCK);
		players.add(misha);
		Player petya = new Player("Petya");
		players.add(petya);
		Player vasya = new Player("Vasya");
		players.add(vasya);
		return new GameProcess(players);
	}
}
