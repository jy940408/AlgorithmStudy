package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 지구온난화 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int height = Integer.parseInt(firstLine[0]);
		int width = Integer.parseInt(firstLine[1]);
		
		String[][] board = new String[height+2][width+2];
		String[][] testBoard = new String[height+2][width+2];
		for(int i = 0 ; i < height+2 ; i++) {
			String[] secondLine = new String[width];
			if(i != 0 && i != height+1) {
				secondLine = (br.readLine()).split("");
			}
			for(int j = 0 ; j < width+2 ; j++) {
				if(i == 0 || j == 0 || i == height+1 || j == width+1) {
					board[i][j] = ",";
					testBoard[i][j] = ".";
				}else {
					board[i][j] = secondLine[j-1];
					testBoard[i][j] = secondLine[j-1];
				}
			}
		}
		
		int testNum = 0, minWidth = width, minHeight = height, maxWidth = 0, maxHeight = 0;
		for(int i = 1 ; i < height+1 ; i++) {
			for(int j = 1 ; j < width+1 ; j++) {
				testNum = 0;
				if(board[i][j].equals("X")) {
					if(!board[i+1][j].equals("X")) {
						testNum++;
					}
					if(!board[i][j+1].equals("X")) {
						testNum++;
					}
					if(!board[i-1][j].equals("X")) {
						testNum++;
					}
					if(!board[i][j-1].equals("X")) {
						testNum++;
					}
					if(testNum > 2) {
						testBoard[i][j] = ".";
					}else {
						testBoard[i][j] = "X";
						if(maxHeight < i) {
							maxHeight = i;
						}
						if(minHeight >= i) {
							minHeight = i;
						}
						if(maxWidth < j) {
							maxWidth = j;
						}
						if(minWidth >= j) {
							minWidth = j;
						}
					}
				}
			}
		}
		
		for(int i = minHeight ; i < maxHeight+1 ; i++) {
			for(int j = minWidth ; j < maxWidth+1 ; j++) {
				if(j == maxWidth) {
					bw.write(testBoard[i][j] + "\n");
				}else {
					bw.write(testBoard[i][j]);
				}
			}
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
