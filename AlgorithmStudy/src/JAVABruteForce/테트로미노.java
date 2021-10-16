package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 테트로미노 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int result = 0;
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int height = Integer.parseInt(firstLine[0]);
		int width = Integer.parseInt(firstLine[1]);
		int[][] board = new int[height+6][width+6];
		for(int i = 3 ; i < height+3 ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			for(int j = 3 ; j < width+3 ; j++) {
				board[i][j] = Integer.parseInt(secondLine[j-3]);
			}
		}
		
		for(int i = 3 ; i < height+3 ; i++) {
			for(int j = 3 ; j < width+3 ; j++) {
				iCheck(i, j, board);
				oCheck(i, j, board);
				lCheck(i, j, board);
				sCheck(i, j, board);
				tCheck(i, j, board);
			}
		}
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();

	}
	
	private static void iCheck(int i, int j, int[][] board) {
		
		int[] testList = new int[4];
		testList[0] = board[i][j] + board[i][j+1] + board[i][j+2] + board[i][j+3];
		testList[1] = board[i][j] + board[i][j-1] + board[i][j-2] + board[i][j-3];
		testList[2] = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j];
		testList[3] = board[i][j] + board[i-1][j] + board[i-2][j] + board[i-3][j];
		
		Arrays.sort(testList);
		
		if(result < testList[testList.length-1]) {
			result = testList[testList.length-1];
		}
		
	}
	
	private static void oCheck(int i, int j, int[][] board) {
		
		int[] testList = new int[4];
		testList[0] = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+1][j];
		testList[1] = board[i][j] + board[i+1][j] + board[i+1][j-1] + board[i][j-1];
		testList[2] = board[i][j] + board[i][j-1] + board[i-1][j-1] + board[i-1][j];
		testList[3] = board[i][j] + board[i-1][j] + board[i-1][j+1] + board[i][j+1];
		
		Arrays.sort(testList);
		
		if(result < testList[testList.length-1]) {
			result = testList[testList.length-1];
		}
		
	}

	private static void lCheck(int i, int j, int[][] board) {
		
		int[] testList = new int[16];
		testList[0] = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j];
		testList[1] = board[i][j] + board[i+1][j] + board[i+2][j] + board[i][j-1];
		testList[2] = board[i][j] + board[i][j-1] + board[i][j-2] + board[i-1][j];
		testList[3] = board[i][j] + board[i-1][j] + board[i-2][j] + board[i][j+1];
		testList[4] = board[i][j] + board[i][j+1] + board[i][j+2] + board[i-1][j];
		testList[5] = board[i][j] + board[i+1][j] + board[i+2][j] + board[i][j+1];
		testList[6] = board[i][j] + board[i][j-1] + board[i][j-2] + board[i+1][j];
		testList[7] = board[i][j] + board[i-1][j] + board[i-2][j] + board[i][j-1];
		testList[8] = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+2];
		testList[9] = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+2][j+1];
		testList[10] = board[i][j] + board[i][j-1] + board[i][j-2] + board[i+1][j-2];
		testList[11] = board[i][j] + board[i-1][j] + board[i-2][j] + board[i-2][j-1];
		testList[12] = board[i][j] + board[i][j+1] + board[i][j+2] + board[i-1][j+2];
		testList[13] = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+2][j-1];
		testList[14] = board[i][j] + board[i][j-1] + board[i][j-2] + board[i-1][j-2];
		testList[15] = board[i][j] + board[i-1][j] + board[i-2][j] + board[i-2][j+1];
		
		Arrays.sort(testList);
		
		if(result < testList[testList.length-1]) {
			result = testList[testList.length-1];
		}
		
	}
	
	private static void sCheck(int i, int j, int[][] board) {
		
		int[] testList = new int[8];
		testList[0] = board[i][j] + board[i][j+1] + board[i-1][j+1] + board[i-1][j+2];
		testList[1] = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j+1];
		testList[2] = board[i][j] + board[i][j-1] + board[i+1][j-1] + board[i+1][j-2];
		testList[3] = board[i][j] + board[i-1][j] + board[i-1][j-1] + board[i-2][j-1];
		testList[4] = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+1][j+2];
		testList[5] = board[i][j] + board[i+1][j] + board[i+1][j-1] + board[i+2][j-1];
		testList[6] = board[i][j] + board[i][j-1] + board[i-1][j-1] + board[i-1][j-2];
		testList[7] = board[i][j] + board[i-1][j] + board[i-1][j+1] + board[i-2][j+1];
		
		Arrays.sort(testList);
		
		if(result < testList[testList.length-1]) {
			result = testList[testList.length-1];
		}
		
	}
	
	private static void tCheck(int i, int j, int[][] board) {
		
		int[] testList = new int[8];
		testList[0] = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+1];
		testList[1] = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+1][j-1];
		testList[2] = board[i][j] + board[i][j-1] + board[i][j-2] + board[i-1][j-1];
		testList[3] = board[i][j] + board[i-1][j] + board[i-2][j] + board[i-1][j+1];
		testList[4] = board[i][j] + board[i][j+1] + board[i][j+2] + board[i-1][j+1];
		testList[5] = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+1][j+1];
		testList[6] = board[i][j] + board[i][j-1] + board[i][j-2] + board[i+1][j-1];
		testList[7] = board[i][j] + board[i-1][j] + board[i-2][j] + board[i-1][j-1];
		
		Arrays.sort(testList);
		
		if(result < testList[testList.length-1]) {
			result = testList[testList.length-1];
		}
		
	}
	
}
