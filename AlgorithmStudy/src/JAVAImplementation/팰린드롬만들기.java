package JAVAImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 팰린드롬만들기 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] firstLine_ = (scan.nextLine()).split("");
		ArrayList<String> firstLine = new ArrayList<String>(Arrays.asList(firstLine_));
		
		ArrayList<String> testString = (ArrayList<String>) firstLine.stream().distinct().collect(Collectors.toList());
		Collections.sort(testString);
		
		int testNum = 0;
		String midString = "";
		String result = "";
		
		for(int i = 0 ; i < testString.size() ; i++) {
			
			int stringNum = Collections.frequency(firstLine, testString.get(i));
			
			System.out.println("testString: " + testString.get(i) + ", stringNum: " + stringNum);
			
			if(stringNum%2 == 1) {
				testNum += 1;
				midString = testString.get(i);
				if(testNum > 1) {
					System.out.println("I'm Sorry Hansoo");
					break;
				}
			}
			
			for(int j = 0 ; j < stringNum/2 ; j++) {
				result += testString.get(i);
				System.out.println("result: " + result);
			}
			
			StringBuffer sb = new StringBuffer(result);
			String reversedResult = sb.reverse().toString();
			
			if(i == testString.size()-1) {
				result = result + midString + reversedResult;
				System.out.println(result);
			}
			
		}
	}

}
