package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};
	static int result, width, height;
	static int[][] board;

	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		width = Integer.parseInt(firstLine[0]);
		height = Integer.parseInt(firstLine[1]);
		board = new int[height][width];
		boolean[][] visitList = new boolean[height][width];

		Queue<int[]> bfsQueue = new LinkedList<>();
		boolean tomatoCheck = false;
		boolean ripeCheck = false;
		for(int i = 0 ; i < height ; i++){
			String[] secondLine = (br.readLine()).split(" ");
			for(int j = 0 ; j < width ; j++){
				board[i][j] = Integer.parseInt(secondLine[j]);
				if (board[i][j] == 1){
					bfsQueue.add(new int[] {i, j, 0});
					tomatoCheck = true;
				}else if(board[i][j] == 0){
					ripeCheck = true;
				}
			}
		}

		boolean resultCheck = true;
		if(tomatoCheck && ripeCheck){
			bfs(bfsQueue, visitList);

			for(int i = 0 ; i < height ; i++){
				for(int j = 0 ; j < width ; j++){
					if(board[i][j] == 0){
						resultCheck = false;
						break;
					}
				}
			}

			if(resultCheck && result != 0){
				bw.write(result + "");
			}else if(resultCheck && result == 0){
				bw.write(0 + "");
			}else if(!resultCheck){
				bw.write(-1 + "");
			}
		}else if(!tomatoCheck && ripeCheck){
			bw.write(-1 + "");
		}else if(tomatoCheck && !ripeCheck){
			bw.write(0 + "");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static void bfs(Queue<int[]> bfsQueue, boolean[][] visitList){
		while(!bfsQueue.isEmpty()){
			int[] thisQueue = bfsQueue.poll();

			if(result < thisQueue[2]){
				result = thisQueue[2];
			}

			for(int i = 0 ; i < 4 ; i++){
				int subHeight = (thisQueue[0] + upDown[i]);
				int subWidth = (thisQueue[1] + leftRight[i]);

				if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
					if(board[subHeight][subWidth] == 0){
						if(!visitList[subHeight][subWidth]){
							board[subHeight][subWidth] = 1;
							visitList[subHeight][subWidth] = true;
							bfsQueue.add(new int[] {subHeight, subWidth, (thisQueue[2]+1)});
						}
					}
				}
			}
		}

	}

}
