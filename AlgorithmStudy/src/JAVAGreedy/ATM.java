package JAVAGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ATM {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{

		int caseNum = Integer.parseInt(br.readLine());
		String[] caseArray_ = (br.readLine()).split(" ");
		int[] caseArray = new int[caseNum];
		for(int i = 0 ; i < caseNum ; i++) {
			caseArray[i] = Integer.parseInt(caseArray_[i]);
		}
		
		Arrays.sort(caseArray);
		
		int result = 0;
		int subResult = 0;
		for(int i = 0 ; i < caseNum ; i++) {
			subResult += caseArray[i];
			result += subResult;
		}
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
	}

}
