package blackjack;


public class Game {
	
	public static void main() {
		Player human = new Player(false);
		Player dealer = new Player(true);
		Deck deck = new Deck();
		deck.print_deck();
		deck.shuffle_deck();
		deck.print_deck();
	}

}
