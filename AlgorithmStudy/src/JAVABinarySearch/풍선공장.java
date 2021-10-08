package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 풍선공장 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int staff = Integer.parseInt(firstLine[0]);
		int balloon = Integer.parseInt(firstLine[1]);
		String[] secondLine = (br.readLine()).split(" ");
		int[] workTime = new int[secondLine.length];
		for(int i = 0 ; i < secondLine.length ; i++) {
			workTime[i] = Integer.parseInt(secondLine[i]);
		}
		Arrays.sort(workTime);

		br.close();
		bw.write(bs(workTime, balloon) + "");
		bw.flush();
		bw.close();
	}
	
	private static long bs(int[] workTime, int balloon) {
		
		long first = 0;
		long mid = 0;
		long last = (long)workTime[0]*balloon;
		long result = 0;
		
		while(first <= last) {
			
			long balloonNum = 0;
			mid = (first+last)/2;
			for(int i = 0 ; i < workTime.length ; i++) {
				balloonNum += mid/(long)workTime[i];
			}
			
			if(balloonNum >= balloon) {
				result = mid;
				last = mid - 1;
			}else {
				first = mid + 1;
			}
			
		}
		
		return result;
	}

}
