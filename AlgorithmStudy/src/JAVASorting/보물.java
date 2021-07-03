package JAVASorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 보물 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int firstNum = Integer.parseInt(scan.nextLine());
		
		String[] firstLine_ = scan.nextLine().split(" ");
		String[] secondLine_ = scan.nextLine().split(" ");
		
		ArrayList<Integer> firstLine = new ArrayList<Integer>();
		ArrayList<Integer> secondLine = new ArrayList<Integer>();
		ArrayList<Integer> copyLine = new ArrayList<Integer>();
		ArrayList<Integer> compareLine = new ArrayList<Integer>();
		
		for(int i = 0 ; i < firstNum ; i++) {
			firstLine.add(Integer.parseInt(firstLine_[i]));
			secondLine.add(Integer.parseInt(secondLine_[i]));
			copyLine.add(secondLine.get(i));
		}
		
		Collections.sort(copyLine);
		Collections.sort(firstLine, Collections.reverseOrder());
		
		int result = 0;
		
		for(int i = 0 ; i < firstNum ; i++) {
			for(int j = 0 ; j < firstNum ; j++) {
				if(secondLine.get(i) == copyLine.get(j) && !compareLine.contains(j)) {
					result = result + (firstLine.get(j) * secondLine.get(i));
					compareLine.add(j);
				}
			}
		}
		
		System.out.println(result);
		
	}

}
