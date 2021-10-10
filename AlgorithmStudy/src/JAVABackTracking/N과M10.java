package JAVABackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class N과M10 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Set<String> resultArray = new LinkedHashSet<String>();
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		String[] secondLine = (br.readLine()).split(" ");
		int numLength = Integer.parseInt(firstLine[0]);
		int sequenceLength = Integer.parseInt(firstLine[1]);
		
		int[] numList = new int[numLength];
		boolean[] visitList = new boolean[numLength];
		int[] usedList = new int[sequenceLength];
		for(int i = 0 ; i < numLength ; i++) {
			numList[i] = Integer.parseInt(secondLine[i]);
			visitList[i] = true;
		}
		
		Arrays.sort(numList);
		
		makeSequence(numList, usedList, visitList, 0, sequenceLength, 0);
		
		for(String i : resultArray) {
			bw.write(i + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void makeSequence(int[] numList, int[] usedList, boolean[] visitList, int depth, int sequenceLength, int postIdx) throws IOException{
		
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
		
		for(int i = postIdx ; i < numList.length ; i++) {
			if(visitList[i]) {
				visitList[i] = false;
				usedList[depth] = numList[i];
				makeSequence(numList, usedList, visitList, depth+1, sequenceLength, i+1);
				visitList[i] = true;
			}
		}
		
	}
}