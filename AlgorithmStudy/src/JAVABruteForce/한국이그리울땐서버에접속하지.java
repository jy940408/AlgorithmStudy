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
				
				if(k < testString.size()) {
					if(j != patternString.size()-1 && k != testString.size()-1 && patternString.get(j).equals(testString.get(k)) && !patternString.equals("*")) {
						System.out.println("여기"+patternString.get(j) + " " + testString.get(k));
					}else if(patternString.get(j).equals("*")) {
						if(j == patternString.size()-1) {
							resultList[i] = "DA";
							break;
						}else {
							System.out.println("여기");
							for(int l = testString.size()-k-1 ; l >= 0 ; l-- ) {	
								if(patternString.get(j+1).equals(testString.get(k+l)) && !patternString.get(j+1).equals(testString.get(k+l-1))) {
									System.out.println("여기"+patternString.get(j+1) + " " + testString.get(k+l-1) + " " + k);
									k = k + l-1;
									break;
								}else if(l == ((testString.size()-k)-1) && patternString.get(j+1).equals(testString.get(k+l)) && !patternString.get(j+1).equals(testString.get(k+l-1))) {
									resultList[i] = "NE";
									System.out.println("이거?"+patternString.get(j+1) + " " + testString.get(k+l) + " " + (k+l));
									break root1;
								}else if((j+1) == patternString.size()-1&& l == ((testString.size()-k)-1) && patternString.get(j+1).equals(testString.get(k+l)) && !patternString.get(j+1).equals(testString.get(k+l-1))) {
									resultList[i] = "NE";
									System.out.println("이거?"+patternString.get(j+1) + " " + testString.get(k+l) + " " + (k+l));
									break root1;
								}
							}
						}
					}else if(j == patternString.size()-1 && k == testString.size()-1 && patternString.get(j).equals(testString.get(k)) && !patternString.equals("*")) {
						System.out.println(patternString.get(j) + " " + testString.get(k));
						resultList[i] = "DA";
						break;
					}
				}else if(k >= testString.size()) {
					if(j == patternString.size()-1 && patternString.get(j).equals("*")) {
						resultList[i] = "DA";
						break;
					}else {
						resultList[i] = "NE";
						break;
					}
				}
			}
			
		}
		
		for(int i = 0 ; i < resultList.length ; i++) {
			System.out.println(resultList[i]);
		}



	}

}
