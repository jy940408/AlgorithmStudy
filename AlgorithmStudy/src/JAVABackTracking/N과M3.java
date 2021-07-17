package JAVABackTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N과M3 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		
		String[] firstLine = (scan.nextLine()).split(" ");
		
		scan.close();
		
		int lastNum = Integer.parseInt(firstLine[0]);
		int amount = Integer.parseInt(firstLine[1]);
		
		int count = 0;
		int[] result = new int[amount];
		
		count(lastNum, amount, result, count);
		
	}
	
	public static void count(int lastNum, int amount, int[] result, int count) throws IOException {
		
		if(count == amount) {
			
			for(int i = 0 ; i < amount ; i++) {
				bw.write(Integer.toString(result[i]) + " ");
			}
			
			bw.newLine();
			bw.flush();
			
			return;
		}
		
		for(int i = 1 ; i <= lastNum ; i++) {
			
			System.out.println("amount: " + amount + ", count: " + count);
			result[count] = i;
			count(lastNum, amount, result, count + 1);
			
		}
	
		return;
		
	}

}
