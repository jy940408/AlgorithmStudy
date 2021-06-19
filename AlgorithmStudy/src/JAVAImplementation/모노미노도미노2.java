package JAVAImplementation;

import java.util.Scanner;

public class 모노미노도미노2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int firstNum = Integer.parseInt(scan.nextLine());
		
		int[][] green = new int[4][6];
		int[][] blue = new int[6][4];
		
		for(int i = 0 ; i < firstNum ; i++) {
			
			String[] numLine_ = (scan.nextLine()).split(" ");
			int[] numLine = new int[3];
			for(int j = 0 ; j < 3 ; j++) {
				numLine[j] = Integer.parseInt(numLine_[j]);
			}
			
//			x축 = numLine[1] && y축 = numLine[2]

			if(numLine[0] == 1) {
				
//				blue 타일 확인
				for(int j = 0 ; j < 6 ; j++) {
					if(blue[j][numLine[2]] != 0) {
						blue[j-1][numLine[2]] = 1;
						int count = 0;
						for(int k = 0 ; k < 4 ; k++) {
							if(blue[j-1][k] == 1) {
								count = count + 1;
							}
						}
						if(count == 4) {
							System.out.println("꺄울");
						}
						break;
					}else if(j == 5) {
						blue[j][numLine[2]] = 1;
						int count = 0;
						for(int k = 0 ; k < 4 ; k++) {
							if(blue[j][k] == 1) {
								count = count + 1;
							}
						}
						if(count == 4) {
							System.out.println("꺄울");
						}
						break;
					}
				}
				
//				green 타일 확인
				for(int j = 0 ; j < 6 ; j++) {
					if(green[numLine[1]][j] != 0) {
						green[numLine[1]][j-1] = 1;
						int count = 0;
						for(int k = 0 ; k < 4 ; k++) {
							if(green[k][j-1] == 1) {
								count = count + 1;
							}
						}
						if(count == 4) {
							System.out.println("꺄울");
						}
						break;
					}else if(j == 5) {
						green[numLine[1]][j] = 1;
						int count = 0;
						for(int k = 0 ; k < 4 ; k++) {
							if(green[k][j] == 1) {
								count = count + 1;
							}
						}
						if(count == 4) {
							System.out.println("꺄울");
						}
					}
				}
			}else if(numLine[0] == 2) {
				
//				blue 타일 확인
				for(int j = 0 ; j < 6 ; j++) {
					
					if(blue[j][numLine[1]] != 0) {
						blue[j-1][numLine[1]] = 1;
						blue[j-2][numLine[1]] = 1;
						int count = 0;
						for(int k = 0 ; k < 4 ; k++) {
							if(blue[j-1][k] == 1) {
								count = count + 1;
							}
						}
						if(count == 4) {
							System.out.println("꺄울");
						}
						break;
					}else if(j == 5) {
						blue[j][numLine[1]] = 1;
						blue[j-1][numLine[1]] = 1;
						int count = 0;
						for(int k = 0 ; k < 4 ; k++) {
							if(blue[j][k] == 1) {
								count = count + 1;
							}
						}
						if(count == 4) {
							System.out.println("꺄울");
						}
						break;
					}
				}
				
//				green 타일 확인
				for(int j = 0 ; j < 6 ; j++) {
					if(green[numLine[2]][j] != 0) {
						green[numLine[2]][j-1] = 1;
						green[numLine[2]+1][j-1] = 1;
						int count = 0;
						for(int k = 0 ; k < 4 ; k++) {
							if(green[k][j-1] == 1) {
								count = count + 1;
							}
						}
						if(count == 4) {
							System.out.println("꺄울");
						}
						break;
					}else if(j == 5) {
						green[numLine[2]][j] = 1;
						green[numLine[2]+1][j] = 1;
						int count = 0;
						for(int k = 0 ; k < 4 ; k++) {
							if(green[k][j] == 1) {
								count = count + 1;
							}
						}
						if(count == 4) {
							System.out.println("꺄울");
						}
					}
				}
			}else if(numLine[0] == 3) {
				
			}
			
			System.out.println("X X X X " + blue[0][0] + " " + blue[1][0] + " " + blue[2][0] + " " + blue[3][0] + " " + blue[4][0] + " " + blue[5][0] + "\n" + 
					   "X X X X " + blue[0][1] + " " + blue[1][1] + " " + blue[2][1] + " " + blue[3][1] + " " + blue[4][1] + " " + blue[5][1] + "\n" + 
					   "X X X X " + blue[0][2] + " " + blue[1][2] + " " + blue[2][2] + " " + blue[3][2] + " " + blue[4][2] + " " + blue[5][2] + "\n" + 
					   "X X X X " + blue[0][3] + " " + blue[1][3] + " " + blue[2][3] + " " + blue[3][3] + " " + blue[4][3] + " " + blue[5][3] + "\n" +
						green[0][0] + " " + green[1][0] + " " + green[2][0] + " " + green[3][0] + "\n" +
						green[0][1] + " " + green[1][1] + " " + green[2][1] + " " + green[3][1] + "\n" +
						green[0][2] + " " + green[1][2] + " " + green[2][2] + " " + green[3][2] + "\n" +
						green[0][3] + " " + green[1][3] + " " + green[2][3] + " " + green[3][3] + "\n" +
						green[0][4] + " " + green[1][4] + " " + green[2][4] + " " + green[3][4] + "\n" +
						green[0][5] + " " + green[1][5] + " " + green[2][5] + " " + green[3][5] + "\n");
			
		}
		
		
	}
	
}
