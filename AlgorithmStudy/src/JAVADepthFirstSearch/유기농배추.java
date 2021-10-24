package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 유기농배추 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int width;
	static int height;
	static boolean[][] visitList;
	static int[] upDown = {-1,1,0,0};
	static int[] rightLeft = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < testCase ; i++) {
			String[] firstLine = (br.readLine()).split(" ");
			width = Integer.parseInt(firstLine[0]);
			height = Integer.parseInt(firstLine[1]);
			int cabbageNum = Integer.parseInt(firstLine[2]);
			int[][] board = new int[height][width];
			visitList = new boolean[height][width];
			
			for(int j = 0 ; j < cabbageNum ; j++) {
				String[] secondLine = (br.readLine()).split(" ");
				int cabbageWidth = Integer.parseInt(secondLine[0]);
				int cabbageHeight = Integer.parseInt(secondLine[1]);
				board[cabbageHeight][cabbageWidth] = 1;
			}
			
			int result = 0;
			for(int j = 0 ; j < height ; j++) {
				for(int k = 0 ; k < width ; k++) {
					if(board[j][k] == 1 && !visitList[j][k]) {
						dfs(j, k, board);
						result++;
					}
				}
			}
			
			bw.write(result + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void dfs(int heightRoot, int widthRoot, int[][] board) {
		
		visitList[heightRoot][widthRoot] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int subHeight = (heightRoot + upDown[i]);
			int subWidth = (widthRoot + rightLeft[i]);
			
			if(subHeight >= 0 && subWidth >= 0 && subHeight < height && subWidth < width) {
				if(board[subHeight][subWidth] == 1 && !visitList[subHeight][subWidth]) {
					dfs(subHeight, subWidth, board);
				}
			}
		}
		
	}

}
