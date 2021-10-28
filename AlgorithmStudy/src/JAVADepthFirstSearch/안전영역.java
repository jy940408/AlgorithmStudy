package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 안전영역 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int lineNum;
	static int[] upDown = {-1,1,0,0};
	static int[] leftRight = {0,0,-1,1};
	static int highNum, result = 0;
	
	public static void main(String[] args) throws IOException{
		
		lineNum = Integer.parseInt(br.readLine());
		int[][] board = new int[lineNum][lineNum];
		boolean[][] visitList = new boolean[lineNum][lineNum];
		
		for(int i = 0 ; i < lineNum ; i++) {
			String[] firstLine = (br.readLine()).split(" ");
			for(int j = 0 ; j < lineNum ; j++) {
				int heightNum = Integer.parseInt(firstLine[j]);
				board[i][j] = heightNum;
				if(heightNum >= highNum) {
					highNum = heightNum;
				}
			}
		}
		
		int subResult = 0;
		for(int k = 0 ; k < highNum ; k++) {
			subResult = 0;
			visitList = new boolean[lineNum][lineNum];
			
			for(int i = 0 ; i < lineNum ; i++) {
				for(int j = 0 ; j < lineNum ; j++) {
					if(board[i][j] > k && !visitList[i][j]) {
						dfs(i, j, board, visitList, k);
						subResult++;
					}
				}
			}
			
			if(subResult >= result) {
				result = subResult;
			}
		}
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}
	
	private static void dfs(int heightRoot, int widthRoot, int[][] board, boolean[][] visitList, int height) {
		
		visitList[heightRoot][widthRoot] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			
			int subHeight = (heightRoot + upDown[i]);
			int subWidth = (widthRoot + leftRight[i]);
			
			if(subHeight >= 0 && subWidth >= 0 && subHeight < lineNum && subWidth < lineNum) {
				if(board[subHeight][subWidth] > height && !visitList[subHeight][subWidth]) {
					dfs(subHeight, subWidth, board, visitList, height);
				}
			}
			
		}
		
	}

}