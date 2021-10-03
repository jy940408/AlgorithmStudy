package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 이상한술집 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int bottleNum = Integer.parseInt(firstLine[0]);
		int friendNum = Integer.parseInt(firstLine[1]);
		long[] drink = new long[bottleNum]; 

		for(int i = 0 ; i < bottleNum ; i++) {
			drink[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(drink);
		
		br.close();
		bw.write(bs(drink, friendNum) + "");
		bw.flush();
		bw.close();
	}

	private static long bs(long[] drink, int friendNum) {
		
		long first = 1;
		long mid = 0;
		long last = drink[drink.length-1];
		long result = 0;
		
		while(first <= last) {
			
			long count = 0;
			mid = (first+last)/2;
			for(int i = 0 ; i < drink.length ; i++) {
				if(mid > 0) {
					count += (drink[i]/mid);
				}
			}
			
			if(count >= friendNum) {
				if(result <= mid) {
					result = mid;
				}
				first = mid + 1;
			}else if(count < friendNum) {
				last = mid - 1;
			}
			
		}
		
		return result;
	}
	
}
