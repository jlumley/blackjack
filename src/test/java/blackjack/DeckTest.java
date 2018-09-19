package blackjack;

import junit.framework.TestCase;

public class DeckTest extends TestCase {
	
	public void testShuffle() {
		Deck deck = new Deck();
		Deck deck2 = new Deck();
		deck.shuffle_deck();
		// Deck is shuffled if 10%
		// of the cards are in the same location
		int unmovedCards = 0;
		for (int i=0; i<52; i++) {
			if (deck.deckList[i].name == deck2.deckList[i].name &&
				deck.deckList[i].suit == deck2.deckList[i].suit) {
				
				unmovedCards ++;
			}
		}
		
		assertEquals(true, unmovedCards < 5);
		
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
	
	public void testNumberOfCards() {
		Deck deck = new Deck();
		int count = 0;
		
		for (Card card: deck.deckList) {
			if (card != null) {
				count ++;
			}
		}
		assertEquals(52, count);
	}

}
