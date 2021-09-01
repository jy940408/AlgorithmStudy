package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 랜선자르기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");

		int lines = Integer.parseInt(firstLine[0]);
		int count = Integer.parseInt(firstLine[1]);
		
		long[] linesHeight = new long[lines];
		for(int i = 0 ; i < lines ; i++) {
			linesHeight[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(linesHeight);
		
		bw.write(lengthCheck(count, linesHeight) + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static long lengthCheck(int count, long[] linesHeight) {
	
		long first = 1;
		long mid = 0;
		long last = linesHeight[linesHeight.length-1];
		long result = 0;
		while(first <= last) {
			
			result = 0;
			mid = (first+last)/2;
			
			for(int i = 0 ; i < linesHeight.length ; i++) {
				if(mid <= linesHeight[i]) {
					result += (linesHeight[i]/mid);
				}
			}
			if(result >= count) {
				first = mid + 1;
			}else if(result < count) {
				last = mid - 1;
			}
		}
		
		return last;
	}
	
}
