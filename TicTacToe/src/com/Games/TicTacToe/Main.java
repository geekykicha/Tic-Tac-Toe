package com.Games.TicTacToe;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// create 3 * 3 board with array
		char[][] board = new char[3][3];
		
		// initially board is empty
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' '; 
			}
		}
		
		// first move on the board
		char player = 'X';
		boolean gameOver = false;
		Scanner scanner = new Scanner(System.in); // to get input from user
		
		// this loop executing until board gets empty 
		while(!gameOver) {
			printBoard(board);
			System.out.println("player " + player + " enter: (with postions of rows & cols):---");
			
		// to add X or O with index val coordinates respect to rows & cols
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			System.out.println();
			
			if (board[row][col] == ' ') {
				board[row][col] = player; // place the element
				gameOver = haveWon(board, player);
				
				// to terminate the moves
				if(gameOver) {
					System.out.println("player " + player + " has won: ");
				}
				else {
					// shorten form of if with ternary operator 
					player = (player == 'X') ? 'O' : 'X';
				}
			} 
			else {
				System.out.println("Invalid move. Try agian!");
			}
		}
		printBoard(board);
	}

	public static boolean haveWon(char[][] board, char player) {
		// check the rows
		for (int row =0; row < board.length; row++) {
			if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
		}
		
		// check the col
		for (int col =0; col < board[0].length; col++) {
			if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
				return true;
			}
		}
		
		// diagonal
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		return false;
	}

	public static void printBoard(char[][] board) {
		
		// to create each row after every move
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + " |");
			}
			System.out.println();
		}
	}

}
