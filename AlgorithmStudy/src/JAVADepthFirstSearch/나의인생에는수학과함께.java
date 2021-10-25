package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 나의인생에는수학과함께 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int lineNum;
	static int minResult;
	static int maxResult;
	static int[] upDown = {1, 0};
	static int[] leftRight = {0, 1};
	static int round = 0;
	
	public static void main(String[] args) throws IOException{

		lineNum = Integer.parseInt(br.readLine());
		String[][] board = new String[lineNum][lineNum];
		boolean[][] visitList = new boolean[lineNum][lineNum];
		
		for(int i = 0 ; i < lineNum ; i++) {
			String[] firstLine = (br.readLine()).split(" ");
			for(int j = 0 ; j < lineNum ; j++) {
				board[i][j] = firstLine[j];
			}
		}
		
		ArrayList<String> resultList = new ArrayList<String>();
		resultList.add(board[0][0]);
		dfs(0, 0, board, visitList, resultList);
		
		br.close();
		bw.write(maxResult + " " + minResult);
		bw.flush();
		bw.close();
		
	}
	
	private static void dfs(int heightRoot, int widthRoot, String[][] board, 
							boolean[][] visitList, ArrayList<String> resultList) {
		
		visitList[heightRoot][widthRoot] = true;
		
		if(heightRoot == (lineNum-1) && widthRoot == (lineNum-1)) {
			round++;
			int subResult = Integer.parseInt(resultList.get(0));
			
			for(int i = 1 ; i < resultList.size()-1 ; i += 2) {
				if((resultList.get(i)).equals("+")) {
					subResult += Integer.parseInt(resultList.get(i+1));
				}else if((resultList.get(i)).equals("-")){
					subResult -= Integer.parseInt(resultList.get(i+1));
				}else {
					subResult *= Integer.parseInt(resultList.get(i+1));
				}
			}
			
			if(round == 1) {
				minResult = subResult;
				maxResult = subResult;
			}else {
				if(subResult <= minResult) {
					minResult = subResult;
				}
				if(subResult >= maxResult) {
					maxResult = subResult;
				}
			}
			
		}
		
		for(int i = 0 ; i < 2 ; i++) {
			int subHeight = (heightRoot + upDown[i]);
			int subWidth = (widthRoot + leftRight[i]);
			
			if(subHeight >= 0 && subWidth >= 0 && subHeight < lineNum && subWidth < lineNum) {
				resultList.add(board[subHeight][subWidth]);
				dfs(subHeight, subWidth, board, visitList, resultList);
				resultList.remove(resultList.size()-1);
			}
		}
		
		
	}

}
