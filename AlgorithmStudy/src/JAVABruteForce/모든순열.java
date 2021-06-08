package JAVABruteForce;

import java.util.ArrayList;
import java.util.Scanner;

public class 모든순열 {

	public static void numList() {
		
//		for문 반복해서 돌리기
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
//		처음 입력한 숫자
		int firstLine = scan.nextInt();
//		순열 총 갯수
		int allRound = 1;
//		순열만들 담아둘 배열
		ArrayList numList = new ArrayList<>();
		
		for(int i = 1 ; i <= firstLine ; i++) {
			allRound = allRound * i;
			numList.add(i);
		}
		
//		지금까지 사용한 숫자 목록
		ArrayList useList = new ArrayList<>();
//		만들어진 순열 목록
		ArrayList makeList = new ArrayList<>();
		
		System.out.println("allRound: " + allRound);
		System.out.println("numList: " + numList);
		
		for(int i  = 1 ; i <= 3 ; i++) {
			for(int j = 1 ; j <= 3 ; j++) {
				if(i != j) {
					for(int k = 1 ; k <= 3 ; k++) {
						if(i != k && j != k) {
							System.out.println(i + " " + j + " " + k);
						}
					}
				}
			}
		}
		
	}

}
