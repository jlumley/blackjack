package blackjack;

import java.util.Scanner;

import blackjack.Card; 

public class Player {
	
	boolean isDealer;
	String name;
	Card[] hand;
	int numberOfCards = 0;
	int points;
	boolean didWin;
	boolean hasAce = false;	

	public Player(boolean isDealer) {
		// TODO Auto-generated constructor stub
		this.isDealer = isDealer;
		if (isDealer) {
			this.name = "Dealer";
		} else {
			this.name = "Player";
		}
		this.hand = new Card [10];
		this.didWin = false;
		
	}
	
	public void calculatePoints() {
		// Adding logic to convert Aces to 1pt
		this.points = 0;
		for (Card card: this.hand) {
			if (card != null) {
				this.points += card.value;
			}
		}
		if (this.points > 21) {
			for (Card card: this.hand) {
				if (card == null) {
					continue;
				} else if (card.value == 11) {
					card.setValue(1);
					this.calculatePoints();
					break;
				}
			}
		}
	}
	
	public boolean blackjackCheck() {
		this.calculatePoints();
		if (this.points == 21 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean didWin(Player opponent) {
	//Return True if current player beat or tied opponent
		if (opponent.points > 21){
			return true;
		} else if (this.points < opponent.points || this.points > 21 ) {
			return false;
		} else if (this.points > opponent.points){
			return true;
		} else {
			return this.isDealer;
		}
	}
	
	public void print_cards(boolean printPoints) {
		System.out.println(this.name + ": ");
		for (Card card: hand) {
			if (card == null) {
				continue;
			}
			if (card.hidden) {
				System.out.print("XX ");
			} else {
			    System.out.print(card.suit + card.name + " ");
			}
		}
		if (printPoints) {
			this.calculatePoints();
			System.out.print(" -> " + Integer.toString(this.points));
		}
		System.out.println();
	}
	
	public boolean decision(Scanner scanner) {
		boolean hit = false;
		this.calculatePoints();

		if (!this.isDealer ) {
			System.out.println("Hit (H) or Stand (S)");
			while (true) {
				String choice = scanner.next();
				if (choice == "") {
					continue;
				}
				if (choice.toUpperCase().charAt(0) == 'H') {
					hit = true;
					break;
				} else if ( choice.toUpperCase().charAt(0) == 'S') {
					hit = false;
					break;
				} else {
					System.out.println("Invalid option given.");
				}
			}
			
		} else {
			// hit on a soft 17
			if (this.points == 17 && this.hasAce || this.points < 17) {
				hit = true;
			} else {
				hit = false;
			}
			
		}
		return hit;
	}
	
	public void addCard(Card card) {
		if (card.name == "A") {
			this.hasAce = true;
		}
		this.hand[numberOfCards] = card;
		this.numberOfCards += 1;
		
		card.checkPlayedCards();
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void setCards(Card[] hand) {
		this.hand = hand;
	}
}


