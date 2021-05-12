package JAVArecursive;

import java.util.ArrayList;
import java.util.Scanner;

public class 카드놓기 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		ArrayList firstList = new ArrayList();
		
		int i = scan.nextInt();
		int j = scan.nextInt();
		
		System.out.println("i 값: " + i);
		System.out.println("j 값: " + j);
		
		for(int k = 0 ; k < i ; k++) {
		
			firstList.add(scan.nextInt());
			
		}
		
		System.out.println("list 값: " + firstList);
		
		ArrayList secondList = firstCombi(firstList, j);
		
		System.out.println("두번째 배열 확인: " + secondList);
		
//		조합을 뽑고
//		그 조합과 같은 조합이 있는지 확인하고
//		같은 조합이 없을 시, 조합 내에서 다시 숫자를 배열하고,
//		배열한 값 중에서 중복된 값이 없는 경우, 숫자를 세고,
//		그렇게 나온 갯수의 값들을 합하면 됨

//		n개의 숫자에서 k개의 숫자를 뽑았을 때 나올 수 있는 조합을 모두 구하는 방법
	}
	
	public static ArrayList firstCombi(ArrayList firstList, int j) {
		
		ArrayList secondList = new ArrayList();
		ArrayList thirdList = new ArrayList();
		
		for(int i = 0 ; i < j ; i++) {
			for(int k = 0 ; k < firstList.size() ; k++) {
			}
		}
		
		return secondList;
	}

}
