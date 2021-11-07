package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 나이트의이동 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] upDown = {-2,-2,2,2,-1,-1,1,1};
	static int[] leftRight = {-1,1,-1,1,-2,2,-2,2};
	static int length;
	
	public static void main(String[] args) throws IOException{
		
		int roundNum = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < roundNum ; i++) {
			
			length = Integer.parseInt(br.readLine());
			int[][] board = new int[length][length];
			int[][] subBoard = new int[length][length];
			boolean[][] visitList = new boolean[length][length];
			String[] firstLine = (br.readLine()).split(" ");
			int thisHeight = Integer.parseInt(firstLine[0]);
			int thisWidth = Integer.parseInt(firstLine[1]);
			String[] secondLine = (br.readLine()).split(" ");
			int goalHeight = Integer.parseInt(secondLine[0]);
			int goalWidth = Integer.parseInt(secondLine[1]);
			
			bfs(new int[] {thisHeight, thisWidth}, board, subBoard, visitList);
			
			bw.write(subBoard[goalHeight][goalWidth] + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	private static void bfs(int[] root, int[][] board, int[][] subBoard, boolean[][] visitList) {
		
		visitList[root[0]][root[1]] = true;
		Queue<int[]> bfsQueue = new LinkedList<>();
		bfsQueue.add(root);
		
		while(!bfsQueue.isEmpty()) {
			
			int[] subRoot = bfsQueue.poll();
			for(int i = 0 ; i < 8 ; i++) {
				
				int subHeight = (subRoot[0] + upDown[i]);
				int subWidth = (subRoot[1] + leftRight[i]);
				
				if(subHeight >= 0 && subWidth >= 0 && subHeight < length && subWidth < length) {
					if(!visitList[subHeight][subWidth]) {
						
						visitList[subHeight][subWidth] = true;
						bfsQueue.add(new int[] {subHeight, subWidth});
						
						subBoard[subHeight][subWidth] = subBoard[subRoot[0]][subRoot[1]] + 1;
					}
					
				}
				
			}
			
		}
		
	}

}
