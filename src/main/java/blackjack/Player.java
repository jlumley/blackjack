package blackjack;

import blackjack.Card; 

public class Player {
	
	boolean isDealer;
	Card[] hand;
	int points;
	boolean didWin;
	
	

	public Player(boolean isDealer) {
		// TODO Auto-generated constructor stub
		this.isDealer = isDealer;
		
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
				}
			}
		}
	}
	
	public boolean didWin(Player opponent) {
	//Return True if current player beat or tied opponent
		if (opponent.points > 21){
			return true;
		} else if (this.points < opponent.points || this.points > 21 ) {
			return false;
		} else {
			return true;
		}
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void setCards(Card[] hand) {
		this.hand = hand;
	}
}
