package BattleshipPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Battleship {

	private final int rowSize = 7;
	private int[] locationCells = new int[rowSize];
	private int hitCounter = 0;
	
	//Method to start our game, creates a scanner to get user input and checks our user guess vs. battleship location.
	public void startGame() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Battleship!");
		
		//Run the game until we have sunk the battleship (which requires 3 hits).
		while(hitCounter < 3) {
			System.out.println("Please enter in your guess on the location of the battleship using numbers 0-6.");
			String guess = scanner.next();
			checkGuess(Integer.valueOf(guess));
		}		
		System.out.println("");
		System.out.println("You sank the battleship, GG!");
		scanner.close();
	}
	
	//Set location of our battleship using the random number starting location.
	//If the number is too high to fit into our elements by incrementing, decrement from the starting location instead.
	public void setLocationCells(int location) {
		if(location >= locationCells.length - 2) {
			for(int k = 0; k <= 2; k++) {
				locationCells[location] = 1;
				location = location - 1;
			}
		}
		else {
			for(int k = 0; k <= 2; k++) {
				locationCells[location] = 1;
				location = location + 1;
			}
		}
	}
	
	//Check our guess by seeing if the element is equal to 0, which means no battleship is there, or 1 which means we hit a battleship.
	//If a battleship is hit, change the value of the location to 0.
	public boolean checkGuess(int guess) {
		if(locationCells[guess] == 0) {
			System.out.println("Miss!");
			return false;
		}
		else {
			System.out.println("Direct Hit!");
			hitCounter = hitCounter + 1;
			locationCells[guess] = 0;
			return true;
		}
	}
}
