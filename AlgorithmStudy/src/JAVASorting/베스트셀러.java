package JAVASorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class 베스트셀러 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int firstNum = Integer.parseInt(scan.nextLine());
		ArrayList<String> testList = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		
		for(int i = 0 ; i < firstNum ; i++) {
			testList.add(scan.nextLine());
		}

		Set<String> setList = new HashSet<String>(testList);
		Iterator<String> setIter = setList.iterator();
		
		for(int i = 0 ; i < setList.size() ; i++) {
			System.out.println(Collections.frequency(testList, setIter.next()));
		}
	}

}
