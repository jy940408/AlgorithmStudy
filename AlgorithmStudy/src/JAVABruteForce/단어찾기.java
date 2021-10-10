package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 단어찾기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int wordResult = 0;
	
	public static void main(String[] args) throws IOException{
		
		String testCase = br.readLine();
		String[] testArray = testCase.split("");
		String[] firstLine = (br.readLine()).split(" ");
		int width = Integer.parseInt(firstLine[0]);
		int height = Integer.parseInt(firstLine[1]);
		String[][] board = new String[height+(testCase.length()*2)][width+(testCase.length()*2)];
		
		for(int i = 0 ; i < height+(testCase.length()*2) ; i++) {
			if(i > testCase.length()-1 && i < height+testCase.length()) {
				String[] secondLine = (br.readLine()).split("");
				for(int j = 0 ; j < width+(testCase.length()*2) ; j++) {
					if(j > testCase.length()-1 && j < width+testCase.length()) {
						board[i][j] = secondLine[j-testCase.length()];
					}else {
						board[i][j] = ".";
					}
				}
			}else {
				for(int j = 0 ; j < width+(testCase.length()*2) ; j++) {
					board[i][j] = ".";
				}
			}
		}
		
		loop1:
		for(int i = testCase.length() ; i < height+testCase.length() ; i++) {
			for(int j = testCase.length() ; j < width+testCase.length() ; j++) {
				if(board[i][j].equals(testArray[0]) || board[i][j].equals(testArray[testArray.length-1])) {
					for(int k = 0 ; k < testArray.length ; k++) {
						if(widthCheck(i, j , testArray, board) || heightCheck(i, j , testArray, board) || diagonalCheck(i, j , testArray, board)) {
							wordResult++;
							break loop1;
						}
						
					}
				}
			}
		}
		
		br.close();
		bw.write(wordResult + "");
		bw.flush();
		bw.close();
		
	}
	
	private static boolean widthCheck(int i, int j, String[] testArray, String[][] board) {
		boolean result = false;
		
		for(int k = 0 ; k < testArray.length ; k++) {
			if(testArray[k].equals(board[i][j+k])) {
				if(k == testArray.length-1) {
					result = true;
				}
			}else {
				break;
			}
		}
		
		for(int k = 0 ; k < testArray.length ; k++) {
			if(testArray[(testArray.length-1)-k].equals(board[i][j+k])) {
				if(k == testArray.length-1) {
					result = true;
				}
			}else {
				break;
			}
		}
		
		return result;
	}

	private static boolean heightCheck(int i, int j, String[] testArray, String[][] board) {
		boolean result = false;
		
		for(int k = 0 ; k < testArray.length ; k++) {
			if(testArray[k].equals(board[i+k][j])) {
				if(k == testArray.length-1) {
					result = true;
				}
			}else {
				break;
			}
		}
		
		for(int k = 0 ; k < testArray.length ; k++) {
			if(testArray[(testArray.length-1)-k].equals(board[i+k][j])) {
				if(k == testArray.length-1) {
					result = true;
				}
			}else {
				break;
			}
		}
		
		return result;
	}
	
	private static boolean diagonalCheck(int i, int j, String[] testArray, String[][] board) {
		boolean result = false;
		
		for(int k = 0 ; k < testArray.length ; k++) {
			if(testArray[k].equals(board[i+k][j+k])) {
				if(k == testArray.length-1) {
					result = true;
				}
			}else {
				break;
			}
		}
		
		for(int k = 0 ; k < testArray.length ; k++) {
			if(testArray[(testArray.length-1)-k].equals(board[i+k][j+k])) {
				if(k == testArray.length-1) {
					result = true;
				}
			}else {
				break;
			}
		}
		
		for(int k = 0 ; k < testArray.length ; k++) {
			if(testArray[k].equals(board[i-k][j-k])) {
				if(k == testArray.length-1) {
					result = true;
				}
			}else {
				break;
			}
		}
		
		for(int k = 0 ; k < testArray.length ; k++) {
			if(testArray[(testArray.length-1)-k].equals(board[i-k][j-k])) {
				if(k == testArray.length-1) {
					result = true;
				}
			}else {
				break;
			}
		}
		
		for(int k = 0 ; k < testArray.length ; k++) {
			if(testArray[k].equals(board[i+k][j-k])) {
				if(k == testArray.length-1) {
					result = true;
				}
			}else {
				break;
			}
		}
		
		for(int k = 0 ; k < testArray.length ; k++) {
			if(testArray[(testArray.length-1)-k].equals(board[i+k][j-k])) {
				if(k == testArray.length-1) {
					result = true;
				}
			}else {
				break;
			}
		}
		
		for(int k = 0 ; k < testArray.length ; k++) {
			if(testArray[k].equals(board[i-k][j+k])) {
				if(k == testArray.length-1) {
					result = true;
				}
			}else {
				break;
			}
		}
		
		for(int k = 0 ; k < testArray.length ; k++) {
			if(testArray[(testArray.length-1)-k].equals(board[i-k][j+k])) {
				if(k == testArray.length-1) {
					result = true;
				}
			}else {
				break;
			}
		}
		return result;
	}
}
