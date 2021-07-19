package JAVABackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N과M3 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] firstLine = (br.readLine()).split(" ");
		
		br.close();
		
		int lastNum = Integer.parseInt(firstLine[0]);
		int amount = Integer.parseInt(firstLine[1]);
		
		int count = 0;
		int[] result = new int[amount];
		
		count(lastNum, amount, result, count);
		
		bw.flush();
		
	}
	
	public static void count(int lastNum, int amount, int[] result, int count) throws IOException {
		
		if(count == amount) {
			
			for(int i = 0 ; i < amount ; i++) {
				bw.write(Integer.toString(result[i]) + " ");
			}
			
			bw.newLine();
			return;
		}
		
		
		
		for(int i = 1 ; i <= lastNum ; i++) {

			result[count] = i;
			count(lastNum, amount, result, count + 1);
			
		}
	
		return;
		
	}

}
