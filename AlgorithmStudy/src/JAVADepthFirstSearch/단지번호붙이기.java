package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int lineNum;
	static int result = 0;
	static ArrayList<Integer> resultList = new ArrayList<Integer>();
	static int[] upDown = {-1, 1, 0, 0};
	static int[] leftRight = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		
		lineNum = Integer.parseInt(br.readLine());
		int[][] board = new int[lineNum][lineNum];
		boolean[][] visitList = new boolean[lineNum][lineNum];
		
		for(int i = 0 ; i < lineNum ; i++) {
			String[] firstLine = (br.readLine()).split("");
			for(int j = 0 ; j < lineNum ; j++) {
				board[i][j] = Integer.parseInt(firstLine[j]);
			}
		}
		
		for(int i = 0 ; i < lineNum ; i++) {
			for(int j = 0 ; j < lineNum ; j++) {
				if(board[i][j] == 1 && !visitList[i][j]) {
					dfs(i, j, board, visitList);
					resultList.add(result);
					result = 0;
				}
			}
		}
		
		Collections.sort(resultList);
		
		bw.write(resultList.size() + "\n");
		for(int i = 0 ; i < resultList.size() ; i++) {
			bw.write(resultList.get(i) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	private static void dfs(int heightRoot, int widthRoot, int[][] board, boolean[][] visitList) {
		
		visitList[heightRoot][widthRoot] = true;
		result++;
		
		for(int i = 0 ; i < 4 ; i++) {
			
			int subHeight = (heightRoot + upDown[i]);
			int subWidth = (widthRoot + leftRight[i]);
			
			if(subHeight >= 0 && subWidth >= 0 && subHeight < lineNum && subWidth < lineNum) {
				if(board[subHeight][subWidth] == 1 && !visitList[subHeight][subWidth]) {
					dfs(subHeight, subWidth, board, visitList);
				}
			}
			
		}
		
	}

}
