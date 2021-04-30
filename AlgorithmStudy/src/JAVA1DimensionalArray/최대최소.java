package JAVA1DimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class 최대최소 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int i = scan.nextInt();
		int[] j = new int[i];
		scan.nextLine();
		String k = scan.nextLine();
		String[] m = k.split(" ");
		
		for(int l = 0 ; l < i ; l++) {
			j[l] = Integer.parseInt(m[l]);
		}
		
		Arrays.sort(j);
		int min = j[0];
		int max = j[(i-1)];
		
		System.out.println(min + " " + max);
	}
}
