package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 서버실 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int length = Integer.parseInt(br.readLine());
		long allComputer = 0;
		long lastFloor = 0;
		long firstFloor = 0;
		HashMap<Integer, Integer> computer = new HashMap<Integer, Integer>();
		for(int i = 0 ; i < length ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			for(int j = 0 ; j < length ; j++) {
				int checkNum = Integer.parseInt(secondLine[j]);
				if(lastFloor <= checkNum) {
					lastFloor = (long)checkNum;
				}
				if(checkNum != 0) {
					if(computer.containsKey(checkNum)) {
						allComputer += (long)checkNum;
						computer.put(checkNum, computer.get(checkNum)+1);
					}else {
						allComputer += (long)checkNum;
						computer.put(checkNum, 1);
					}
				}
			}
		}
		
		for(int i = 0 ; i < lastFloor ; i++) {
			if(computer.containsKey(i+1)) {
				firstFloor += (long)computer.get(i+1);
			}
		}
		
		long standardNum = 0;
		if(allComputer%2 == 1) {
			standardNum = allComputer/2+1;
		}else {
			standardNum = allComputer/2;
		}
		
		bw.write(bs(computer, standardNum, firstFloor, lastFloor) + "");
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	private static long bs(HashMap<Integer, Integer> computer, long standardNum, long firstFloor, long lastFloor) {
		
		long first = 0;
		long mid = 0;
		long last = (long)lastFloor;
		long result = 0;
		
		while(first <= last) {
			
			mid = (first+last)/2;
			long onComputer = 0;
			long subComputer = 0;
			if(mid != 0) {
				for(int i = 0 ; i < mid-1 ; i++) {
					if(computer.containsKey(i+1)) {
						subComputer += (((long)computer.get(i+1))*(mid-(i+1)));
					}
				}
			}
			onComputer = firstFloor*mid - subComputer;
			
			if(onComputer >= standardNum) {
				result = mid;
				last = mid - 1;
			}else {
				first = mid + 1;
			}
		}
		
		return result;
	}

}
