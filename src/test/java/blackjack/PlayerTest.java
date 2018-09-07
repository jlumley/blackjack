package blackjack;

import junit.framework.TestCase;
import blackjack.Player;;

public class PlayerTest extends TestCase{
	
	public void testWinner() {
		Player human = new Player(false);
		Player dealer = new Player(true);
		
		//Testing if the human won the game
		human.setPoints(21);
		dealer.setPoints(16);
		assertEquals(true, human.didWin(dealer));
		assertEquals(false, dealer.didWin(human));
		
		//Testing if both players get the same score
		human.setPoints(17);
		dealer.setPoints(17);
		assertEquals(true, human.didWin(dealer));
		assertEquals(true, dealer.didWin(human));
		
		//Testing if both players get blackjack
		human.setPoints(21);
		dealer.setPoints(21);
		assertEquals(true, human.didWin(dealer));
		assertEquals(true, dealer.didWin(human));
			
		//Testing if both human busts
		human.setPoints(23);
		dealer.setPoints(16);
		assertEquals(false, human.didWin(dealer));
		assertEquals(true, dealer.didWin(human));
				
	}
	
	public void testCalculatePoints() {
		Player human = new Player(false);
		Card [] hand = new Card[3];
		hand[0] = new Card("H", "A");
		hand[1] = new Card("C", "K");
		hand[2] = new Card("c", "6");
		
		human.setCards(hand);
		human.calculatePoints();
		assertEquals(17, human.points);
		
		
		Player human1 = new Player(false);
		Card [] hand1 = new Card[4];
		hand1[0] = new Card("H", "A");
		hand1[1] = new Card("C", "K");
		hand1[2] = new Card("c", "6");
		hand1[3] = new Card("c", "A");
		
		human1.setCards(hand1);
		human1.calculatePoints();
		assertEquals(18, human1.points);
		
		Player human2 = new Player(false);
		Card [] hand2 = new Card[6];
		hand2[0] = new Card("H", "Q");
		hand2[1] = new Card("C", "K");
		hand2[2] = new Card("c", "6");
		hand2[3] = new Card("c", "J");
		
		human2.setCards(hand2);
		human2.calculatePoints();
		assertEquals(36, human2.points);
		
		Player human3 = new Player(false);
		Card [] hand3 = new Card[6];
		hand3[0] = new Card("H", "K");
		hand3[1] = new Card("C", "A");

		
		human3.setCards(hand3);
		human3.calculatePoints();
		assertEquals(21, human3.points);
	}

}
