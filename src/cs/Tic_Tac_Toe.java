package cs;

import java.util.*;

public class Tic_Tac_Toe {
	private Scanner scan;
	private char[][] board;
	private int[][] playerRows;
	private int[][] playerCol;
	private int[][] playerDia;
	private int turnNumber;

	public Tic_Tac_Toe() {
		board = new char[3][3];
		for(char[] c: board)
			Arrays.fill(c, ' ');
		playerRows = new int[2][3];
		playerCol = new int[2][3];
		playerDia = new int [2][2];
		turnNumber = 0;
		scan = new Scanner(System.in);
	}

	public void play() {
		printBoard();
		while (turnNumber < 9) {
			updateBoard();
			printBoard();
			if(hasWinner()) {
				
				return;
			}
				
		}

	}
	//updates the board after every turn
	public void updateBoard() {
		//checks who's turn it is
		if(turnNumber % 2 == 0){
			System.out.print("Player 1 enter a empty row and column seperated by a comma");
		}
		else {
			System.out.print("Player 2 enter a empty row and column seperated by a comma");
		}
		try{
			//get input and turns them into rows and columns
			String s = scan.nextLine().trim();
			String[] index = s.split(",");
			//converts String input to usable index
			int row = Integer.parseInt(index[0].trim())-1;
			int col = Integer.parseInt(index[1].trim())-1;
			//checks if valid
			if(row<0 || row>2 || col < 0 || col > 2) {
				System.out.println("not a valid index");
				updateBoard();
			}
			if(board[row][col] != ' ') {
				System.out.println("not a valid index");
				updateBoard();
			}
			//updates
			if(turnNumber % 2 == 0)
				board[row][col] = 'X';
			else
				board[row][col] = 'O';
			boolean isDia = false;
			if((row == 0 && col == 0)||(row == 0 && col == 2)||(row == 1 && col == 1)||(row == 2 && col == 0)||(row == 2 && col == 2)) {
				isDia = true;
			}
			playerRows[turnNumber % 2][row]++;
			playerRows[turnNumber % 2][col]++;
			if(isDia)
				
				
		
		}
		//in case any user error
		catch(Exception e) {
			System.out.println("not a valid index");
			updateBoard();
		}
		

	}
	//prints board
	public void printBoard() {
		for(char[] c: board) {
			System.out.println(Arrays.toString(c));
		/*for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					System.out.print(" ");
				} else {
					System.out.print(board[i][j]);
				}
				if (j < board[i].length - 1) {
					System.out.print("|");
				}

			}
			System.out.println();
			if (i < board.length - 1)
				System.out.println("-----");*/
		}
	}

	public boolean hasWinner() {

	}

}
