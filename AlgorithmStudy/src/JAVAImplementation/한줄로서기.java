package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 한줄로서기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{

		int allNum = Integer.parseInt(br.readLine());
		String[] secondLine = (br.readLine()).split(" ");
		int[] resultLine = new int[allNum];
		int validCheck = 0;
		String result = "";
		for(int i = 0 ; i < allNum ; i++) {
			validCheck = Integer.parseInt(secondLine[allNum-(i+1)]);
			if(resultLine[validCheck] != 0) {
				for(int j = allNum-1 ; j > validCheck ; j--) {
					resultLine[j] = resultLine[j-1];
				}
			}
			resultLine[validCheck] = (allNum-i);
		}
		
		for(int i = 0 ; i < allNum ; i++) {
			result += resultLine[i] + " ";
		}

		bw.write(result + "");
		br.close();
		bw.flush();
		bw.close();
	}

}
