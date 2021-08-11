package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 궁합쌍찾기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer firstLine = new StringTokenizer(br.readLine());
		int[] lineList = new int[firstLine.countTokens()];
		int resultNum = Integer.parseInt(br.readLine());
		ArrayList<String> resultList = new ArrayList<String>();
		int usedCheck = 0;
		
		for(int i = 0 ; i < lineList.length ; i++) {
			lineList[i] = Integer.parseInt(firstLine.nextToken());
		}
		
		Arrays.sort(lineList);
		
		for(int i = 0 ; i < lineList.length ; i++) {
			System.out.println("lineList[" + i +"]: " + lineList[i]);
			
		}
		
		for(int i = 0 ; i < lineList.length ; i++) {
			for(int j = 0 ; j < lineList.length ; j++) {
				if(i < j) {
					System.out.println("lineList[" + i +"]: " + lineList[i] + ", lineList[" + j + "]: " + lineList[j]);
					if((lineList[i] + lineList[j]) == resultNum) {
						for(int k = 0 ; k < resultList.size() ; k++) {
							if((lineList[i] + " " + lineList[j]).equals(resultList.get(k))) {
								usedCheck += 1;
							}
						}
						if(usedCheck == 0) {
							resultList.add((lineList[i] + " " + lineList[j]));
						}else {
							usedCheck = 0;
						}
					}
				}
			}
		}
		
		System.out.println("resultList: " + resultList);
		for(int i = 0 ; i < resultList.size() ; i++) {
			System.out.println(resultList.get(i));
		}
		System.out.println(resultList.size());
		
	}

}
