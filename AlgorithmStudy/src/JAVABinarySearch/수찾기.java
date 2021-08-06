package JAVABinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int firstNum = scan.nextInt();
		int[] firstLine = new int[firstNum];
		for(int i = 0 ; i < firstNum ; i++) {
			firstLine[i] = scan.nextInt();
		}
		
		Arrays.sort(firstLine);
		
		int secondNum = scan.nextInt();
		for(int i = 0 ; i < secondNum ; i++) {
			System.out.println(binarySearch(firstLine, scan.nextInt()));
		}
		
	}
	
	static int binarySearch(int[] firstLine, int secondNum) {
		
		int first = 0;
		int last = (firstLine.length - 1);
		int mid = 0;
		
		while(first <= last) {
			
			mid = (first + last)/2;
			
			if(secondNum == firstLine[mid]) {
				return 1;
			}else {
				if(secondNum < firstLine[mid]) {
					last = mid - 1;
				}else {
					first = mid + 1;
				}
			}
			
		}
		
		return 0;
	}

}
