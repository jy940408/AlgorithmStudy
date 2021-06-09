package JAVAImplementation;

import java.util.Scanner;

public class 사이나쁜여왕들 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String[] chess = new String[8];
		int[] queenNum = new int[8];
		
		String result = "valid";
		
		for(int i = 0 ; i < 8 ; i++) {
			chess[i] = scan.nextLine();
			String[] queenLine = chess[i].split("");
			for(int j = 0 ; j < 8 ; j++) {
				if(queenLine[j].equals("*") && queenNum[i] == 0) {
					queenNum[i] = (j+1);
				}else if(i != j && queenLine[j].equals("*") && queenNum[i] != 0) {
					result = "invalid";
				}
			}
			if(queenNum[i] == 0) {
				result = "invalid";
			}
			
		}
		
		for(int i = 0 ; i < 8 ; i++) {
			for(int j = 0 ; j < 8 ; j++) {
				if(i != j && queenNum[i] == queenNum[j]) {
					result = "invalid";
				}else if(i != j && j > i && (queenNum[j] == (queenNum[i] + (j-i)))) {
					result = "invalid";
				}else if(i != j && j > i && (queenNum[j] == (queenNum[i] - (j-i)))) {
					result = "invalid";
				}
			}
		}
		
		for(int i = 0 ; i< 8 ; i++) {
			System.out.println("chess[" + i + "]: " + chess[i]);
		}
		
		for(int i = 0 ; i< 8 ; i++) {
			System.out.println((i+1) + "번째 퀸 위치: " + queenNum[i]);
		}
		
		System.out.println("result: " + result);
		
	}
	
}
