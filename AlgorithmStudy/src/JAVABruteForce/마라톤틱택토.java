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
		
		loop1:
		for(int i = 0 ; i < firstNum ; i++) {
			for(int j = 0 ; j < firstNum ; j++) {
				if(!unit[i][j].equals(".")) {
					if(j != 0 && unit[i][j].equals(unit[i][j-1])) {
						if(j == firstNum-1) {
							result = unit[i][j];
							break loop1;
						}
					}else if(j != 0 && unit[j][i].equals(unit[j-1][i])) {
						if(j == firstNum-1) {
							result = unit[j][i];
							break loop1;
						}
					}else if(j != 0 && !unit[j][i].equals(unit[j-1][i])) {
						break;
					}
				}
			}
			if(!unit[i][i].equals(".")) {
				if(i != 0 && unit[i][i].equals(unit[i-1][i-1])) {
					if(i == firstNum-1) {
						result = unit[i][i];
						break;
					}
				}else if(i != 0 && !unit[i][i].equals(unit[i-1][i-1])) {
					break;
				}else if(i != 0 && unit[firstNum-(i+1)][i].equals(unit[firstNum-(i+1)-1][i-1])) {
					if(firstNum - (i+1) == 0) {
						result = unit[i][i];
						break;
					}
				}else if(i != 0 && !unit[i][i].equals(unit[i-1][i-1])) {
					break;
				}
			}
			
		}
		
		System.out.println("result: " + result);
		
	}

}
