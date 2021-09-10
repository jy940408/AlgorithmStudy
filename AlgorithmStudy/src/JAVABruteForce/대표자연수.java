package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 대표자연수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {

		int number = Integer.parseInt(br.readLine());
		String[] numberList_ = br.readLine().split(" ");
		int[] numberList = new int[numberList_.length];
		for(int i = 0 ; i < numberList.length ; i++) {
			numberList[i] = Integer.parseInt(numberList_[i]);
		}
		
		Arrays.sort(numberList);
		
		int[] resultList = new int[numberList.length];
		int result = 0;
		for(int i = 0 ; i < numberList.length ; i++) {
			result = 0;
			for(int j = 0 ; j < numberList.length ; j++) {
				if(numberList[i] <= numberList[j]) {
					result += numberList[j] - numberList[i];
				}else {
					result += numberList[i] - numberList[j];
				}
			}
			
			resultList[i] = result;
		}
		
		for(int i = 0 ; i < numberList.length ; i++) {
			for(int j = i ; j < numberList.length ; j++) {
				if(i < j) {
					if(resultList[i] > resultList[j]) {
						int test = resultList[i];
						resultList[i] = resultList[j];
						resultList[j] = test;
						test = numberList[i];
						numberList[i] = numberList[j];
						numberList[j] = test;
					}
				}
			}
			
			resultList[i] = result;
		}
		
		System.out.println(Arrays.toString(numberList));
		System.out.println(Arrays.toString(resultList));
		
		br.close();
		bw.write(numberList[0] + "");
		bw.flush();
		bw.close();
	}

}
