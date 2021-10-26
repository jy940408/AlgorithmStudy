package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 적록색약 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int lineNum;
	static int[] upDown = {-1, 1, 0, 0};
	static int[] leftRight = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{

		lineNum = Integer.parseInt(br.readLine());
		
		String[][] board = new String[lineNum][lineNum];
		for(int i = 0 ; i < lineNum ; i++) {
			String[] firstLine = (br.readLine()).split("");
			for(int j = 0 ; j < lineNum ; j++) {
				board[i][j] = firstLine[j];
			}
		}
		
		int firstResult = 0;
		boolean[][] visitList = new boolean[lineNum][lineNum];
		for(int i = 0 ; i < lineNum ; i++) {
			for(int j = 0 ; j < lineNum ; j++) {
				if(!visitList[i][j]) {
					dfs(i, j, board, visitList, 1);
					firstResult++;
				}
			}
		}

		int secondResult = 0;
		visitList = new boolean[lineNum][lineNum];
		for(int i = 0 ; i < lineNum ; i++) {
			for(int j = 0 ; j < lineNum ; j++) {
				if(!visitList[i][j]) {
					dfs(i, j, board, visitList, -1);
					secondResult++;
				}
			}
		}
		
		br.close();
		bw.write(firstResult + " " + secondResult);
		bw.flush();
		bw.close();
		

	}

	private static void dfs(int heightRoot, int widthRoot, String[][] board, boolean[][] visitList, int colorCheck) {
		
		visitList[heightRoot][widthRoot] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int subHeight = (heightRoot + upDown[i]);
			int subWidth = (widthRoot + leftRight[i]);
			
			if(subHeight >= 0 && subWidth >= 0 && subHeight < lineNum && subWidth < lineNum) {
				if(colorCheck == 1) {
					if(board[heightRoot][widthRoot].equals(board[subHeight][subWidth]) && !visitList[subHeight][subWidth]) {
						dfs(subHeight, subWidth, board, visitList, colorCheck);
					}
				}else {
					if(board[heightRoot][widthRoot].equals("R") || board[heightRoot][widthRoot].equals("G")) {
						if(!board[subHeight][subWidth].equals("B") && !visitList[subHeight][subWidth]) {
							dfs(subHeight, subWidth, board, visitList, colorCheck);
						}
					}else {
						if(board[heightRoot][widthRoot].equals(board[subHeight][subWidth]) && !visitList[subHeight][subWidth]) {
							dfs(subHeight, subWidth, board, visitList, colorCheck);
						}
					}
				}
			}
		}
		
	}
}
