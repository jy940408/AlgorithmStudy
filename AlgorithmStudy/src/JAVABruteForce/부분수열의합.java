package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 부분수열의합 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static HashMap<Integer, Integer> resultList = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws IOException{
	
		int arrayList = Integer.parseInt(br.readLine());
		String[] array_ = (br.readLine()).split(" ");
		int[] array = new int[arrayList];
		boolean[] visitList = new boolean[arrayList];
		for(int i = 0 ; i < arrayList ; i++) {
			array[i] = Integer.parseInt(array_[i]);
			visitList[i] = true;
		}
		
		for(int i = 1 ; i < arrayList+1 ; i++) {
			ArrayList<Integer> btList = new ArrayList<Integer>();
			bt(array, btList, visitList, 0, i, 0);
		}
		
		int resultTest = 1;
		while(resultList.containsKey(resultTest)) {
			resultTest++;
		}
		
		br.close();
		bw.write(resultTest + "");
		bw.flush();
		bw.close();
		
	}
	
	private static void bt(int[] array, ArrayList<Integer> btList, boolean[] visitList, int depth, int length, int postIdx) {
		if(depth == length) {
			int result = 0;
			for(int i = 0 ; i < btList.size() ; i++) {
				result += btList.get(i);
			}
			resultList.put(result, 1);
			return;
		}
		
		for(int i = depth ; i < array.length ; i++) {
			if(visitList[i] && i >= postIdx) {
				visitList[i] = false;
				btList.add(depth, array[i]);
				bt(array, btList, visitList, depth+1, length, i);
				btList.remove(depth);
				visitList[i] = true;
			}
		}
		
	}

}
