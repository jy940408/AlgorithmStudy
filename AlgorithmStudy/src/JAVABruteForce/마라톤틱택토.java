package JAVABruteForce;

import java.util.Scanner;

public class 마라톤틱택토 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int firstNum = Integer.parseInt(scan.nextLine());
		String[][] unit = new String[firstNum][firstNum];
		
		String result = "ongoing";
		
		for(int i = 0 ; i < firstNum ; i++) {
			String[] secondList = scan.nextLine().split("");
			for(int j = 0 ; j < firstNum ; j++) {
				unit[i][j] = secondList[j];
			}
		}
		
//		가로 확인
		loop1:
		for(int i = 0 ; i < firstNum ; i++) {
			for(int j = 0 ; j < firstNum ; j++) {
				if(!unit[i][j].equals(".")) {
					if(j != 0 && unit[i][j].equals(unit[i][j-1])) {
						if(j == firstNum-1) {
							result = unit[i][j];
							break loop1;
						}
					}else if(j != 0 && !unit[i][j].equals(unit[i][j-1])) {
						break;
					}
				}
			}
		}
		
//		세로 확인
		loop1:
		for(int i = 0 ; i < firstNum ; i++) {
			for(int j = 0 ; j < firstNum ; j++) {
				if(!unit[j][i].equals(".")) {
					if(j != 0 && unit[j][i].equals(unit[j-1][i])) {
						if(j == firstNum-1) {
							result = unit[j][i];
							break loop1;
						}
					}else if(j != 0 && !unit[j][i].equals(unit[j-1][i])) {
						break;
					}
				}
			}
		}
		
//		대각선 확인(좌->우)
		for(int i = 0 ; i < firstNum ; i++) {
			if(!unit[i][i].equals(".")) {
				if(i != 0 && unit[i][i].equals(unit[i-1][i-1])) {
					if(i == firstNum-1) {
						result = unit[i][i];
						break;
					}
				}else if(i != 0 && !unit[i][i].equals(unit[i-1][i-1])) {
					break;
				}
			}
		}

//		대각선 확인(우->좌)
		loop1:
		for(int i = firstNum-1 ; i >= 0 ; i--) {
			for(int j = 0 ; j < firstNum ; j++) {
				if(!unit[i][j].equals(".")) {
					if(i != firstNum-1 && j != 0 && unit[i][j].equals(unit[i+1][j-1])) {
						if(i == 0 && j == firstNum-1) {
							result = unit[i][j];
							break loop1;
						}
					}else if(i != firstNum-1 && j != 0 && !unit[i][j].equals(unit[i+1][j-1])) {
						break;
					}
				}
			}
		}
		
		System.out.println("result: " + result);
		
	}

}
