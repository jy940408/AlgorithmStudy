package JAVAwhile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class A더하기B다시5 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int i = 1;
		int j = 1;
		
		ArrayList resultSum = new ArrayList();
		
		while(i != 0 && j != 0) {
			
			String s = scan.nextLine();

			String[] test = s.split(" ");
			
			i = Integer.parseInt(test[0]);
			j = Integer.parseInt(test[1]);
			
			if(i != 0 && j != 0) {
				resultSum.add(i+j);
			}
		}
		
		Iterator result = resultSum.iterator();
		
		while(result.hasNext()) {
			System.out.println(result.next());
		}
		
	}
	
}
