package blackjack;

import java.util.Scanner;

import junit.framework.TestCase;

public class GameTest extends TestCase {
	
	public void testPlayGameWithFileInput() {
		Player p1 = new Player(false);
		Player p2 = new Player(true);
		Scanner scanner = new Scanner(System.in);
		
		String[] fileData = {"SQ", "S10", "S9", "S3", "S", "S4", "S3"};
		
		assertEquals("player won", Game.playGame(p1, p2, true, fileData, scanner));
		
		
		String[] fileData1 = {"SQ", "S10", "S9", "S3", "S", "S4", "S5"};
		p1 = new Player(false);
		p2 = new Player(true);
		
		assertEquals("dealer won", Game.playGame(p1, p2, true, fileData1, scanner));
		
		String[] fileData2 = {"S10", "D3", "SQ", "C5", "H", "H5", "H", "SA", "S", "CA", "D2"};
		p1 = new Player(false);
		p2 = new Player(true);
		
		assertEquals("player won", Game.playGame(p1, p2, true, fileData2, scanner));
		
	}

}
