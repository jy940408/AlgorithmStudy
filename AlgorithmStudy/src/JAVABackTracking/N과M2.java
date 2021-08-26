package JAVABackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N과M2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		String[] secondLine = (br.readLine()).split(" ");
		int lastNum = Integer.parseInt(firstLine[0]);
		int sequenceLength = Integer.parseInt(firstLine[1]);
		
		int[] numList = new int[lastNum];
		boolean[] visitList = new boolean[lastNum];
		int[] usedList = new int[sequenceLength];
		for(int i = 0 ; i < lastNum ; i++) {
			numList[i] = Integer.parseInt(secondLine[i]);
			visitList[i] = true;
		}
		
		Arrays.sort(numList);
		
		makeSequence(numList, usedList, visitList, 0, sequenceLength);
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void makeSequence(int[] numList, int[] usedList, boolean[] visitList, int depth, int sequenceLength) throws IOException{
		
		if(depth == sequenceLength) {
			for(int i = 0 ; i < sequenceLength ; i++) {
				bw.write(usedList[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 0 ; i < numList.length ; i++) {
			if(visitList[i]) {
				visitList[i] = false;
				usedList[depth] = numList[i];
				makeSequence(numList, usedList, visitList, depth+1, sequenceLength);
				visitList[i] = true;
			}
		}
		
	}

}
