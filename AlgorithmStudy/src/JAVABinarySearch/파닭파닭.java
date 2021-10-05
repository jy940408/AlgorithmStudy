package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 파닭파닭 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int goNum = Integer.parseInt(firstLine[0]);
		int chickenNum = Integer.parseInt(firstLine[1]);
		long[] goList = new long[goNum]; 

		for(int i = 0 ; i < goNum ; i++) {
			goList[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(goList);
		
		br.close();
		bw.write(bs(goList, chickenNum) + "");
		bw.flush();
		bw.close();
	}

	private static long bs(long[] goList, int chickenNum) {
		
		long first = 1;
		long mid = 0;
		long last = goList[goList.length-1];
		long result = 0;
		
		while(first <= last) {
			
			long count = 0;
			mid = (first+last)/2;
			long subCount = 0;
			for(int i = 0 ; i < goList.length ; i++) {
				if(mid > 0) {
					count += (goList[i]/mid);
					subCount += goList[i];
				}
			}
			if(count >= chickenNum) {
				result = (subCount - (mid*chickenNum));
				first = mid + 1;
			}else if(count < chickenNum) {
				last = mid - 1;
			}
			
		}
		
		return result;
	}
	
}
