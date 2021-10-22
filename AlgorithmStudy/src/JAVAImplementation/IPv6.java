package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class IPv6 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{

		String[] testCase = (br.readLine()).split(":");
		ArrayList<String> resultArray = new ArrayList<String>();
		
		for(int i = 0 ; i < testCase.length ; i++) {
			String result = "";
			if(testCase[i].length() > 0 && testCase[i].length() < 5) {
				for(int j = 0 ; j < 4-testCase[i].length() ; j++) {
					result += "0";
				}
				result += testCase[i];
				resultArray.add(result);
			}else if(testCase[i].length() == 0) {
				if(i == 0) {
					for(int j = 0 ; j < 8 - (testCase.length-2) ; j++) {
						resultArray.add("0000");
					}
					i++;
				}else {
					for(int j = 0 ; j < 9 - testCase.length ; j++) {
						resultArray.add("0000");
					}
				}
			}
			
			if(i == testCase.length-1 && resultArray.size() != 8) {
				int arraySize = resultArray.size();
				for(int j = 0 ; j < 8 - arraySize ; j++) {
					resultArray.add("0000");
				}
			}
			
		}
		
		br.close();
		for(int i = 0 ; i < 8 ; i++) {
			if(i == 7) {
				bw.write(resultArray.get(i));
			}else {
				bw.write(resultArray.get(i) + ":");
			}
		}
		bw.flush();
		bw.close();
	}

}
