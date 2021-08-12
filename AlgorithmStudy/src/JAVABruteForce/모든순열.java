package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class 모든순열 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int checkNum = Integer.parseInt(br.readLine());
		int[] checkArray = new int[checkNum];
		int[] usedArray = new int[checkNum];
		boolean[] visitArray = new boolean[checkNum];
		for(int i = 0 ; i < checkNum ; i++) {
			checkArray[i] = (i+1);
			visitArray[i] = true;
			System.out.println("checkArray[" + i + "]: " + checkArray[i] + ", visitArray[" + i +"]: " + visitArray[i]);
		}
		
		makePermutation(checkArray, usedArray, visitArray, 0);
		
	}
	
	private static void makePermutation(int[] checkArray, int[] usedArray, boolean[] visitArray, int depth) throws IOException {
		
		if(depth == checkArray.length) {
			for(int i = 0 ; i < checkArray.length ; i++) {
				bw.write(usedArray[i] + " ");
			}
			bw.newLine();
			bw.flush();
			return;
		}
		
		for(int i = 0 ; i < checkArray.length ; i++) {
			if(visitArray[i]) {
				visitArray[i] = false;
				usedArray[depth] = checkArray[i];
				System.out.println("depth: " + depth + ", usedArray[" + depth + "]: " + usedArray[depth]);
				makePermutation(checkArray, usedArray, visitArray, depth+1);
				visitArray[i] = true;
			}
		}
		
	}

}
