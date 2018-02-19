package game.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import game.release.Decision;
import game.release.Player;
import game.release.PlayerStyle;

/*	The application was divided into 4 simple classes(actually 2 classes and 2 enemas)
 * Each of classes are provided by comments(you can find it into this classes)
 * The hardest moment was test random choice(just because it's random). 
 * So I decided to check it with creating Set of 100 choices and if it have size more than 1 - we could decide it work correct.
 */
public class PlayerTest {

	@Test
	public void checkStyleRock() {
		Player player = new Player("Vasya", PlayerStyle.ONLY_ROCK);
		Set<Decision> decisions = new HashSet<Decision>();
		for (int i = 0; i < 100; i++) {
			player.makeDecision();
			decisions.add(player.getDecision());
		}
		assertTrue(decisions.size() == 1 && decisions.contains(Decision.ROCK));
	}

	@Test
	public void checkStylePaper() {
		Player player = new Player("Vasya", PlayerStyle.ONLY_PAPER);
		Set<Decision> decisions = new HashSet<Decision>();
		for (int i = 0; i < 100; i++) {
			player.makeDecision();
			decisions.add(player.getDecision());
		}
		assertTrue(decisions.size() == 1 && decisions.contains(Decision.PAPER));
	}

	@Test
	public void checkStyleScissors() {
		Player player = new Player("Vasya", PlayerStyle.ONLY_SCISSORS);
		Set<Decision> decisions = new HashSet<Decision>();
		for (int i = 0; i < 100; i++) {
			player.makeDecision();
			decisions.add(player.getDecision());
		}
		assertTrue(decisions.size() == 1 && decisions.contains(Decision.SCISSORS));
	}

	@Test
	public void checkStyleRandom() {
		Player player = new Player("Vasya", PlayerStyle.RANDOM);
		Set<Decision> decisions = new HashSet<Decision>();
		for (int i = 0; i < 100; i++) {
			player.makeDecision();
			decisions.add(player.getDecision());
		}
		assertTrue(decisions.size() > 1);
	}
}
