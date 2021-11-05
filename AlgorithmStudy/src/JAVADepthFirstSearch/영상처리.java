package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 영상처리 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] upDown = {-1,1,0,0};
	static int[] leftRight = {0,0,-1,1};
	static int height, width;
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		height = Integer.parseInt(firstLine[0]);
		width = Integer.parseInt(firstLine[1]);
		int[][] redBoard = new int[height][width];
		int[][] greenBoard = new int[height][width];
		int[][] blueBoard = new int[height][width];
		
		for(int i = 0 ; i < height ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			for(int j = 0 ; j < width*3 ; j++) {
				redBoard[i][j/3] = Integer.parseInt(secondLine[j]);
				j++;
				greenBoard[i][j/3] = Integer.parseInt(secondLine[j]);
				j++;
				blueBoard[i][j/3] = Integer.parseInt(secondLine[j]);
			}
		}
		
		int standard = Integer.parseInt(br.readLine());
		
		int[][] board = new int[height][width];
		for(int i = 0 ; i < height ; i++) {
			for(int j = 0 ; j < width ; j++) {
				int sum = (redBoard[i][j] + greenBoard[i][j] + blueBoard[i][j])/3;
				if(standard <= sum) {
					board[i][j] = 255;
				}else if(standard > sum) {
					board[i][j] = 0;
				}
				
			}
		}
		
		boolean[][] visitList = new boolean[height][width];
		int result = 0;
		for(int i = 0 ; i < height ; i++) {
			for(int j = 0 ; j < width ; j++) {
				if(board[i][j] == 255 && !visitList[i][j]) {
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
		
		for(int i = 0 ; i < 4 ; i++) {
			
			int subHeight = (heightRoot + upDown[i]);
			int subWidth = (widthRoot + leftRight[i]);
			
			if(subHeight >= 0 && subWidth >= 0 && subHeight < height && subWidth < width) {
				if(board[subHeight][subWidth] == 255 && !visitList[subHeight][subWidth]) {
					dfs(subHeight, subWidth, board, visitList);
				}
			}
			
		}
		
	}

}
