package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 로봇시물레이션 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{

		String[] firstLine = (br.readLine()).split(" ");
		int width = Integer.parseInt(firstLine[0]);
		int height = Integer.parseInt(firstLine[1]);
		String[] secondLine = (br.readLine()).split(" ");
		int robotNum = Integer.parseInt(secondLine[0]);
		int orderNum = Integer.parseInt(secondLine[1]);
		String[] direction = new String[robotNum];
		String[] position = new String[robotNum];
		int[][] board = new int[height+2][width+2];
		
		for(int i = 0 ; i < height+2 ; i++) {
			for(int j = 0 ; j < width+2 ; j++) {
				if(i == 0 || i == height+1 || j == 0 || j == width+1) {
					board[i][j] = 101;
					
				}
			}
		}
		
		for(int i = 0 ; i < robotNum ; i++) {
			String[] thirdLine = (br.readLine()).split(" ");
			direction[i] = thirdLine[2];
			position[i] = ((height+1)-(Integer.parseInt(thirdLine[1]))) + " " + Integer.parseInt(thirdLine[0]);
			board[(height+1)-(Integer.parseInt(thirdLine[1]))][Integer.parseInt(thirdLine[0])] = (i+1);
			
		}
		
		String result = "OK";
		for(int i = 0 ; i < orderNum ; i++) {
			String[] order = (br.readLine()).split(" ");
			int round = Integer.parseInt(order[2]);
			
			while(round > 0) {
				int x = Integer.parseInt(position[Integer.parseInt(order[0])-1].split(" ")[0]);
				int y = Integer.parseInt(position[Integer.parseInt(order[0])-1].split(" ")[1]);
				String direction_ = direction[Integer.parseInt(order[0])-1];
				if(order[1].equals("L")) {
					if(direction_.equals("W")) {
						direction[Integer.parseInt(order[0])-1] = "S";
					}else if(direction_.equals("E")) {
						direction[Integer.parseInt(order[0])-1] = "N";
					}else if(direction_.equals("N")) {
						direction[Integer.parseInt(order[0])-1] = "W";
					}else if(direction_.equals("S")) {
						direction[Integer.parseInt(order[0])-1] = "E";
					}
				}else if(order[1].equals("R")) {
					if(direction_.equals("W")) {
						direction[Integer.parseInt(order[0])-1] = "N";
					}else if(direction_.equals("E")) {
						direction[Integer.parseInt(order[0])-1] = "S";
					}else if(direction_.equals("N")) {
						direction[Integer.parseInt(order[0])-1] = "E";
					}else if(direction_.equals("S")) {
						direction[Integer.parseInt(order[0])-1] = "W";
					}
				}else if(order[1].equals("F")) {
					if(frontCheck(x, y, direction_, board) == 0) {
						if(direction_.equals("W")) {
							board[x][y-1] = Integer.parseInt(order[0]);
							board[x][y] = 0;
							position[Integer.parseInt(order[0])-1] = x + " " + (y-1);
						}else if(direction_.equals("E")) {
							board[x][y+1] = Integer.parseInt(order[0]);
							board[x][y] = 0;
							position[Integer.parseInt(order[0])-1] = x + " " + (y+1);
						}else if(direction_.equals("N")) {
							board[x-1][y] = Integer.parseInt(order[0]);
							board[x][y] = 0;
							position[Integer.parseInt(order[0])-1] = (x-1) + " " + y;
						}else if(direction_.equals("S")) {
							board[x+1][y] = Integer.parseInt(order[0]);
							board[x][y] = 0;
							position[Integer.parseInt(order[0])-1] = (x+1) + " " + y;
						} 
					}else if(frontCheck(x, y, direction_, board) == 101) {
						result = "Robot " + order[0] + " crashes into the wall";
						break;
					}else {
						result = "Robot " + order[0] + " crashes into robot " + frontCheck(x, y, direction_, board);
						break;
					}
				}
				
				round--;
			}
			
			if(!result.equals("OK")) {
				break;
			}
		}
		
		br.close();
		bw.write(result);
		bw.flush();
		bw.close();
	}
	
	private static int frontCheck(int i , int j, String direction, int[][] board) {
		int result = 0;
		
		if(direction.equals("W")) {
			if(board[i][j-1] != 0) {
				if(board[i][j-1] == 101) {
					result = 101;
				}else {
					result = board[i][j-1];
				}
			}
		}else if(direction.equals("E")) {
			if(board[i][j+1] != 0) {
				if(board[i][j+1] == 101) {
					result = 101;
				}else {
					result = board[i][j+1];
				}
			}
		}else if(direction.equals("S")) {
			if(board[i+1][j] != 0) {
				if(board[i+1][j] == 101) {
					result = 101;
				}else {
					result = board[i+1][j];
				}
			}
		}else if(direction.equals("N")) {
			if(board[i-1][j] != 0) {
				if(board[i-1][j] == 101) {
					result = 101;
				}else {
					result = board[i-1][j];
				}
			}
		}
		
		return result;
	}
	
}