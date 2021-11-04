package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PuyoPuyo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] upDown = {-1,1,0,0};
	static int[] leftRight = {0,0,-1,1};
	static int puyoNum;
	
	public static void main(String[] args) throws IOException{
		
		String[][] board = new String[12][6];
		for(int i = 0 ; i < 12 ; i++) {
			String[] firstLine = (br.readLine()).split("");
			for(int j = 0 ; j < 6 ; j++) {
				board[i][j] = firstLine[j];
			}
		}
		
		boolean[][] visitList = new boolean[12][6];
		
		int roundCheck = 0;
		int puyoCheck = 1;
		int puyoRound = 0;
		boolean leftPuyo = true;
		while(puyoCheck != 0) {
			visitList = new boolean[12][6];
			roundCheck++;
			puyoCheck = 0;
			for(int i = 0 ; i < 12 ; i++) {
				for(int j = 0 ; j < 6 ; j++) {
					if(!board[i][j].equals(".") && !visitList[i][j]) {
						puyoNum = 0;
						dfs(i, j, board, visitList, true);
						if(puyoNum >= 4) {
							puyoCheck++;
							visitList = new boolean[12][6];
							dfs(i, j, board, visitList, false);
						}
					}
				}
			}
			
			for(int i = 0 ; i < 12 ; i++) {
				for(int j = 0 ; j < 6 ; j++) {
					if(i < 11) {
						if(!board[i][j].equals(".") && board[i+1][j].equals(".")) {
							for(int k = i ; k >= 0 ; k--) {
								board[k+1][j] = board[k][j];
								board[k][j] = ".";
							}
						}
					}
				}
			}
		
			if(puyoCheck != 0) {
				puyoRound++;
			}
		}
		
		br.close();
		bw.write(puyoRound + "");
		bw.flush();
		bw.close();

	}
	
	private static void dfs(int heightRoot, int widthRoot, String[][] board, boolean[][] visitList, boolean puyoCheck) {
	
		visitList[heightRoot][widthRoot] = true;
		puyoNum++;
		String thisPuyo = board[heightRoot][widthRoot];
		
		if(!puyoCheck) {
			board[heightRoot][widthRoot] = ".";
		}
		
		for(int i = 0 ; i < 4 ; i++) {
			
			int subHeight = (heightRoot + upDown[i]);
			int subWidth = (widthRoot + leftRight[i]);
			
			if(subHeight >= 0 && subWidth >= 0 && subHeight < 12 && subWidth < 6) {
				if(thisPuyo.equals(board[subHeight][subWidth]) && !visitList[subHeight][subWidth]) {
					dfs(subHeight, subWidth, board, visitList, puyoCheck);
				}
				
			}
			
		}
		
		
	}

}
