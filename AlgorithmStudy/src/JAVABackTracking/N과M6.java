package JAVABackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N과M6 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
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
		
		makeSequence(numList, usedList, visitList, 0, 0, sequenceLength);
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void makeSequence(int[] numList, int[] usedList, boolean[] visitList, int depth, int postIdx,  int sequenceLength) throws IOException{
		
		if(depth == sequenceLength) {
			for(int i = 0 ; i < sequenceLength ; i++) {
				bw.write(usedList[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 0 ; i < numList.length ; i++) {
			if(visitList[i] && i >= postIdx) {
				visitList[i] = false;
				usedList[depth] = numList[i];
				makeSequence(numList, usedList, visitList, depth+1, i, sequenceLength);
				visitList[i] = true;
			}
		}
		
	}

}
