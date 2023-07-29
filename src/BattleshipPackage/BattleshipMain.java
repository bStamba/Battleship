package BattleshipPackage;

import java.util.Random;

public class BattleshipMain {

	public static void main(String[] args) {
		
		//Our class instantiation, constant for our array size, and our array itself.
		Battleship b = new Battleship();
		final int boardSize = 7;
		int[] shipLocation = new int[boardSize];
		
		//Use RNG to create the location of the ship within our array and use our setLocationCells method from Battleship class to set up our boats.
		Random rand = new Random();
		int startLocation = rand.nextInt(6);
		b.setLocationCells(startLocation);
		
		//Call our method to start the game now that we have our battleship deployed.
		b.startGame();
		
		//Exit out of the game.
		System.out.println("Thanks for playing!");
		System.exit(0);		
	}
}
