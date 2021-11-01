package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 양한마리양두마리 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int height, width;
	static String[][] board;
	static int[] upDown = {-1,1,0,0};
	static int[] leftRight = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		
		int roundNum = Integer.parseInt(br.readLine());
		
		for(int k = 0 ; k < roundNum ; k++) {
			String[] firstLine = (br.readLine()).split(" ");
			height = Integer.parseInt(firstLine[0]);
			width = Integer.parseInt(firstLine[1]);
			board = new String[height][width];
			boolean[][] visitList = new boolean[height][width];
			
			for(int i = 0 ; i < height ; i++) {
				String[] secondLine = (br.readLine()).split("");
				for(int j = 0 ; j < width ; j++) {
					board[i][j] = secondLine[j];
				}
			}
			
			int result = 0;
			for(int i = 0 ; i < height ; i++) {
				for(int j = 0 ; j < width ; j++) {
					if(board[i][j].equals("#") && !visitList[i][j]) {
						result++;
						dfs(i, j, visitList);
					}
				}
			}	
			
			bw.write(result + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	private static void dfs(int heightRoot, int widthRoot, boolean[][] visitList) {
		
		visitList[heightRoot][widthRoot] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int subHeight = (heightRoot + upDown[i]);
			int subWidth = (widthRoot + leftRight[i]);
			
			if(subHeight >= 0 && subWidth >= 0 && subHeight < height && subWidth < width) {
				if(board[subHeight][subWidth].equals("#") && !visitList[subHeight][subWidth]) {
					dfs(subHeight, subWidth, visitList);
				}
			}
		}
		
	}

}
