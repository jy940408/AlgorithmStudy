package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 별찍기22 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int testCase = Integer.parseInt(br.readLine());
		String[][] board = new String[(4*testCase)-1][(4*testCase)-3];
		int space = 0;
		
		for(int i = 0 ; i < (4*testCase)-1 ; i++) {
			if(i%2 != 0 && i < (((4*testCase)-1)/2)+2) {
				space++;
			}else if(i%2 != 0 && i > (((4*testCase)-1)/2)) {
				space--;
			}
			for(int j = 0 ; j < (4*testCase)-3 ; j++) {
				if(i == 0 || i == (4*testCase)-2) {
					board[i][j] = "*";
				}else if(i == (((4*testCase)-1)/2)) {
					if(j%2 == 0) {
						board[i][j] = "*";
					}else {
						board[i][j] = " ";
					}
				}else if(i < (((4*testCase)-1)/2)) {
					if(i%2 == 0) {
						if(j < space*2 && j%2 != 0) {
							board[i][j] = " ";
						}else if(((4*testCase)-2)-j < space*2 && j%2 != 0) {
							board[i][j] = " ";
						}else {
							board[i][j] = "*";
						}
					}else {
						if(j < space*2 && j%2 == 0) {
							board[i][j] = "*";
						}else if(((4*testCase)-2)-j < space*2 && j%2 == 0) {
							board[i][j] = "*";
						}else {
							board[i][j] = " ";
						}
					}
				}else if(i > (((4*testCase)-1)/2)) {
					if(i%2 == 0) {
						if(j < space*2-1 && j%2 != 0) {
							board[i][j] = " ";
						}else if(((4*testCase)-2)-j < space*2 && j%2 != 0) {
							board[i][j] = " ";
						}else {
							board[i][j] = "*";
						}
					}else {
						if(j < space*2 && j%2 == 0) {
							board[i][j] = "*";
						}else if(((4*testCase)-2)-j <= space*2 && j%2 == 0) {
							board[i][j] = "*";
						}else {
							board[i][j] = " ";
						}
					}
				}
			}
		}
	
		if(testCase == 1) {
			bw.write("*");
		}else {
			for(int i = 0 ; i < (4*testCase)-1 ; i++) {
				for(int j = 0 ; j < (4*testCase)-3 ; j++) {
					if(i != 1) {
						if(j != (4*testCase)-4) {
							bw.write(board[i][j]);
						}else{
							bw.write(board[i][j] + "\n");
						}
					}else {
						bw.write(board[i][j] + "\n");
						break;
					}
				}
			}
		}
		
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
