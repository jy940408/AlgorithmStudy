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
		
		if(i < 15) {
			for(int k = 0 ; k < 5 ; k++) {
	//			세로 확인
				if(board[i][j] != board[i+k][j]) {
					break;
				}else if(board[i][j] == board[i+k][j] && k == 4) {
					if(i == 0) {
						if(board[i+k][j] != board[i+k+1][j]) {
							row = i;
							col = j;
							if(board[i][j] == 1) {
								black++;
							}else {
								white++;
							}
						}else{
							break;
						}
					}else if(i < 14 && i > 0) {
						if(board[i][j] != board[i-1][j]) {
							if(board[i+k][j] != board[i+k+1][j]) {
								row = i;
								col = j;
								if(board[i][j] == 1) {
									black++;
								}else {
									white++;
								}
							}else{
								break;
							}
						}
					}else if(i == 14) {
						if(board[i][j] != board[i-1][j]) {
							row = i;
							col = j;
							if(board[i][j] == 1) {
								black++;
							}else {
								white++;
							}
						}
					}
				}
			}
		}
			
		if(j < 15) {
			for(int k = 0 ; k < 5 ; k++) {
	//			가로 확인
				if(board[i][j] != board[i][j+k]) {
					break;
				}else if(board[i][j] == board[i][j+k] && k == 4) {
					if(j == 0) {
						if(board[i][j+k] != board[i][j+k+1]) {
							row = i;
							col = j;
							if(board[i][j] == 1) {
								black++;
							}else {
								white++;
							}
						}else{
							break;
						}
					}else if(j < 14 && j > 0) {
						if(board[i][j] != board[i][j-1]) {
							if(board[i][j+k] != board[i][j+k+1]) {
								row = i;
								col = j;
								if(board[i][j] == 1) {
									black++;
								}else {
									white++;
								}
							}else{
								break;
							}
						}
					}else if(j == 14) {
						if(board[i][j] != board[i][j-1]) {
							row = i;
							col = j;
							if(board[i][j] == 1) {
								black++;
							}else {
								white++;
							}
						}
					}
				}
			}
		}
		
		if(i < 15 && j < 15) {
			for(int k = 0 ; k < 5 ; k++) {
	//			우하 대각 확인
				if(board[i][j] != board[i+k][j+k]) {
					break;
				}else if(board[i][j] == board[i+k][j+k] && k == 4) {
					if(i == 0 && j == 0) {
						if(board[i+k][j+k] != board[i+k+1][j+k+1]) {
							row = i;
							col = j;
							if(board[i][j] == 1) {
								black++;
							}else {
								white++;
							}
						}else{
							break;
						}
					}else if(i < 14 && j < 14 && i > 0 && j > 0) {
						if(board[i][j] != board[i-1][j-1]) {
							if(board[i+k][j+k] != board[i+k+1][j+k+1]) {
								row = i;
								col = j;
								if(board[i][j] == 1) {
									black++;
								}else {
									white++;
								}
							}else{
								break;
							}
						}
					}else if(i == 14 && j == 14) {
						if(board[i][j] != board[i-1][j-1]) {
							row = i;
							col = j;
							if(board[i][j] == 1) {
								black++;
							}else {
								white++;
							}
						}
					}
				}
			}
		}

		
		if(i > 3 && j < 15) {
			for(int k = 0 ; k < 5 ; k++) {
	//			우상 대각 확인
				if(board[i][j] != board[i-k][j+k]) {
					break;
				}else if(board[i][j] == board[i-k][j+k] && k == 4) {
					if(j < 14 && i == 18) {
						if(board[i-k][j+k] != board[i-k-1][j+k+1]) {
							row = i;
							col = j;
							if(board[i][j] == 1) {
								black++;
							}else {
								white++;
							}
						}else{
							break;
						}
					}else if(i < 18 && j > 0 && j < 14) {
						if(board[i][j] != board[i+1][j-1]) {
							if(board[i-k][j+k] != board[i-k-1][j+k+1]) {
								row = i;
								col = j;
								if(board[i][j] == 1) {
									black++;
								}else {
									white++;
								}
							}else if(i == 4 && j == 14) {
								row = i;
								col = j;
								if(board[i][j] == 1) {
									black++;
								}else {
									white++;
								}
							}else{
								break;
							}
						}
					}else if(i < 18 && j == 0) {
						
					}
				}
			}
		}
		
	}
	
	public static void result() {
		if(black == 1 && white < 1) {
			
			System.out.println(black + "\n" + (row+1) + " " + (col+1));
			
		}else if(white == 1 && black < 1) {
			
			System.out.println(white + "\n" + (row+1) + " " + (col+1));
			
		}else {
			
			System.out.println(0);
			
		}
	}
	
}
