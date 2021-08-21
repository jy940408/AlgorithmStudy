package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 배열복원하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		String[] firstLine = (br.readLine()).split(" ");
		
		int height = Integer.parseInt(firstLine[0]);
		int width = Integer.parseInt(firstLine[1]);
		int xNum = Integer.parseInt(firstLine[2]);
		int yNum = Integer.parseInt(firstLine[3]);
		
		int[][] board = new int[height+xNum][width+yNum];
		int[][] arrange = new int[height][width];
		
		for(int i = 0 ; i < (height+xNum) ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			for(int j = 0 ; j < (width+yNum) ; j++) {
				board[i][j] = Integer.parseInt(secondLine[j]);
			}
		}
		
		for(int i = 0 ; i < height ; i++) {
			for(int j = 0 ; j < width ; j++) {
				if(i < xNum) {
					arrange[i][j] = board[i][j];
				}else if((i+xNum) > (height-1)) {
					arrange[i][j] = board[i+xNum][j+yNum];
				}
				if(j < yNum) {
					arrange[i][j] = board[i][j];
				}
			}
		}
		
		for(int i = 0 ; i < height ; i++) {
			for(int j = 0 ; j < width ; j++) {
				if(arrange[i][j] == 0 && i >= xNum && j >= yNum) {
					arrange[i][j] = board[i][j] - arrange[i-xNum][j-yNum];
				}
				
				if(j != width-1) {
					bw.write(arrange[i][j] + " ");
				}else {
					bw.write(arrange[i][j] + "\n");
				}
			}
			
		}
		
		
		br.close();
		bw.flush();
		bw.close();
		
		
	}

}
