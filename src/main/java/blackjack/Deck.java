package blackjack;

import java.util.Random;

public class Deck {
	
	Card [] deckList;
	int top = 0;
	
	public Deck() {
		// TODO Auto-generated constructor stub
		this.deckList = new Card[52];
		String [] suits = {"S", "H", "D", "C"};
		String [] names = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		int i = 0;
		for (String suit: suits) {
			for (String name: names) {
				Card newCard = new Card(suit, name);
				this.deckList[i] = newCard;
				i ++;
			}
		}
	}
	
	public void print_deck() {
		for (Card card: this.deckList) {
			System.out.println(card.name + " " + card.suit);
		}
	}

	public void shuffle_deck() {
		Random random = new Random();
		Card temp;
		for (int i=0; i<52; i++) {
			int randomIndex = random.nextInt(51);
			temp = this.deckList[randomIndex];
			this.deckList[randomIndex] = this.deckList[i];
			this.deckList[i] = temp;
		}
		
	}
	
	public void deal(Player human, Player dealer) {
		human.addCard(this.deckList[this.top]);
		this.top++;
		dealer.addCard(this.deckList[this.top]);
		this.deckList[this.top].setHiddenStatus(true);
		this.top++;
		human.addCard(this.deckList[this.top]);
		this.top++;
		dealer.addCard(this.deckList[this.top]);
		this.top++;
			
	}
	
}
