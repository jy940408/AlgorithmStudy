package JAVABruteForce;

import java.util.Scanner;

public class 오목 {

	static int[][] board = new int[19][19];
	static int black, white, wRow, wCol, bRow, bCol = 0;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0 ; i < 19 ; i++) {
			String[] line = (scan.nextLine()).split(" ");
			for(int j = 0 ; j < 19 ; j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		scan.close();
		
		for(int i = 0 ; i < 19 ; i++) {
			for(int j = 0 ; j < 19 ; j++) {
				if(board[i][j] != 0) {
					check(i, j);
				}
			}
		}
		
		result();
		
	}

	public static void check(int i, int j) {
		
//		세로 확인
		if(validCheck(i,j, "col")) {
			for(int k = 0 ; k < 5 ; k++) {
				if(board[i][j] != board[i+k][j]) {
					break;
				}else if(board[i][j] == board[i+k][j] && k == 4) {
					if(overSixCheck(i, j, "col") == 1) {
						if(board[i][j] != board[i-1][j]) {
							if(board[i][j] == 1) {
								bCol = i;
								bRow = j;
								black += 1;
							}else {
								wCol = i;
								wRow = j;
								white += 1;
							}
						}
					}else if(overSixCheck(i, j, "col") == 0) {
						if(board[i][j] != board[i+5][j]) {
							if(board[i][j] == 1) {
								bCol = i;
								bRow = j;
								black += 1;
							}else {
								wCol = i;
								wRow = j;
								white += 1;
							}
						}
					}else if(overSixCheck(i, j, "col") == -1) {
						if(board[i][j] != board[i+5][j] && board[i][j] != board[i-1][j]) {
							if(board[i][j] == 1) {
								bCol = i;
								bRow = j;
								black += 1;
							}else {
								wCol = i;
								wRow = j;
								white += 1;
							}
						}
					}
					
				}
			}
		}
		
//		가로 확인
		if(validCheck(i,j, "row")) {
			for(int k = 0 ; k < 5 ; k++) {
				if(board[i][j] != board[i][j+k]) {
					break;
				}else if(board[i][j] == board[i][j+k] && k == 4) {
					if(overSixCheck(i, j, "row") == 1) {
						if(board[i][j] != board[i][j-1]) {
							if(board[i][j] == 1) {
								bCol = i;
								bRow = j;
								black += 1;
							}else {
								wCol = i;
								wRow = j;
								white += 1;
							}
						}
					}else if(overSixCheck(i, j, "row") == 0) {
						if(board[i][j] != board[i][j+5]) {
							if(board[i][j] == 1) {
								bCol = i;
								bRow = j;
								black += 1;
							}else {
								wCol = i;
								wRow = j;
								white += 1;
							}
						}
					}else if(overSixCheck(i, j, "row") == -1) {
						if(board[i][j] != board[i][j+5] && board[i][j] != board[i][j-1]) {
							if(board[i][j] == 1) {
								bCol = i;
								bRow = j;
								black += 1;
							}else {
								wCol = i;
								wRow = j;
								white += 1;
							}
						}
					}
					
				}
			}
		}
		
//		우하 대각 확인
		if(validCheck(i,j, "rightDown")) {
			for(int k = 0 ; k < 5 ; k++) {
				if(board[i][j] != board[i+k][j+k]) {
					break;
				}else if(board[i][j] == board[i+k][j+k] && k == 4) {
					if(overSixCheck(i, j, "rightDown") == 1) {
						if(board[i][j] != board[i-1][j-1]) {
							if(board[i][j] == 1) {
								bCol = i;
								bRow = j;
								black += 1;
							}else {
								wCol = i;
								wRow = j;
								white += 1;
							}
						}
					}else if(overSixCheck(i, j, "rightDown") == 0) {
						if(board[i][j] != board[i+5][j+5]) {
							if(board[i][j] == 1) {
								bCol = i;
								bRow = j;
								black += 1;
							}else {
								wCol = i;
								wRow = j;
								white += 1;
							}
						}
					}else if(overSixCheck(i, j, "rightDown") == -1) {
						if(board[i][j] != board[i+5][j+5] && board[i][j] != board[i-1][j-1]) {
							if(board[i][j] == 1) {
								bCol = i;
								bRow = j;
								black += 1;
							}else {
								wCol = i;
								wRow = j;
								white += 1;
							}
						}
					}else if(overSixCheck(i, j, "rightDown") == 2) {
						if(board[i][j] == 1) {
							bCol = i;
							bRow = j;
							black += 1;
						}else {
							wCol = i;
							wRow = j;
							white += 1;
						}
					}
					
				}
			}
		}
		
//		우상 대각 확인
		if(validCheck(i,j, "rightUp")) {
			for(int k = 0 ; k < 5 ; k++) {
				if(board[i][j] != board[i-k][j+k]) {
					break;
				}else if(board[i][j] == board[i-k][j+k] && k == 4) {
					if(overSixCheck(i, j, "rightUp") == 0) {
						if(board[i][j] != board[i+1][j-1]) {
							if(board[i][j] == 1) {
								bCol = i;
								bRow = j;
								black += 1;
							}else {
								wCol = i;
								wRow = j;
								white += 1;
							}
						}
					}else if(overSixCheck(i, j, "rightUp") == 1) {
						if(board[i][j] != board[i-5][j+5]) {
							if(board[i][j] == 1) {
								bCol = i;
								bRow = j;
								black += 1;
							}else {
								wCol = i;
								wRow = j;
								white += 1;
							}
						}
					}else if(overSixCheck(i, j, "rightUp") == -1) {
						if(board[i][j] != board[i-5][j+5] && board[i][j] != board[i+1][j-1]) {
							if(board[i][j] == 1) {
								bCol = i;
								bRow = j;
								black += 1;
							}else {
								wCol = i;
								wRow = j;
								white += 1;
							}
						}
					}else if(overSixCheck(i, j, "rightUp") == 2) {
						if(board[i][j] == 1) {
							bCol = i;
							bRow = j;
							black += 1;
						}else {
							wCol = i;
							wRow = j;
							white += 1;
						}
					}
					
				}
			}
		}
	}
	
	public static boolean validCheck(int i, int j, String direction) {
		
		if(direction.equals("col")) {
			if((i+4) <= 18) {
				return true;
			}
		}else if(direction.equals("row")) {
			if((j+4) <= 18) {
				return true;
			}
		}else if(direction.equals("rightDown")) {
			if((i+4) <= 18 && (j+4) <= 18) {
				return true;
			}
		}else if(direction.equals("rightUp")) {
			if((i-4) >= 0 && (j+4) <= 18) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public static int overSixCheck(int i, int j, String direction) {
//		1 -> 뒤를 확인해봐야한다
//		0 -> 앞을 확인해봐야한다
//		-1 -> 둘 다 확인해봐야한다
//		2 -> 둘 다 확인할 필요 없다
		if(direction.equals("col")) {
			if((i+4) == 18) {
				return 1;
			}else if(i == 0) {
				return 0;
			}else {
				return -1;
			}
		}else if(direction.equals("row")) {
			if((j+4) == 18) {
				return 1;
			}else if(j == 0) {
				return 0;
			}else {
				return -1;
			}
		}else if(direction.equals("rightDown")) {
			if(((i+4) == 18 && j == 0) || ((j+4) == 18 && i == 0)) {
				return 2;
			}else if((i == 0 && (j+4) < 18 ) || (j == 0 && (i+4) < 18)) {
				return 0;
			}else if(((i+4) == 18 && j > 0) || ((j+4) == 18) && i > 0) {
				return 1;
			}else {
				return -1;
			}
		}else if(direction.equals("rightUp")) {
			if(((j+4) == 18 && i == 18) || ((i == 4 && j == 0))) {
				return 2;
			}if((i == 4 && j > 0) || ((j+4) == 18 && i < 18)) {
				return 0;
			}else if((i == 18 && (j+4) < 18) || (j == 0 && i > 4)) {
				return 1;
			}else {
				return -1;
			}
		}
		
		return 1;
		
	}
	
	public static void result() {
		if(black == 1 && white%2 == 0) {
			
			System.out.println(1 + "\n" + (bCol+1) + " " + (bRow+1));
			
		}else if(white == 1 && black%2 == 0) {
			
			System.out.println(2 + "\n" + (wCol+1) + " " + (wRow+1));
			
		}else {
			
			System.out.println(0);
			
		}
	}
	
}
