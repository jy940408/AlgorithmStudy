package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 빈도정렬 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{

		String[] firstLine = (br.readLine()).split(" ");
		int listNum = Integer.parseInt(firstLine[0]);
		int maxNum = Integer.parseInt(firstLine[1]);
		String[] secondLine = (br.readLine()).split(" ");
		HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> numIdxMap = new HashMap<Integer, Integer>();
		
		for(int i = 0 ; i < listNum ; i++) {
			numMap.merge(Integer.parseInt(secondLine[i]), 1, (value, putValue) -> value + 1);
			numIdxMap.merge(Integer.parseInt(secondLine[i]), i, (value, putValue) -> value);
		}
		
		int[] numList = new int[numMap.size()];
		
		int numIdx = 0;
		for(int key : numMap.keySet()) {
			numList[numIdx] = key;
			numIdx += 1;
		}
		
		for(int i = 0 ; i < numList.length ; i++) {
			for(int j = i ; j < numList.length ; j++) {
				if(i < j && (int)numMap.get(numList[i]) < (int)numMap.get(numList[j])) {
					int subString = numList[i];
					numList[i] = numList[j];
					numList[j] = subString;
				}else if(i < j && (int)numMap.get(numList[i]) == (int)numMap.get(numList[j])) {
					if(numIdxMap.get(numList[i]) > numIdxMap.get(numList[j])) {
						int subString = numList[j];
						numList[j] = numList[i];
						numList[i] = subString;
					}
				}
			}
		}
		
		String result = "";
		for(int i = 0 ; i < numList.length ; i++) {
			for(int j = 0 ; j < numMap.get(numList[i]) ; j++) {
				result += numList[i] + " ";
			}
		}
		
		bw.write(result);
        br.close();
        bw.flush();
        bw.close();
	}

}
