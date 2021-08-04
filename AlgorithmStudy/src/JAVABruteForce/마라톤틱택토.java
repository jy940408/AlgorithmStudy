package JAVABruteForce;

import java.util.Scanner;

public class 마라톤틱택토 {

	static String winner = "";
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int firstNum = Integer.parseInt(scan.nextLine());
		String[][] unit = new String[firstNum][firstNum];
		
		String result = "ongoing";
		
		for(int i = 0 ; i < firstNum ; i++) {
			String[] secondList = scan.nextLine().split("");
			for(int j = 0 ; j < firstNum ; j++) {
				unit[i][j] = secondList[j];
				System.out.println("unit[" + i + "][" + j + "]: " + unit[i][j] + ", boardCheck: " + boardCheck(i, j, (firstNum-1), "rightDown"));
			}
		}
		
		for(int i = 0 ; i < firstNum ; i++) {
			for(int j = 0 ; j < firstNum; j++) {
//				가로 확인
				if(boardCheck(i, j, (firstNum-1), "row")) {
					System.out.println(i + " " + j);
					if(!unit[i][j].equals(".")) {
						if(unit[i][j].equals(unit[i][j+1]) && unit[i][j].equals(unit[i][j+2])) {
							System.out.println("가로: " + i + " " + j);
							if(winner.equals("") || winner.equals(unit[i][j])) {
								winner = unit[i][j];
							}else {
								winner = "incorrect";
							}
						}
					}
				}
				
//				세로 확인
				if(boardCheck(i, j, (firstNum-1), "col")) {
					if(!unit[i][j].equals(".")) {
						if(unit[i][j].equals(unit[i+1][j]) && unit[i][j].equals(unit[i+2][j])) {
							System.out.println("세로: " + i + " " + j);
							if(winner.equals("") || winner.equals(unit[i][j])) {
								winner = unit[i][j];
							}else {
								winner = "incorrect";
							}
						}
					}
				}
				
//				우하 확인
				if(boardCheck(i, j, (firstNum-1), "rightDown")) {
					if(!unit[i][j].equals(".")) {
						if(unit[i][j].equals(unit[i+1][j+1]) && unit[i][j].equals(unit[i+2][j+2])) {
							System.out.println("우하: " + i + " " + j);
							if(winner.equals("") || winner.equals(unit[i][j])) {
								winner = unit[i][j];
							}else {
								winner = "incorrect";
							}
						}
					}
				}
				
//				우상 확인
				if(boardCheck(i, j, (firstNum-1), "rightUp")) {
					if(!unit[i][j].equals(".")) {
						if(unit[i][j].equals(unit[i-1][j+1]) && unit[i][j].equals(unit[i-2][j+2])) {
							System.out.println("우상: " + i + " " + j);
							if(winner.equals("") || winner.equals(unit[i][j])) {
								winner = unit[i][j];
							}else {
								winner = "incorrect";
							}
						}
					}
				}
				
			}
		}
		
		if(winner.equals("incorrect") || winner.equals("")) {
			System.out.println(result);
		}else {
			result = winner;
			System.out.println(result);
		}
		
	}
	
	public static boolean boardCheck(int i, int j, int firstNum, String direction) {
		
		if(direction.equals("col")) {
			if((i+2) <= firstNum) {
				return true;
			}
		}else if(direction.equals("row")) {
			if((j+2) <= firstNum) {
				return true;
			}
		}else if(direction.equals("rightUp")) {
			if((i-2) >= 0 && (j+2) <= firstNum) {
				return true;
			}
		}else if(direction.equals("rightDown")) {
			if((i+2) <= firstNum && (j+2) <= firstNum ) {
				return true;
			}
		}
		
		return false;
		
	}
	

}
