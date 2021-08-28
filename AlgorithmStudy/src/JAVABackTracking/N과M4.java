package JAVABackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N과M4 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		String[] firstLine = (br.readLine()).split(" ");
		
		int lastNum = Integer.parseInt(firstLine[0]);
		int amount = Integer.parseInt(firstLine[1]);
		
		int[] result = new int[amount];
		
		count(lastNum, amount, result, 0, 0);
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	public static void count(int lastNum, int amount, int[] result, int preIdx, int count) throws IOException {
		
		if(count == amount) {
			for(int i = 0 ; i < amount ; i++) {
				bw.write(Integer.toString(result[i]) + " ");
			}
			
			bw.newLine();
			return;
		}
		
		for(int i = 1 ; i <= lastNum ; i++) {
			if(preIdx <= i) {
				result[count] = i;
				count(lastNum, amount, result, i, count + 1);
			}
		}
	
		return;
		
	}

}
