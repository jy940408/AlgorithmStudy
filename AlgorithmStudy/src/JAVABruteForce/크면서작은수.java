package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 크면서작은수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String firstNumString = br.readLine();
		String[] firstNum_ = (firstNumString).split("");
		int firstNum = Integer.parseInt(firstNumString);
		
		int[] firstNumList = new int[firstNum_.length];
		int[] usedNum = new int[firstNum_.length];
		boolean[] visitCheck = new boolean[firstNum_.length];
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		
		for(int i = 0 ; i < firstNum_.length ; i++) {
			firstNumList[i] = Integer.parseInt(firstNum_[i]);
			visitCheck[i] = true;
		}
		
		Arrays.sort(firstNumList);
		
		resultList = makePermutation(firstNumList, usedNum, visitCheck, 0 ,firstNum, resultList);
		
		for(int i = 0 ; i < resultList.size() ; i++) {
			System.out.println("resultList.get(" + i + "): " + resultList.get(i));
		}
		
		if(resultList.size() != 0) {
			if(((resultList.get(0)).toString()).length() == (firstNum_).length) {
				bw.write(resultList.get(0) + "");
			}
		}else {
			bw.write("0");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	private static ArrayList<Integer> makePermutation(int[] firstNumList, int[] usedNum, boolean[] visitCheck, int depth, int firstNum, ArrayList<Integer> resultList){
		
		if(depth == firstNumList.length) {
			String result_ = "";
			int result = 0;
			for(int i = 0 ; i < firstNumList.length ; i++) {
				result_ += usedNum[i];
			}
			result = Integer.parseInt(result_);
			if(firstNum < result) {
				resultList.add(result);
			}
			return resultList;
		}
		
		for(int i = 0 ; i < firstNumList.length ; i++) {
			if(visitCheck[i]) {
				visitCheck[i] = false;
				usedNum[depth] = firstNumList[i];
				makePermutation(firstNumList, usedNum, visitCheck, depth+1, firstNum, resultList);
				visitCheck[i] = true;
			}
		}
		
		return resultList;
		
	}
	

}
