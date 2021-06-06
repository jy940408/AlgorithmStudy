package JAVABruteForce;

import java.util.ArrayList;
import java.util.Scanner;

public class 블랙잭 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String firstLine_1 = scan.nextLine();
		
		String[] firstLine_2 = firstLine_1.split(" ");
		
		int[] firstLine = new int[2];
		for(int i = 0 ; i < 2 ; i++) {
			firstLine[i] = Integer.parseInt(firstLine_2[i]);
		}
		
		String secondLine_1 = scan.nextLine();
		
		String[] secondLine_2 = secondLine_1.split(" ");
		
		ArrayList secondLine = new ArrayList();
		
		for(int i = 0 ; i < secondLine_2.length ; i++) {
			secondLine.add(Integer.parseInt(secondLine_2[i]));
		}
		
		ArrayList sumList = new ArrayList();
		ArrayList sumList_1 = new ArrayList();
		ArrayList sumList_2 = new ArrayList();
		
		for(int i = 0 ; i < secondLine.size() ; i++) {
			//첫번째 숫자
			int sum_1 = (int)(secondLine.get(i));
			//두번째 더해질 숫자의 목록
			sumList_1.clear();
			for(int j = i ; j < secondLine.size() ; j++ ) {
				if(j != i) {
					sumList_1.add(secondLine.get(j));
				}
			}
			//두번째 숫자까지의 합
			for(int k = 0 ; k < sumList_1.size() ; k++) {
				//두번째 숫자까지의 합
				int sum_2 = sum_1 + (int)(sumList_1.get(k));
				
				//세번째 더해질 숫자의 목록
				sumList_2.clear();
				for(int l = 0 ; l < sumList_1.size() ; l++) {
					if(l != i && l != k) {
						sumList_2.add(sumList_1.get(l));
					}
				}
				//세번째 숫자까지의 합
				for(int m = 0 ; m < sumList_2.size() ; m++) {
					int sum_3 = sum_2 + (int)(sumList_2.get(m));
					sumList.add(sum_3);
				}
			}
		}
		
		int resultNum = 0;
		for(int i = 0 ; i < sumList.size() ; i++) {
			if((int)(sumList.get(i)) <= firstLine[1]) {
				if((int)(sumList.get(i)) > resultNum){
					resultNum = (int)(sumList.get(i));
				}
			}
		}
		
		System.out.println(resultNum);
	}

}
