package blackjack;

import junit.framework.TestCase;
import java.util.Scanner;

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
		assertEquals(false, human.didWin(dealer));
		assertEquals(true, dealer.didWin(human));
		
		//Testing if both players get blackjack
		human.setPoints(21);
		dealer.setPoints(21);
		assertEquals(false, human.didWin(dealer));
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
		hand1[0] = new Card("H", "2");
		hand1[1] = new Card("C", "K");
		hand1[2] = new Card("c", "6");
		hand1[3] = new Card("c", "A");
		
		human1.setCards(hand1);
		human1.calculatePoints();
		assertEquals(19, human1.points);
		
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
	
	public void testCheckBlackjack() {
		Player p1 = new Player(false);
		
		Card [] hand1 = new Card[6];
		hand1[0] = new Card("H", "K");
		hand1[1] = new Card("C", "A");

		
		p1.setCards(hand1);
		p1.calculatePoints();
		assertEquals(21, p1.points);
		
		assertEquals(p1.blackjackCheck(), true);
		
		
		
		Player p2 = new Player(false);
		
		Card [] hand2 = new Card[6];
		hand2[0] = new Card("H", "K");
		hand2[1] = new Card("C", "5");

		
		p2.setCards(hand2);
		p2.calculatePoints();
		assertEquals(15, p2.points);
		
		assertEquals(p2.blackjackCheck(), false);
		
	}
	
	public void testDecision() {
		
		Player p1 = new Player(false);
		Player p2 = new Player(true);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("type 'H' when prompted.");
		assertEquals(true, p1.decision(scanner));
		
		System.out.println("type 'S' when prompted.");
		assertEquals(false, p1.decision(scanner));
		
		Card [] hand2 = new Card[6];
		hand2[0] = new Card("H", "K");
		hand2[1] = new Card("C", "6");
		p2.numberOfCards = 2;
		p2.setCards(hand2);
		assertEquals(true, p2.decision(scanner));
		p2.addCard(new Card("S", "A"));
		assertEquals(true, p2.decision(scanner));
		p2.addCard(new Card("S", "2"));
		assertEquals(false, p2.decision(scanner));
		p2.addCard(new Card("S", "10"));
		assertEquals(false, p2.decision(scanner));
		
	}
	
	public void testAddCard() {
		Player p1 = new Player(false);
		Card [] hand = new Card[6];
		hand[0] = new Card("H", "2");
		hand[1] = new Card("C", "6");
		hand[2] = new Card("S", "A");
		p1.numberOfCards = 3;
		p1.setCards(hand);
		p1.calculatePoints();
		
		assertEquals(19, p1.points);
		
		
		Player p2 = new Player(false);
		Card [] hand1 = new Card[6];
		hand1[0] = new Card("H", "K");
		hand1[1] = new Card("C", "6");
		hand1[2] = new Card("S", "A");
		p2.numberOfCards = 3;
		p2.setCards(hand1);
		p2.calculatePoints();
		
		assertEquals(17, p2.points);
		
		Player p3 = new Player(false);
		Card [] hand2 = new Card[6];
		hand2[0] = new Card("H", "A");
		hand2[1] = new Card("C", "A");
		p3.numberOfCards = 3;
		p3.setCards(hand2);
		p3.calculatePoints();
		
		assertEquals(12, p3.points);
		
		
	}

	public void testDealingCards() {
		Deck deck = new Deck();
		Player p1 = new Player(false);
		Player p2 = new Player(true);
		
		deck.deal(p1, p2);
		
		p1.calculatePoints();
		p2.calculatePoints();
		assertEquals(14, p1.points);
		assertEquals(6, p2.points);
		
		p1.print_cards(false);
		p2.print_cards(true);
	}
	
}
