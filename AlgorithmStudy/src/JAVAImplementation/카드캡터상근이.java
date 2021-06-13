package JAVAImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 카드캡터상근이 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int cardAmount = Integer.parseInt(scan.nextLine());
		
//		모든 카드
		int[] allCard = new int[cardAmount*2];
		for(int i = 0 ; i < cardAmount*2 ; i++) {
			allCard[i] = i+1;
		}
		
//		상근이 카드
		ArrayList cardValue_1 = new ArrayList<>();
		for(int i = 0 ; i < cardAmount ; i++) {
			cardValue_1.add(Integer.parseInt(scan.nextLine()));
		}
		Collections.sort(cardValue_1);
		
//		근상이 카드
		ArrayList cardValue_2 = new ArrayList<>();
		for(int i = 0 ; i < cardAmount*2 ; i++) {
			int check = 0;
			for(int j = 0 ; j < cardAmount ; j++) {
				if(allCard[i] == (int)cardValue_1.get(j)) {
					check = check + 1;
				}else {
				}
			}
			if(check == 0) {
				cardValue_2.add(allCard[i]);
			}
		}
		Collections.sort(cardValue_2);
		
		System.out.println("cardValue_1: " + cardValue_1);
		System.out.println("cardValue_2: " + cardValue_2);
		
		int versus = 0; 
		int count_1 = 0;
		int count_2 = 0;
		int[] point = new int[2];
		while(cardValue_1.size() != 0 && cardValue_2.size() != 0) {
//			맨 처음
			if(cardValue_1.size() == cardAmount) {
				versus = (int)cardValue_1.get(0);
				cardValue_1.remove(0);
				count_1 = count_1 + 1;
				System.out.println("맨 처음: cardValue_1: " + cardValue_1 + ", cardValue_2: " + cardValue_2 + ", versus: " + versus);
//			근상이 차례
			}else if(cardValue_1.size() != 5 && count_1 > count_2) {
				for(int i = 0 ; i < cardValue_2.size() ; i++) {
					if((int)cardValue_2.get(i) > versus) {
						versus = (int)cardValue_2.get(i);
						cardValue_2.remove(i);
						break;
					}else if(i == cardValue_2.size()-1 && (int)cardValue_2.get(i) < versus) {
						versus = 0;
					}
				}
				System.out.println("근상이 차례: cardValue_1: " + cardValue_1 + ", cardValue_2: " + cardValue_2 + ", versus: " + versus);
				count_2 = count_2 + 1;
//			상근이 차례
			}else if(cardValue_1.size() != cardAmount && count_1 == count_2) {
				for(int i = 0 ; i < cardValue_1.size() ; i++) {
					if((int)cardValue_1.get(i) > versus) {
						versus = (int)cardValue_1.get(i);
						cardValue_1.remove(i);
						break;
					}else if(i == cardValue_1.size()-1 && (int)cardValue_1.get(i) < versus) {
						versus = 0;
					}
				}
				System.out.println("상근이 차례: cardValue_1: " + cardValue_1 + ", cardValue_2: " + cardValue_2 + ", versus: " + versus);
				count_1 = count_1 + 1;
			}
		}
		
		System.out.println("cardValue_1: " + cardValue_1);
		System.out.println("cardValue_2: " + cardValue_2);
		
		point[0] = cardValue_2.size();
		point[1] = cardValue_1.size();
		
		for(int i = 0 ; i < 2 ; i++) {
			System.out.println(point[i]);
		}
	}
	
}
