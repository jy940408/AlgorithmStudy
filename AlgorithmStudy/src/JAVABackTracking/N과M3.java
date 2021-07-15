package JAVABackTracking;

import java.util.Scanner;

public class N과M3 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String[] firstLine = (scan.nextLine()).split(" ");
		
		int lastNum = Integer.parseInt(firstLine[0]);
		int amount = Integer.parseInt(firstLine[1]);
		
		int count = 0;
		String result = "";
		
		count(lastNum, amount, result, count);
		
	}
	
	public static void count(int lastNum, int amount, String result, int count) {
		
		count += 1;
		for(int i = 0 ; i < lastNum ; i++) {
			result += i + " ";
			if(count == amount) {
				System.out.println("result: " + result + ", count: " + count);
				result = "";
			}else {
				count(lastNum, amount, result, count);
			}
			
		}
		
	}

}
