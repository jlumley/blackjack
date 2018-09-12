package blackjack;

import junit.framework.TestCase;

public class DeckTest extends TestCase {
	
	public void testShuffle() {
		Deck deck = new Deck();
		deck.shuffle_deck();
		deck.print_deck();
		
		
	}
	
	public void testDeal() {
		Deck deck = new Deck();
		Player p1 = new Player(false);
		Player p2 = new Player(true);
		
		deck.deal(p1, p2);
		
		assertEquals(p1.hand[0].suit, "S");
		assertEquals(p2.hand[0].suit, "S");
		assertEquals(p1.hand[0].name, "A");
		assertEquals(p1.hand[1].name, "3");
	}

}
