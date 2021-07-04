package JAVAImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 피자 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int firstNum = Integer.parseInt(scan.nextLine());
		
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		int result = 0;
		
		for(int i = 0 ; i < firstNum ; i++) {
			
			String[] listString = (scan.nextLine()).split("/");
			
			if(listString[1].equals("4")) {
				resultList.add(Integer.parseInt(listString[0]));
			}else if(listString[1].equals("2")) {
				resultList.add(Integer.parseInt(listString[0])*2);
			}
		}
		
		System.out.println("resultList: " + resultList);
		
		int one = Collections.frequency(resultList, 1);
		int two = Collections.frequency(resultList, 2);
		int three = Collections.frequency(resultList, 3);
		
		System.out.println("one: " + one + ", two: " + two + ", three: " + three);
		
		if(one > 0) {
			if(three != 0) {
				result += three;
				if(three <= one) {
					one = one - three;
				}else if(three > one) {
					one = 0;
				}
			}
			if(two != 0) {
				if(two%2 != 0) {
					result += two/2;
					two = two%2;
					if(one >= 2) {
						result += 1;
						one = one - 2;
					}else if(one < 2) {
						result += 1;
						one = 0;
					}
				}else if(two%2 == 0) {
					result += two/2;
				}
			}
			
			if(one%4 != 0) {
				result += one/4 + 1;
			}else if(one%4 == 0) {
				result += one/4;
			}
			
		}else if(one == 0) {
			if(three != 0) {
				result += three;
			}
			if(two != 0) {
				result += two/2 + two%2;
			}
		}
		
		System.out.println(result);
	}

}
