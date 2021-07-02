package JAVASorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 보물 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int firstNum = Integer.parseInt(scan.nextLine());
		
		String[] firstLine_ = new String[firstNum];
		String[] secondLine_ = new String[firstNum];
		
		int[] firstLine = new int[firstNum];
		ArrayList<Integer> secondLine = new ArrayList<Integer>();
		ArrayList<Integer> copyLine = new ArrayList<Integer>();
		
		ArrayList<Integer> compareLine = new ArrayList<Integer>();
		
		for(int i = 0 ; i < firstNum ; i++) {
			firstLine[i] = Integer.parseInt(firstLine_[i]);
			secondLine.add(Integer.parseInt(secondLine_[i]));
			copyLine.add(secondLine.get(i));
		}
		
		Collections.sort(copyLine, Collections.reverseOrder());
		
		for(int i = 0 ; i < firstNum ; i++) {
			for(int j = 0 ; j < firstNum ; j++) {
				if(secondLine.get(i) == copyLine.get(j)) {
					compareLine.add(i);
				}
			}
		}
		
		int result = 0;
		
		for(int i = 0 ; i < firstNum ; i++) {
			
		}
		
		System.out.println(result);

	}

}
