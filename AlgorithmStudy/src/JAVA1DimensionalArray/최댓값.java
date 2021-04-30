package JAVA1DimensionalArray;

import java.util.Scanner;

public class 최댓값 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] k = new int[9];
		
		for(int i = 0 ; i < 9 ; i++) {
			int j = scan.nextInt();
			k[i] = j;
		}
		
		int max = k[0];
		
		for(int i = 0 ; i < 9 ; i++) {
			if(max < k[i]) {
				max = k[i];
			}
		}
		System.out.println(max);
		
		int i = 0;
		
		while(max != k[i]){
			i++;
		}
		System.out.println((i+1));
	}

}
