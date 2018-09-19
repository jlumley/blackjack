package blackjack;


public class Card {
	
	String suit;
	String name;
	int value;
	boolean hidden = false;
	
	public Card(String suit, String name) {
		// TODO Auto-generated constructor stub
		this.suit = suit;
		this.name = name;
		this.value = this.setValue();
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
