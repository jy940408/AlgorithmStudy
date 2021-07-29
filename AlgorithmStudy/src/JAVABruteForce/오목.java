package JAVABruteForce;

import java.util.ArrayList;
import java.util.Scanner;

public class 오목 {

	static int[][] board = new int[19][19];
	static int black, white, row, col = 0;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList test = new ArrayList();
		
		for(int i = 0 ; i < 19 ; i++) {
			String[] line = (scan.nextLine()).split(" ");
			for(int j = 0 ; j < 19 ; j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for(int i = 0 ; i < 19 ; i++) {
			String testString = "";
			for(int j = 0 ; j < 19 ; j++) {
				testString += Integer.toString(board[i][j]) + " ";
				if(j == 18) {
					test.add(testString);
				}
			}
			System.out.println(test.get(i));
		}
		
		scan.close();
		
		for(int i = 0 ; i < 19 ; i++) {
			for(int j = 0 ; j < 19 ; j++) {
				if(board[i][j] != 0) {
					check(i, j);
				}
			}
		}
		
		System.out.println("black: " + black + ", white: " + white + ", row: " + row + ", col: " + col);
		
		result();
		
	}

	public static void check(int i, int j) {
		
//		가로 확인
		if(validCheck(i,j+4)) {
			
			for(int k = 0 ; k < 5 ; k++) {
				if(board[i][j] != board[i][j+k]) {
					break;
				}else if(board[i][j] == board[i][j+k] && k == 4){
					if(validCheck(i, j-1)) {
						
					}
				}
			}
			
		}
		
//		세로 확인
		if(validCheck(i+4,j)) {
			
			for(int k = 0 ; k < 5 ; k++) {
				if(board[i][j] != board[i][j+k]) {
					break;
				}else if(board[i][j] == board[i][j+k] && k == 4){
					if(validCheck(i, j-1)) {
						
					}
				}
			}
			
		}
		
//		우하 대각 확인
		if(validCheck(i+4,j+4)) {
			
		}
		
//		우상 대각 확인
		if(validCheck(i-4,j+4)) {
			
		}
	}
	
	public static boolean validCheck(int i, int j) {
		
		if(i <= 0 || i >= 18 || j <= 0 || j >= 18) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public static void result() {
		if(black == 1 && white < 1) {
			
			System.out.println(black + "\n" + (col+1) + " " + (row+1));
			
		}else if(white == 1 && black < 1) {
			
			System.out.println(white + "\n" + (col+1) + " " + (row+1));
			
		}else {
			
			System.out.println(0);
			
		}
	}
	
}
