package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 한국이그리울땐서버에접속하지 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int round = Integer.parseInt(br.readLine());
		String pattern_ = br.readLine();
		String[] pattern = pattern_.split("\\*");
		String[] firstPattern = pattern[0].split("");
		String[] secondPattern = pattern[1].split("");
		
		for(int i = 0 ; i < round ; i++) {
			String inputString_ = br.readLine();
			String[] inputString = inputString_.split("");
			
			for(int j = 0 ; j < firstPattern.length ; j++) {
				if(!inputString[j].equals(firstPattern[j])) {
					bw.write("NE\n");
					break;
				}else if(inputString[j].equals(firstPattern[j]) && j == firstPattern.length-1) {
					for(int k = 0 ; k < secondPattern.length ; k++) {
						if(inputString.length >= (firstPattern.length + secondPattern.length)) {
							if(!inputString[(inputString.length-secondPattern.length)+k].equals(secondPattern[k])) {
								bw.write("NE\n");
								break;
							}else if(inputString[(inputString.length-secondPattern.length)+k].equals(secondPattern[k]) && k == secondPattern.length-1) {
								bw.write("DA\n");
							}
						}else {
							bw.write("NE\n");
							break;
						}
					}
				}
			}
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
