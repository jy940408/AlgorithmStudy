package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 섬의개수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int height, width;
	static int[] upDown = {-1,1,0,0,-1,-1,1,1};
	static int[] leftRight = {0,0,-1,1,-1,1,-1,1};
	
	public static void main(String[] args) throws IOException{
		
		String firstLine = "";
		while(!firstLine.equals("0 0")) {
			firstLine = br.readLine();
			String[] splitLine = firstLine.split(" ");
			width = Integer.parseInt(splitLine[0]);
			height = Integer.parseInt(splitLine[1]);
			
			if(firstLine.equals("0 0")) {
				break;
			}else {
				int[][] board = new int[height][width];
				for(int i = 0 ; i < height ; i++) {
					String[] secondLine = (br.readLine()).split(" ");
					for(int j = 0 ; j < width ; j++) {
						board[i][j] = Integer.parseInt(secondLine[j]);
					}
				}
				
				boolean[][] visitList = new boolean[height][width];
				int result = 0;
				for(int i = 0 ; i < height ; i++) {
					for(int j = 0 ; j < width ; j++) {
						if(board[i][j] == 1 && !visitList[i][j]) {
							result++;
							bfs(new pair(i,j), board, visitList);
						}
					}
				}
				
				bw.write(result + "\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	private static void bfs(pair root, int[][] board, boolean[][] visitList) {
		
		visitList[root.height][root.width] = true;
		Queue<pair> bfsQueue = new LinkedList<>();
		bfsQueue.add(root);
		
		while(!bfsQueue.isEmpty()) {
			
			pair subRoot = bfsQueue.poll();
			
			for(int i = 0 ; i < 8 ; i++) {
				int subHeight = (subRoot.height + upDown[i]);
				int subWidth = (subRoot.width + leftRight[i]);
				
				if(subHeight >= 0 && subWidth >= 0 && subHeight < height &&  subWidth < width) {
					if(board[subHeight][subWidth] == 1 && !visitList[subHeight][subWidth]) {
						bfsQueue.add(new pair(subHeight, subWidth));
						visitList[subHeight][subWidth] = true;
					}
				}
				
			}
			
		}
		
		
	}

}

class pair{
	int height;
	int width;
	pair(int height, int width){
		this.height = height;
		this.width = width;
	}
}
