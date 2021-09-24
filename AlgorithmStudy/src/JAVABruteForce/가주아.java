package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 가주아 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int roundNum = Integer.parseInt(br.readLine());
		int testCase = 0;
		
		for(int i = 0 ; i < roundNum ; i++) {
			testCase = Integer.parseInt(br.readLine());
			
			int power = 2;
			
			while(power < testCase){
				power *= 2;
			}
			
			if(power != testCase) {
				bw.write("Gazua\n");
			}else {
				bw.write("GoHanGang\n");
			}
			
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}