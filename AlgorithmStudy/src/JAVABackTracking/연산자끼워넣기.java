package JAVABackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 연산자끼워넣기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long max = -1000000000;
	static long min = 1000000000;
	static int check = 0;
	
	public static void main(String[] args) throws IOException{
		
		int arrayLength = Integer.parseInt(br.readLine());
		String[] numList_ = (br.readLine()).split(" ");
		int[] numList = new int[arrayLength];
		for(int i = 0 ; i < arrayLength ; i++) {
			numList[i] = Integer.parseInt(numList_[i]);
		}
		
		int operatorNum = 0;
		String[] operatorList_ = (br.readLine()).split(" ");
		ArrayList<String> operatorList = new ArrayList<String>();
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < Integer.parseInt(operatorList_[i]) ; j++) {
				if(i == 0) {
					operatorList.add("+");
				}else if(i == 1) {
					operatorList.add("-");
				}else if(i == 2) {
					operatorList.add("*");
				}else {
					operatorList.add("/");
				}
			}
		}
		boolean[] visitList = new boolean[operatorList.size()];
		String[] operatorResult = new String[operatorList.size()];
		
		bt(numList, operatorList, visitList, operatorResult, 0);
		
		br.close();
		bw.write(max + "\n" + min);
		bw.flush();
		bw.close();
		
	}
	
	private static void bt(int[] numList, ArrayList<String> operatorList, boolean[] visitList, String[] operatorResult, int depth) {
		
		if(depth == operatorList.size()) {
			check++;
			long result = numList[0];
			for(int i = 1 ; i < numList.length ; i++) {
				if(operatorResult[i-1].equals("+")) {
					result = result + numList[i];
				}else if(operatorResult[i-1].equals("-")) {
					result = result - numList[i];
				}else if(operatorResult[i-1].equals("*")) {
					result = result * numList[i];
				}else {
					if(result < 0) {
						result *= -1;
						result = (result/numList[i])*(-1);
					}else {
						result = (result/numList[i]);
					}
					
				}
			}
			
			if(max < result) {
				max = result;
			}
			if(min > result) {
				min = result;
			}
		
		}
		
		
		for(int i = 0 ; i < operatorList.size() ; i++) {
			if(!visitList[i]) {
				visitList[i] = true;
				operatorResult[depth] = operatorList.get(i);
				bt(numList, operatorList, visitList, operatorResult, depth+1);
				visitList[i] = false;
			}
		}
	}

}
