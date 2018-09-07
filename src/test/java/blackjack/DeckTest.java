package blackjack;

import junit.framework.TestCase;

public class DeckTest extends TestCase {
	
	public void testShuffle() {
		Deck deck = new Deck();
		deck.shuffle_deck();
		deck.print_deck();
		
	}

}
