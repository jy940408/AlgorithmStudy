package JAVArecursive;

import java.util.Scanner;

public class 피보나치수5 {

	public static int fibonacci(int[] numList) {
		
		int result = 0;
		
		for(int j = 2 ; j < numList.length ; j++) {
			if(numList[j] == 0) {
				numList[j] = (numList[j-1] + numList[j-2]);
				fibonacci(numList);
				result = numList[j];
			}else if(j == (numList.length-1)){
				result =  numList[j];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int scanNum = scan.nextInt();
		int[] numList = new int[(scanNum+1)];
		int result = 0;
		if(scanNum > 1) {
			numList[0] = 0;
			numList[1] = 1;
			result = fibonacci(numList);
		}else if(scanNum == 1) {
			result = 1;
		}else if(scanNum == 0) {
			result = 0;
		}
		 
		System.out.println(result);
	}

}
