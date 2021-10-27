package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 음식물피하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int height, width;
	static int[][] board;
	static int resultNum = 0;
	static int result = 0;
	static int[] upDown = {-1,1,0,0};
	static int[] leftRight = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		height = Integer.parseInt(firstLine[0]);
		width = Integer.parseInt(firstLine[1]);
		int foodNum = Integer.parseInt(firstLine[2]);
		board = new int[height][width];
		boolean[][] visitList = new boolean[height][width];
		
		for(int i = 0 ; i < foodNum ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			int firstNum = Integer.parseInt(secondLine[0]);
			int secondNum = Integer.parseInt(secondLine[1]);
			board[firstNum-1][secondNum-1] = 1;
		}
		
		for(int i = 0 ; i < height ; i++) {
			for(int j = 0 ; j < width ; j++) {
				if(board[i][j] == 1 && !visitList[i][j]) {
					result = 0;
					dfs(i, j, visitList);
				}
			}
		}
		
		br.close();
		bw.write(resultNum + "");
		bw.flush();
		bw.close();
		
	}
	
	private static void dfs(int heightRoot, int widthRoot, boolean[][] visitList) {
		
		result++;
		visitList[heightRoot][widthRoot] = true;
		
		if(resultNum <= result) {
			resultNum = result;
		}
		
		for(int i = 0 ; i < 4 ; i++) {
			int subHeight = (heightRoot + upDown[i]);
			int subWidth = (widthRoot + leftRight[i]);
			
			if(subHeight >= 0 && subWidth >= 0 && subHeight < height && subWidth < width) {
				if(board[subHeight][subWidth] == 1 && !visitList[subHeight][subWidth]) {
					dfs(subHeight, subWidth, visitList);
				}
			}
		}
		
	}

}
