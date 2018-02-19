package game.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import game.release.GameProcess;
import game.release.Player;

/*	Almost everything was encapsulated so the one reason to test this class it to see how it'll log in single game
 * Enjoy :)
 */
public class GameProcessTest {

	@Test
	public void gameProcessTest() {
		GameProcess game = makeProcess();
		game.startGame();
	}

	private GameProcess makeProcess() {
		List<Player> players = new ArrayList<Player>();
		Player misha = new Player("Misha");
		players.add(misha);
		Player petya = new Player("Petya");
		players.add(petya);
		Player vasya = new Player("Vasya");
		players.add(vasya);
		return new GameProcess(players);
	}
}
