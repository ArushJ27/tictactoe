package cs;

import java.util.*;

public class homework {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		play();
	}

	public static void playAgain() {
		System.out.print("Play again?(y/n):");
		String s = scan.nextLine().trim();
		if (s.equalsIgnoreCase("y")) {
			play();
		} else if (s.equalsIgnoreCase("n")) {
			System.out.println("Thanks for playing");
		} else {
			System.err.println("Invalid input");
			playAgain();

		}

	}

	private static void play() {
		Tic_Tac_Toe t = new Tic_Tac_Toe();
		playAgain();
	}

}
