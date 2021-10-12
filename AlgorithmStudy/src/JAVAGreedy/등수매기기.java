package JAVAGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 등수매기기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException{

		int testNum = Integer.parseInt(br.readLine());
		int[] testCase = new int[testNum];
		for(int i = 0 ; i < testNum ; i++) {
			testCase[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(testCase);
		
		long result = 0;
		for(int i = 0 ; i < testNum ; i++) {
			if((i+1) <= testCase[i]) {
				result += testCase[i]-(i+1);
			}else {
				result += (i+1)-testCase[i];
			}
		}
		
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}

}
