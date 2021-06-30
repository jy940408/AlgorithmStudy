package JAVASorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 베스트셀러 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int firstNum = Integer.parseInt(scan.nextLine());
		ArrayList<String> testList = new ArrayList<String>();
		ArrayList<String> wordList = new ArrayList<String>();
		ArrayList<Integer> wordNum = new ArrayList<Integer>();
		
		for(int i = 0 ; i < firstNum ; i++) {
			String testWord = scan.nextLine();
			testList.add(testWord);
			if(!wordList.contains(testWord)) {
				wordList.add(testWord);
			}
		}
		
		Collections.sort(wordList);
		
		for(int i = 0 ; i < wordList.size() ; i++) {
			wordNum.add(Collections.frequency(testList, wordList.get(i)));
		}
		
		int max = Collections.max(wordNum);
		
		System.out.println(wordList.get(wordNum.indexOf(max)));
		
	}

}
