package JAVAImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 욱제는결벽증이야 {
	
	public static ArrayList orderList(int [] orderList, int[] list, ArrayList printList) {
	
//		testLists = 내가 테스트 해야할 리스트
//		list = 정렬된 리스트(정답)
		
//		orderList의 첫번째가 첫번째 칸에 없다면 바꿔주기

		ArrayList lastList = new ArrayList<>();
		
		for(int i = 0 ; i < orderList.length ; i++) {
			for(int j = 0 ; j < orderList.length ; j ++) {
				if(list[i] == orderList[j]) {
					printList.add(j+1);
					lastList.add(j+1);
				}
			}
		}
		
		ArrayList solveList = new ArrayList<>();
		
		for(int i = 0 ; i < printList.size() ; i++) {
			if(lastList.indexOf(i+1) != i) {
//				j는 내가 바꿔야할 숫자 목록에서 현재 위치 
				int j = i+1;
//				k는 현재 위치에 원래 와야할 숫자가 있는 위치
				int k = lastList.indexOf(i+1)+1;
				
				for(int l = 0 ; l < (k-j+1)/2 ; l++) {
					
					lastList.set(j-1+l, printList.get(k-1-l));
					lastList.set(k-1-l, printList.get(j-1+l));
					
					printList.set(j-1+l, lastList.get(j-1+l));
					printList.set(k-1-l, lastList.get(k-1-l));
			
					if(l == 0) {
						solveList.add((j+l) + " " + (k-l));
					}
				}
			}
		}
		
		System.out.println(solveList.size());
		
		if(solveList.size() != 0) {
			for(int i = 0 ; i < solveList.size() ; i++) {
				System.out.println(solveList.get(i));
			}
		}
			
		return printList;
	}
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int i = Integer.parseInt(scan.nextLine());
		String[] j_ = (scan.nextLine()).split(" ");
		
		int[] j = new int[j_.length];
		int[] orderList = new int[j_.length];
		
		for(int k = 0 ; k < j.length ; k++) {
			j[k] = Integer.parseInt(j_[k]);
			orderList[k] = Integer.parseInt(j_[k]);
		}
		
		Arrays.sort(orderList);
		
		ArrayList printList = new ArrayList<>();
		
		printList = orderList(orderList, j, printList);
	}

}
