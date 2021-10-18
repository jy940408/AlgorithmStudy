package JAVABackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class N과M11 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Set<String> resultArray = new LinkedHashSet<String>();
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		String[] secondLine = (br.readLine()).split(" ");
		int numLength = Integer.parseInt(firstLine[0]);
		int sequenceLength = Integer.parseInt(firstLine[1]);
		
		int[] numList = new int[numLength];
		int[] usedList = new int[sequenceLength];
		for(int i = 0 ; i < numLength ; i++) {
			numList[i] = Integer.parseInt(secondLine[i]);
		}
		
		Arrays.sort(numList);
		
		makeSequence(numList, usedList, 0, sequenceLength);
		
		for(String i : resultArray) {
			bw.write(i + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void makeSequence(int[] numList, int[] usedList, int depth, int sequenceLength) throws IOException{
		
		if(depth == sequenceLength) {
			String result = "";
			for(int i = 0 ; i < sequenceLength ; i++) {
				result += usedList[i] + " ";
			}
			if(!resultArray.contains(result)) {
				resultArray.add(result);
			}
			return;
		}
		
		for(int i = 0 ; i < numList.length ; i++) {
			usedList[depth] = numList[i];
			makeSequence(numList, usedList, depth+1, sequenceLength);
		}
		
	}
}