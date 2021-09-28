package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 떡먹는호랑이 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int day = Integer.parseInt(firstLine[0]);
		int tteok = Integer.parseInt(firstLine[1]);
		
		int postNum = 1;
		int subNum = 0;
		int standard = 0;
		for(int i = 0 ; i < day-1 ; i++) {
			subNum = standard;
			standard = postNum;
			postNum = (subNum + standard);
		}

		int test = 0;
		while((tteok - (subNum*test))%standard != 0) {
			test++;
		}
		
		bw.write(test + "\n");
		bw.write((tteok - (subNum*test))/standard + "");
		bw.flush();
	}

}
