package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 항체인식 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] upDown = {-1,1,0,0};
	static int[] leftRight = {0,0,-1,1};
	static int height,width;
	static int changeCheck = 0;
	static String result = "";
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		height = Integer.parseInt(firstLine[0]);
		width = Integer.parseInt(firstLine[1]);
		
		int[][] mainBoard = new int[height][width];
		int[][] subBoard = new int[height][width];
		boolean[][] visitList = new boolean[height][width];
		for(int i = 0 ; i < height ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			for(int j = 0 ; j < width ; j++) {
				mainBoard[i][j] = Integer.parseInt(secondLine[j]);
			}
		}
		for(int i = 0 ; i < height ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			for(int j = 0 ; j < width ; j++) {
				subBoard[i][j] = Integer.parseInt(secondLine[j]);
			}
		}
		
		for(int i = 0 ; i < height ; i++) {
			for(int j = 0 ; j < width ; j++) {
				if(result.equals("") && changeCheck < 2) {
					if(!visitList[i][j]) {
						if(mainBoard[i][j] != subBoard[i][j]) {
							changeCheck++;
							dfs(i, j, mainBoard, subBoard, visitList);
						}
					}
				}else {
					break;
				}
			}
		}
		
		br.close();
		if(result.equals("NO") || changeCheck >= 2) {
			bw.write("NO");
		}else {
			bw.write("YES");
		}
		bw.flush();
		bw.close();
	}
	
	private static void dfs(int heightRoot, int widthRoot, int[][] mainBoard, int[][] subBoard, boolean[][] visitList) {
		
		visitList[heightRoot][widthRoot] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			
			int subHeight = (heightRoot + upDown[i]);
			int subWidth = (widthRoot + leftRight[i]);
			
			if(subHeight >= 0 && subWidth >= 0 && subHeight < height && subWidth < width) {
				if(mainBoard[heightRoot][widthRoot] == mainBoard[subHeight][subWidth] && !visitList[subHeight][subWidth]) {
					if(subBoard[heightRoot][widthRoot] == subBoard[subHeight][subWidth] && !visitList[subHeight][subWidth]) {
						dfs(subHeight, subWidth, mainBoard, subBoard, visitList);
					}else {
						result = "NO";
						return;
					}
				}
				
			}
			
			
		}
		
	}

}
