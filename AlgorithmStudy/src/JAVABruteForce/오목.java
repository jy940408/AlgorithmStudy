package JAVABruteForce;

import java.util.ArrayList;
import java.util.Scanner;

public class 오목 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[][] board = new int[19][19];
		int black, white = 0;
		
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
				
				
				
			}
		}
		

	}

}
