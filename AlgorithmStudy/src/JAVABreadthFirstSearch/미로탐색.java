package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int height, width;
	static int[] upDown = {-1,1,0,0};
	static int[] leftRight = {0,0,-1,1};
	static int[][] resultBoard;
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		width = Integer.parseInt(firstLine[1]);
		height = Integer.parseInt(firstLine[0]);
		
		resultBoard = new int[height][width];
		int[][] board = new int[height][width];
		boolean[][] visitList = new boolean[height][width];
		for(int i = 0 ; i < height ; i++) {
			String[] secondLine = (br.readLine()).split("");
			for(int j = 0 ; j < width ; j++) {
				board[i][j] = Integer.parseInt(secondLine[j]);
				resultBoard[i][j] = board[i][j];
			}
		}
		
		bfs(new int[] {0,0}, board, visitList);
		
		br.close();
		bw.write(resultBoard[height-1][width-1] + "");
		bw.flush();
		bw.close();
		
	}
	
	private static void bfs(int[] root, int[][] board, boolean[][] visitList) {
		
		visitList[root[0]][root[1]] = true;
		Queue<int[]> bfsQueue = new LinkedList<>();
		bfsQueue.add(root);
		
		while(!bfsQueue.isEmpty()) {
			
			int[] subRoot = bfsQueue.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int subHeight = (subRoot[0] + upDown[i]);
				int subWidth = (subRoot[1] + leftRight[i]);
				
				if(subHeight >= 0 && subWidth >= 0 && subHeight < height && subWidth < width) {
					if(board[subHeight][subWidth] == 1 && !visitList[subHeight][subWidth]) {
						
						visitList[subHeight][subWidth] = true;
						bfsQueue.add(new int[] {subHeight, subWidth});
						resultBoard[subHeight][subWidth] = resultBoard[subRoot[0]][subRoot[1]] + 1;
						
					}
				}
			}
			
		}
		
	}

}
