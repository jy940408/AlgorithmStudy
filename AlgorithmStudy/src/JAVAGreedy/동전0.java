package JAVAGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 동전0 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
 
		String[] firstLine = (br.readLine()).split(" ");
		int coinNum = Integer.parseInt(firstLine[0]);
		int coinSum = Integer.parseInt(firstLine[1]);
		
		int[] coinArray = new int[coinNum];
		for(int i = 0 ; i < coinNum ; i++) {
			coinArray[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		for(int i = coinNum-1 ; i >= 0 ; i--) {
			if(coinArray[i] <= coinSum) {
				result += coinSum/coinArray[i];
				coinSum = coinSum%coinArray[i];
			}
		}
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}

}
