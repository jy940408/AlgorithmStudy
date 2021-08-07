package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Sort마스터배지훈의후계자 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
			
		String[] firstLine = (br.readLine()).split(" "); 
		int aLength = Integer.parseInt(firstLine[0]);
		int qLength = Integer.parseInt(firstLine[1]);
		int[] aList = new int[aLength];
		HashMap<Integer, Integer> aMap = new HashMap<Integer,Integer>();
		
		for(int i = 0 ; i < aLength ; i++) {
			aList[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(aList);
		
		for(int i = 0 ; i < aLength ; i++) {
			if(!aMap.containsKey(aList[i])) {
				aMap.put(aList[i], i);
			}
		}
		
		for(int i = 0 ; i < qLength ; i++) {
			int testNum = Integer.parseInt(br.readLine());
			if(aMap.containsKey(testNum)) {
				bw.write(aMap.get(testNum) + "");
			}else {
				bw.write(-1 + "");
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
