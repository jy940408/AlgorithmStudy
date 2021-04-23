package Àç±Í;

import java.util.Scanner;

public class ÆÑÅä¸®¾ó {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int k = 1;
		if(i > 0 && i <= 12) {
			for(int j = 1 ; j < i ; j++) {
				k = k * (j + 1);
			}
			System.out.println(k);
		}else if(i == 0){
			System.out.println(1);
		}
		
	}

}
