package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class 풀링222 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int size = Integer.parseInt(br.readLine());
		int checkSize = size;
		int[][] board = new int[size][size];
		
		for(int i = 0 ; i < size ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			for(int j = 0 ; j < size ; j++) {
				board[i][j] = Integer.parseInt(secondLine[j]);
			}
		}
		
		int[][] resultBoard = new int[checkSize][checkSize];
		while(checkSize != 1) {
			
			resultBoard = new int[checkSize][checkSize];
			
			for(int i = 0 ; i < checkSize ; i++) {
				for(int j = 0 ; j < checkSize ; j++) {
					if(i%2 == 0 && j%2 == 0) {
						ArrayList<Integer> checkSquare = new ArrayList<Integer>();
						checkSquare.add(board[i][j]);
						checkSquare.add(board[i+1][j]);
						checkSquare.add(board[i][j+1]);
						checkSquare.add(board[i+1][j+1]);
						Collections.sort(checkSquare);
						int x = 0;
						int y = 0;
						if(i == 0) {
							x = 0;
						}else if(i != 0) {
							x = i/2;
						}
						if(j == 0) {
							y = 0;
						}else if(j != 0) {
							y = j/2;
						}
						resultBoard[x][y] = checkSquare.get(2);
					}
				}
			}
			
			board = new int[checkSize][checkSize];
			for(int i = 0 ; i < checkSize ; i++) {
				for(int j = 0 ; j < checkSize ; j++) {
					board[i][j] = resultBoard[i][j];
				}
			}
			checkSize = checkSize/2;
		}
	
		br.close();
		bw.write(resultBoard[0][0] + "");
		bw.flush();
		bw.close();
	}

}
