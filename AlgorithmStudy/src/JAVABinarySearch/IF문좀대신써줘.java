package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class IF문좀대신써줘 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
	
		String[] firstLine = (br.readLine()).split(" ");
		int nameNum = Integer.parseInt(firstLine[0]);
		int characterNum = Integer.parseInt(firstLine[1]);
		
		HashMap<Integer, String> nameList = new HashMap<Integer, String>();
		int[] nameLimit = new int[nameNum];
		for(int i = 0 ; i < nameNum ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			if(!nameList.containsKey(Integer.parseInt(secondLine[1]))) {
				nameList.put(Integer.parseInt(secondLine[1]), secondLine[0]);
			}
			nameLimit[i] = Integer.parseInt(secondLine[1]);
			bw.write(nameList.get(Integer.parseInt(secondLine[1])) + " " + nameLimit[i] + "\n");
		}
		
		Arrays.sort(nameLimit);
		
		int testNum = 0;
		for(int i = 0 ; i < characterNum ; i++) {
			testNum = Integer.parseInt(br.readLine());
			bw.write(limitCheck(nameList, nameLimit, testNum)+"\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static String limitCheck(HashMap nameList, int[] nameLimit, int testNum) {
		
		int first = 0;
		int mid = 0;
		int last = (nameLimit.length - 1);
		int spareNum = 0;
		
		while(first <= last) {
			mid = (first + last)/2;
					
			if(testNum == nameLimit[mid]) {
				return (String)nameList.get(nameLimit[mid]);
			}else if(testNum > nameLimit[mid]) {
				first = mid + 1;
			}else if(testNum < nameLimit[mid]) {
				if(mid > 0) {
					if(testNum <= nameLimit[mid] && testNum > nameLimit[mid-1]) {
						return (String)nameList.get(nameLimit[mid]);
					}else {
						last = mid - 1;
					}
				}else {
					return (String)nameList.get(nameLimit[mid]);
				}
			}
		}
		
		return "test";
	}
}
