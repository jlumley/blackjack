package blackjack;

import java.util.*;

public class Card {
	
	String suit;
	String name;
	int value;
	boolean hidden = false;
	static Set<String> playedCards = new HashSet<String>();
	
	
	public Card(String suit, String name) {
		// TODO Auto-generated constructor stub
		this.suit = suit;
		this.name = name;
		this.value = this.setValue();
		this.verifyCard();
		
	}

	private void verifyCard() {
		Set<String> validSuits = new HashSet<String>();
		validSuits.add("H");
		validSuits.add("D");
		validSuits.add("S");
		validSuits.add("C");
		
		if (!validSuits.contains(this.suit)) {
			System.out.println("Invalid Card");
			System.exit(1);
		}
		
		String[] validNamesList = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		Set<String> validNames = new HashSet<String>();
		
		for (String s: validNamesList) {
			validNames.add(s);
		}
		
		if (!validNames.contains(this.name)) {
			System.out.println("Invalid Card");
			System.exit(1);
		}
		
	}
	
	public void checkPlayedCards() {
		String cardString = this.suit + this.name;
		if (Card.playedCards.contains(cardString)) {
			System.out.println("This card has already been played");
			System.exit(1);
		} else {
			Card.playedCards.add(cardString);
		}
	}
	
	public int setValue() {
		
		String[] faceCards = {"J", "Q", "K"};
		for (String face: faceCards) {
			if (this.name.equals(face)) {
				return 10;
			}
		}
		if (this.name.equals("A")) {
			return 11;
		}
		return Integer.parseInt(this.name);
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void setHiddenStatus(boolean hidden) {
		this.hidden = hidden;
	}
}
