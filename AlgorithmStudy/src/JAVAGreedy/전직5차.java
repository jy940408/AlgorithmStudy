package JAVAGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 전직5차 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int stoneNum = Integer.parseInt(firstLine[0]);
		int activationNum = Integer.parseInt(firstLine[1]);
		String[] secondLine = (br.readLine()).split(" ");
		long[] experience = new long[stoneNum];
		for(int i = 0 ; i < stoneNum ; i++) {
			experience[i] = Integer.parseInt(secondLine[i]);
		}
		
		Arrays.sort(experience);
		
		long result = 0;
		for(int i = 0 ; i < stoneNum ; i++) {
			if(i <= activationNum) {
				result += experience[i]*i;
			}else {
				result += experience[i]*activationNum;
			}
		}

		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}

}
