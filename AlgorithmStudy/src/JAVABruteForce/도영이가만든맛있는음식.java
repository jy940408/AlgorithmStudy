package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 도영이가만든맛있는음식 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Long> result = new ArrayList<Long>();
	
	public static void main(String[] args) throws IOException{
	
		int arrayLength = Integer.parseInt(br.readLine());
		String[] ingredient = new String[arrayLength];
		boolean[] usedCheck = new boolean[arrayLength];
		for(int i = 0 ; i < arrayLength ; i++) {
			ingredient[i] = br.readLine();
			usedCheck[i] = true;
		}
		
		for(int i = 1 ; i < arrayLength+1 ; i++) {
			ArrayList<String> btList = new ArrayList<String>();
			bt(ingredient, btList, usedCheck, 0, i, 0);
		}
		
		Collections.sort(result);
		
		br.close();
		bw.write(result.get(0) + "");
		bw.flush();
		bw.close();
		
	}
	
	private static void bt(String[] ingredient, ArrayList<String> btList, boolean[] usedCheck, int depth, int length, int postIdx) {
		if(depth == length) {
			long resultTaste = 0;
			long sour = 1;
			long bitter = 0;
			for(int i = 0 ; i < btList.size() ; i++) {
				sour *= Long.parseLong((btList.get(i)).split(" ")[0]);
				bitter += Long.parseLong((btList.get(i)).split(" ")[1]);
			}
			
			if(sour >= bitter) {
				resultTaste = sour - bitter;
			}else {
				resultTaste = bitter - sour;
			}
			
			System.out.println("btList: " + btList);
			System.out.println("sour: " + sour + ", bitter: " + bitter + ", resultTaste: " + resultTaste);
			
			result.add(resultTaste);
			
			return;
		}
		
		for(int i = depth ; i < ingredient.length ; i++) {
			if(usedCheck[i] && i >= postIdx) {
				usedCheck[i] = false;
				btList.add(ingredient[i]);
				bt(ingredient, btList, usedCheck, depth+1, length, i);
				btList.remove(depth);
				usedCheck[i] = true;
			}
		}
		
	}

}