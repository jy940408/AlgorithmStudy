package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 과자나눠주기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {

		String[] firstLine = (br.readLine()).split(" ");
		int nephewNum = Integer.parseInt(firstLine[0]);
		int snackNum = Integer.parseInt(firstLine[1]);
		String[] secondLine = (br.readLine()).split(" ");
		int[] snackLength = new int[snackNum];
		for(int i = 0 ; i < snackNum ; i++) {
			snackLength[i] = Integer.parseInt(secondLine[i]);
		}
		Arrays.sort(snackLength);
		
		int result = bs(snackLength, nephewNum);
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
	}

	private static int bs(int[] snackLength, int nephewNum) {
		
		int first = 1;
		int mid = 0;
		int last = snackLength[snackLength.length-1];
		int result = 0;
		
		while(first <= last) {
			
			long count = 0;
			mid = (first+last)/2;
			for(int i = 0 ; i < snackLength.length ; i++) {
				if(mid > 0) {
					count += (snackLength[i]/mid);
				}
			}
			
			if(count >= nephewNum) {
				if(result < mid) {
					result = mid;
				}
				first = mid+1;
			}else if(count < nephewNum) {
				last = mid-1;
			}
		}
		
		return result;
	}
	
}
