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
		int lastNum = Integer.parseInt(firstLine[0]);
		int sequenceLength = Integer.parseInt(firstLine[1]);
		
		int[] numList = new int[lastNum];
		boolean[] visitList = new boolean[lastNum];
		int[] usedList = new int[sequenceLength];
		for(int i = 0 ; i < lastNum ; i++) {
			numList[i] = (i+1);
			visitList[i] = true;
		}
		
		makeSequence(numList, usedList, visitList, 0, 0, sequenceLength);
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void makeSequence(int[] numList, int[] usedList, boolean[] visitList, int depth, int preIdx, int sequenceLength) throws IOException{
		
		if(depth == sequenceLength) {
			for(int i = 0 ; i < sequenceLength ; i++) {
				bw.write(usedList[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 0 ; i < numList.length ; i++) {
			System.out.println("i: " + i + ", depth: " + depth);
			if(visitList[i] && preIdx <= i) {
				System.out.println("if 내부, i: " + i + ", depth: " + depth);
				visitList[i] = false;
				usedList[depth] = numList[i];
				makeSequence(numList, usedList, visitList, depth+1, i, sequenceLength);
				if(depth != 0) {
					visitList[i] = true;
				}
			}
		}
		
		return;
	}

}
