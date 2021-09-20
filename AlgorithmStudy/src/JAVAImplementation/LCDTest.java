package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LCDTest {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int size = Integer.parseInt(firstLine[0]);
		String[] num = (firstLine[1]).split("");
		String[][][] board = new String[num.length][(2*size)+3][size+2];
		
		for(int i = 0 ; i < num.length ; i++) {
			if(num[i].equals("0")) {
				for(int j = 0 ; j < (2*size)+3 ; j++) {
					for(int k = 0 ; k < (size+2) ; k++) {
						if(j == 0) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j == (((2*size)+3)/2)) {
							board[i][j][k] = " ";
						}else if(j == (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else {
							if(k == 0) {
								board[i][j][k] = "|";
							}else if(k == size+1) {
								board[i][j][k] = "|";
							}else {
								board[i][j][k] = " ";
							}
						}
					}
				}
			}else if(num[i].equals("1")) {
				for(int j = 0 ; j < (2*size)+3 ; j++) {
					for(int k = 0 ; k < (size+2) ; k++) {
						if(j == 0) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = " ";
							}
						}else if(j == (((2*size)+3)/2)) {
							board[i][j][k] = " ";
						}else if(j == (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = " ";
							}
						}else {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = "|";
							}else {
								board[i][j][k] = " ";
							}
						}
					}
				}
			}else if(num[i].equals("2")) {
				for(int j = 0 ; j < (2*size)+3 ; j++) {
					for(int k = 0 ; k < (size+2) ; k++) {
						if(j == 0) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j != 0 && j < (((2*size)+3)/2)) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = "|";
							}else {
								board[i][j][k] = " ";
							}
						}else if(j == (((2*size)+3)/2)) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j > (((2*size)+3)/2) && j != (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = "|";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = " ";
							}
						}else if(j == (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}
					}
				}
			}else if(num[i].equals("3")) {
				for(int j = 0 ; j < (2*size)+3 ; j++) {
					for(int k = 0 ; k < (size+2) ; k++) {
						if(j == 0) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j == (((2*size)+3)/2)) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j == (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = "|";
							}else {
								board[i][j][k] = " ";
							}
						}
					}
				}
			}else if(num[i].equals("4")) {
				for(int j = 0 ; j < (2*size)+3 ; j++) {
					for(int k = 0 ; k < (size+2) ; k++) {
						if(j == 0) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = " ";
							}
						}else if(j != 0 && j < (((2*size)+3)/2)) {
							if(k == 0) {
								board[i][j][k] = "|";
							}else if(k == size+1) {
								board[i][j][k] = "|";
							}else {
								board[i][j][k] = " ";
							}
						}else if(j == (((2*size)+3)/2)) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j > (((2*size)+3)/2) && j != (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = "|";
							}else {
								board[i][j][k] = " ";
							}
						}else if(j == (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = " ";
							}
						}
					}
				}
			}else if(num[i].equals("5")) {
				for(int j = 0 ; j < (2*size)+3 ; j++) {
					for(int k = 0 ; k < (size+2) ; k++) {
						if(j == 0) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j != 0 && j < (((2*size)+3)/2)) {
							if(k == 0) {
								board[i][j][k] = "|";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = " ";
							}
						}else if(j == (((2*size)+3)/2)) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j > (((2*size)+3)/2) && j != (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = "|";
							}else {
								board[i][j][k] = " ";
							}
						}else if(j == (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}
					}
				}
			}else if(num[i].equals("6")) {
				for(int j = 0 ; j < (2*size)+3 ; j++) {
					for(int k = 0 ; k < (size+2) ; k++) {
						if(j == 0) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j != 0 && j < (((2*size)+3)/2)) {
							if(k == 0) {
								board[i][j][k] = "|";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = " ";
							}
						}else if(j == (((2*size)+3)/2)) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j > (((2*size)+3)/2) && j != (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = "|";
							}else if(k == size+1) {
								board[i][j][k] = "|";
							}else {
								board[i][j][k] = " ";
							}
						}else if(j == (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}
					}
				}
			}else if(num[i].equals("7")) {
				for(int j = 0 ; j < (2*size)+3 ; j++) {
					for(int k = 0 ; k < (size+2) ; k++) {
						if(j == 0) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j == (((2*size)+3)/2)) {
							board[i][j][k] = " ";
						}else if(j == (2*size)+2) {
							board[i][j][k] = " ";
						}else {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = "|";
							}else {
								board[i][j][k] = " ";
							}
						}
					}
				}
			}else if(num[i].equals("8")) {
				for(int j = 0 ; j < (2*size)+3 ; j++) {
					for(int k = 0 ; k < (size+2) ; k++) {
						if(j == 0) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j == (((2*size)+3)/2)) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j == (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else {
							if(k == 0) {
								board[i][j][k] = "|";
							}else if(k == size+1) {
								board[i][j][k] = "|";
							}else {
								board[i][j][k] = " ";
							}
						}
					}
				}
			}else if(num[i].equals("9")) {
				for(int j = 0 ; j < (2*size)+3 ; j++) {
					for(int k = 0 ; k < (size+2) ; k++) {
						if(j == 0) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j != 0 && j < (((2*size)+3)/2)) {
							if(k == 0) {
								board[i][j][k] = "|";
							}else if(k == size+1) {
								board[i][j][k] = "|";
							}else {
								board[i][j][k] = " ";
							}
						}else if(j == (((2*size)+3)/2)) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}else if(j > (((2*size)+3)/2) && j != (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = "|";
							}else {
								board[i][j][k] = " ";
							}
						}else if(j == (2*size)+2) {
							if(k == 0) {
								board[i][j][k] = " ";
							}else if(k == size+1) {
								board[i][j][k] = " ";
							}else {
								board[i][j][k] = "-";
							}
						}
					}
				}
			}
			
		}
		
		for(int i = 0 ; i < (2*size)+3 ; i++) {
			for(int j = 0 ; j < num.length ; j++) {
				for(int k = 0 ; k < (size+2) ; k++) {
					if(j != num.length-1 && k == size+1) {
						bw.write(board[j][i][k] + " ");
					}else if(j == num.length-1 && k == size+1) {
						bw.write(board[j][i][k] + "\n");
					}else {
						bw.write(board[j][i][k] + "");
					}
				}
			}
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
