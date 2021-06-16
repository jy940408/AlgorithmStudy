package JAVABruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 한국이그리울땐서버에접속하지 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int amountNum = Integer.parseInt(scan.nextLine());
		String pattern = scan.nextLine();
		ArrayList<String> patternString = new ArrayList<String>(Arrays.asList(pattern.split("")));
		
		String[] resultList = new String[amountNum];
		
		String[] testLine = new String[amountNum];
		for(int i = 0 ; i < amountNum ; i++) {
			testLine[i] = scan.nextLine();
		}

		for(int i = 0 ; i < amountNum ; i++) {
			ArrayList<String> testString = new ArrayList<String>(Arrays.asList(testLine[i].split("")));
			
			root1:
			for(int j = 0, k = 0 ; j < patternString.size() ; j++, k++) {
				if(!patternString.get(j).equals(testString.get(k)) && !(patternString.get(j)).equals("*")) {
					resultList[i] = j + " " + patternString.get(j) + " " + k + " " + testString.get(k) + " 1 NE";
					break;
				}else if((patternString.get(j)).equals("*") && j == (patternString.size()-1)) {
					resultList[i] = j + " " + patternString.get(j) + " " + k + " " + testString.get(k) + " 2 DA";
					break;
				}else if((patternString.get(j)).equals("*") && j != (patternString.size()-1)) {
					for(int l = 0 ; l < testString.size()-k ; l++ ) {
						if(patternString.get(j+1).equals(testString.get(k+l))) {
							System.out.println(k + " " + l);
							k = k + l-1;
							break;
						}else if(l == ((testString.size()-k)-1) && !patternString.get(j+1).equals(testString.get(k+l))) {
							resultList[i] = j + " " + patternString.get(j) + " " + k + " " + testString.get(k) +  " 4 NE";
							break root1;
						}
					}
				}else if(patternString.get(j).equals(testString.get(k)) && j == (patternString.size()-1)) {
					resultList[i] = j + " " + patternString.get(j) + " " + k + " " + testString.get(k) + " 5 DA";
					break;
				}
			}
			
		}
		
		for(int i = 0 ; i < resultList.length ; i++) {
			System.out.println(resultList[i]);
		}

	}

}
