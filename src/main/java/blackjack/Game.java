package blackjack;

import java.io.*;
import java.util.Scanner;

public class Game {
	
	 
	public static String playGame(Player human, 
								Player dealer, 
								boolean fileInput, 
								String[] fileData,
								Scanner scanner) {
		Deck deck = new Deck();
		int arrayLocation = 0;
		if (fileInput) {
			for (int i=0; i<4; i++) {
				if (i<2) {
					human.addCard(new Card(Character.toString(fileData[i].charAt(0)), 
										   fileData[arrayLocation].substring(1)));
					arrayLocation += 1;
				} else {
					dealer.addCard(new Card(Character.toString(fileData[i].charAt(0)),
											fileData[arrayLocation].substring(1)));
					arrayLocation += 1;
				}
			}
			
		} else {
			
			deck.shuffle_deck();
			deck.deal(human, dealer);
		}
		dealer.print_cards(false);
		human.print_cards(false);
		if (!human.blackjackCheck() || !dealer.blackjackCheck()) {
			
			while (true) {
				boolean hit = false;
				
				if(fileInput) {
					if (fileData[arrayLocation].charAt(0) == 'H') {
						hit = true;
					} else {
						hit = false;	
					}
					arrayLocation += 1;
				} else {
					hit = human.decision(scanner);
				}
				if (hit) {
					if (fileInput) {
						human.addCard(new Card(Character.toString(fileData[arrayLocation].charAt(0)), 
											   fileData[arrayLocation].substring(1)));
						arrayLocation += 1;
					} else {
						human.addCard(deck.deckList[deck.top]);
						deck.top++;
					}
					human.print_cards(false);
					human.calculatePoints();
					if (human.points > 21) {
						break;
					}
				} else {
					human.print_cards(false);
					break;
				}
			}
			while (true) { 
				boolean hit = dealer.decision(scanner);
				dealer.hand[0].setHiddenStatus(false);
				if (hit && human.points < 21) {
					if (fileInput) {
						dealer.addCard(new Card(Character.toString(fileData[arrayLocation].charAt(0)), 
											    fileData[arrayLocation].substring(1)));
						arrayLocation += 1;
						
					} else {
						dealer.addCard(deck.deckList[deck.top]);
						deck.top++;
					}
					dealer.print_cards(false);
					dealer.calculatePoints();
					if (dealer.points > 21) {
						break;
					}
				} else {
					dealer.print_cards(false);
					break;
				}
			}
		}
		System.out.println();
		human.print_cards(true);
		dealer.print_cards(true);
		if (dealer.didWin(human)) {
			System.out.println("Dealer Won.");
			return "dealer won";
		} else {
			System.out.println("Player Won.");
			return "player won";
		}	
	}

	
	public static void main(String[] args) {
		Player human = new Player(false);
		Player dealer = new Player(true);
		Scanner scanner = new Scanner(System.in);
			
		System.out.println("console (c) or file (f) input");
		String gameMode = scanner.next();
		
		if (gameMode.toLowerCase().charAt(0) == 'c') {
			System.out.println("Playing in Console mode.");
			playGame(human, dealer, false, new String[10], scanner);
			
		} else if (gameMode.toLowerCase().charAt(0) == 'f') {
			System.out.println("Playing in File mode.");
			System.out.println("Speficy a file to open");
			String filePath = scanner.next();
			try {
				Scanner inputfile = new Scanner(new File(filePath));
				while (inputfile.hasNextLine()) {
					String fileData = inputfile.nextLine();
					String[] fileDataArray = fileData.split("\\s+");
					playGame(human, dealer, true, fileDataArray, scanner);
				}
				inputfile.close();
			} catch (Exception e) {
				System.out.println(e);
			}	
			
		} else {
			System.out.println("Invalid option given.");
			System.exit(0);
		}
		scanner.close();
	}
}