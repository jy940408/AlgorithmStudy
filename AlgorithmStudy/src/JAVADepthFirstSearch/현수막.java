package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 현수막 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int height, width;
	static int[] upDown = {-1,1,0,0,-1,-1,1,1};
	static int[] leftRight = {0,0,-1,1,-1,1,-1,1};
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		height = Integer.parseInt(firstLine[0]);
		width = Integer.parseInt(firstLine[1]);
		int[][] board = new int[height][width];
		boolean[][] visitList = new boolean[height][width];
		
		for(int i = 0 ; i < height ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			for(int j = 0 ; j < width ; j++) {
				board[i][j] = Integer.parseInt(secondLine[j]);
			}
		}
		
		int result = 0;
		for(int i = 0 ; i < height ; i++) {
			for(int j = 0 ; j < width ; j++) {
				if(board[i][j] != 0 && !visitList[i][j]) {
					result++;
					dfs(i, j, board, visitList);
				}
			}
		}
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}
	
	private static void dfs(int heightRoot, int widthRoot, int[][] board, boolean[][] visitList) {
		
		visitList[heightRoot][widthRoot] = true;
		
		for(int i = 0 ; i < 8 ; i++) {
			
			int subHeight = (heightRoot + upDown[i]);
			int subWidth = (widthRoot + leftRight[i]);
			
			if(subHeight >= 0 && subWidth >= 0 && subHeight < height && subWidth < width) {
				if(board[subHeight][subWidth] != 0 && !visitList[subHeight][subWidth]) {
					dfs(subHeight, subWidth, board, visitList);
				}
			}
			
		}
		
	}

}
