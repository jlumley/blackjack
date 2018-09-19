package blackjack;

import junit.framework.TestCase;

public class CardTest extends TestCase{
	
	public void testSetValue() {
		Card c1 = new Card("S", "A");
		Card c2 = new Card("S", "K");
		Card c3 = new Card("S", "3");
		Card c4 = new Card("S", "J");
		Card c5 = new Card("S", "10");
		
		assertEquals(c1.value, 11);
		assertEquals(c2.value, 10);
		assertEquals(c3.value, 3);
		assertEquals(c4.value, 10);
		assertEquals(c5.value, 10);
		
		
	}

}
