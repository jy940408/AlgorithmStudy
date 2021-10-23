package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 로봇청소기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int count = 0;
	static int column;
	static int row;
	static int direction;
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int height = Integer.parseInt(firstLine[0]);
		int width = Integer.parseInt(firstLine[1]);
		String[] secondLine = (br.readLine()).split(" ");
		column = Integer.parseInt(secondLine[0]);
		row = Integer.parseInt(secondLine[1]);
		direction = Integer.parseInt(secondLine[2]);
		int[][] board = new int[height][width];
		
		for(int i = 0 ; i < height ; i++) {
			String[] thirdLine = (br.readLine()).split(" ");
			for(int j = 0 ; j < width ; j++) {
				board[i][j] = Integer.parseInt(thirdLine[j]);
			}
		}
		
		int turnCount = 0;
		int standardDirection = 0;
		boolean backWall = true;
		board[column][row] = 2;
		count++;
		while(backWall) {
			
			if(leftCheck(board)) {
				turnCount = 0;
				standardDirection = 0;
				count++;
				board[column][row] = 2;
				turnClean(board);
			}else {
				turnCount++;
				
				if(turnCount == 1) {
					standardDirection = direction;
					turnRobot(board);
				}else if(turnCount == 4){
					direction = standardDirection;
					if(!wallCheck(direction, board)) {
						turnCount = 0;
						backRobot(direction, board);
					}else {
						backWall = false;
					}
				}else {
					turnRobot(board);
				}
			}
			
		}
		
		br.close();
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
	
	private static boolean leftCheck(int[][] board) {
		
		boolean result = false;
		
		if(direction == 0) {
			if(board[column][row-1] == 0) {
				result = true;
			}
		}else if(direction == 1) {
			if(board[column-1][row] == 0) {
				result = true;
			}
		}else if(direction == 2) {
			if(board[column][row+1] == 0) {
				result = true;
			}
		}else if(direction == 3) {
			if(board[column+1][row] == 0) {
				result = true;
			}
		}
		
		return result;
		
	}
	
	private static void turnClean(int[][] board) {
		
		if(direction == 0) {
			row--;
			direction = 3;
			board[column][row] = 2;
		}else if(direction == 1) {
			column--;
			direction = 0;
			board[column][row] = 2;
		}else if(direction == 2) {
			row++;
			direction = 1;
			board[column][row] = 2;
		}else if(direction == 3) {
			column++;
			direction = 2;
			board[column][row] = 2;
		}
		
	}
	
	private static void turnRobot(int[][] board) {
		
		if(direction == 0) {
			direction = 3;
		}else if(direction == 1) {
			direction = 0;
		}else if(direction == 2) {
			direction = 1;
		}else if(direction == 3) {
			direction = 2;
		}
		
	}
	
	private static void backRobot(int standardDirection, int[][] board) {
		
		if(standardDirection == 0) {
			column++;
		}else if(standardDirection == 1) {
			row--;
		}else if(standardDirection == 2) {
			column--;
		}else if(standardDirection == 3) {
			row++;
		}
		
	}
	
	private static boolean wallCheck(int standardDirection, int[][] board) {
		
		boolean backWall = false;
		
		if(standardDirection == 0) {
			if(board[column+1][row] == 1) {
				backWall = true;
			}
		}else if(standardDirection == 1) {
			if(board[column][row-1] == 1) {
				backWall = true;
			}
		}else if(standardDirection == 2) {
			if(board[column-1][row] == 1) {
				backWall = true;
			}
		}else if(standardDirection == 3) {
			if(board[column][row+1] == 1) {
				backWall = true;
			}
		}
		
		return backWall;
		
	}
	
}
