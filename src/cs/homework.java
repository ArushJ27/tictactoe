package cs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class homework {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Tic_Tac_Toe> t = new ArrayList<Tic_Tac_Toe>();
	static String FILE_PATH = "c:\\users\\arush\\tic_tac_toe.txt";

	public static void main(String[] args) throws IOException {
		//read the file and populate t
		readFile();
		
		play();
		
		//write the t back to the file
		writeFile();
	}

	private static void readFile() throws IOException {
		Path filePath = Path.of(FILE_PATH);
		Files.lines(filePath).skip(1).forEach(l -> processLine(l));
		
	}

	private static void processLine(String line) {
		t.add(new Tic_Tac_Toe(line));
	}

	private static void writeFile() throws IOException {
		Path filePath = Path.of(FILE_PATH);
		Files.deleteIfExists(filePath);
		String str = "File created on " + java.time.LocalDate.now() + "\n";
		Files.write(filePath, str.getBytes(), StandardOpenOption.CREATE_NEW);
		for(Tic_Tac_Toe e: t) {
			String content = e.getSteps()+ "\n";
			Files.write(filePath, content.getBytes(), StandardOpenOption.APPEND);
		}

		
		
	}

	public static void gameReview() {
		System.out.print("Review a game?(y/n):");
		String s = scan.nextLine().trim();
		if (s.equalsIgnoreCase("y")) {
			System.out.print("Game number?:");
			int gameNum = (Integer.parseInt(scan.nextLine()) - 1);
			t.get(gameNum).boardReview();
		} else if (s.equalsIgnoreCase("n")) {
			playAgain();
		} else {
			System.err.println("Invalid input");
			gameReview();

		}

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
		t.add(new Tic_Tac_Toe());
		gameReview();
		playAgain();
	}

}
