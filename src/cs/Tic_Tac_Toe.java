package cs;

import java.util.*;

public class Tic_Tac_Toe {
	private Scanner scan;
	private char[][] board;
	private int[][] playerRows;
	private int[][] playerCol;
	private int[][] playerDia;
	private int turnNumber;
	boolean hasWinner;

	public Tic_Tac_Toe() {
		board = new char[3][3];
		for (char[] c : board)
			Arrays.fill(c, ' ');
		playerRows = new int[2][3];
		playerCol = new int[2][3];
		playerDia = new int[2][2];
		turnNumber = 0;
		scan = new Scanner(System.in);
		hasWinner = false;
		play();
	}

	/**
	 * 
	 */
	public void play() {
		printBoard();
		while (turnNumber < 9) {

			updateBoard();
			printBoard();
			if (hasWinner) {

				return;
			}
			turnNumber++;
		}
		System.out.println("It's a tie");

	}

	/**
	 * updates the board after every turn
	 */
	public void updateBoard() {
		// checks who's turn it is
		int playerNum = turnNumber % 2;
		System.out.print("<Player" + (playerNum+1) + "> Enter a empty cell (row, col): ");
		
		try {
			// get input and turns them into rows and columns
			String s = scan.nextLine().trim();
			String[] index = s.split(",");
			// converts String input to usable index
			int row = Integer.parseInt(index[0].trim()) - 1;
			int col = Integer.parseInt(index[1].trim()) - 1;
			// checks if valid
			if (row < 0 || row > 2 || col < 0 || col > 2) {
				System.err.println("Not a valid index. Enter row/col in range 1 to 3.");
				updateBoard();
			}
			if (board[row][col] != ' ') {
				System.err.println("Cell not empty. Try again");
				updateBoard();
			}
			// updates
			if (playerNum == 0)
				board[row][col] = 'X';
			else
				board[row][col] = 'O';

			playerRows[playerNum][row]++;
			playerCol[playerNum][col]++;
			if (row == col) {
				playerDia[playerNum][0]++;
			}
			if (row + col == 2) {
				playerDia[playerNum][1]++;
			}
			
			//check if we have winner
			if (playerRows[playerNum][row] == 3 || playerCol[playerNum][col] == 3 || playerDia[playerNum][0] == 3
					|| playerDia[playerNum][1] == 3) {
				System.out.println("Player "+(playerNum + 1) + " is the winner");
				hasWinner = true;
			}

		}
		// in case any user error
		catch (Exception e) {
			System.err.println("Not a valid index");
			updateBoard();
		}

	}

	// prints board
	public void printBoard() {
		for (char[] c : board) {
			System.out.println(Arrays.toString(c));
		}
		
	}

}
