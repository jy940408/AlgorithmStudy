package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 가장가까운세사람의심리적거리 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < testCase ; i++) {
			int studentNum = Integer.parseInt(br.readLine());
			String[] mbtiList = new String[studentNum];
			mbtiList = (br.readLine()).split(" ");
			
			int result = 0;
			loop1:
			for(int j = 0 ; j < studentNum ; j++) {
				for(int k = 0 ; k < studentNum ; k++) {	
					for(int l = 0 ; l < studentNum ; l++) {
						int distance = 0;
							if(j != k && j != l && k != l) {
								String[] first = mbtiList[j].split("");
								String[] second = mbtiList[k].split("");
								String[] third = mbtiList[l].split("");
								
								for(int m = 0 ; m < 4 ; m++) {
									if(!first[m].equals(second[m])) {
										distance++;
									}
									if(!second[m].equals(third[m])) {
										distance++;
									}
									if(!first[m].equals(third[m])) {
										distance++;
									}
								}
								
								if(distance == 0) {
									result = distance;
									break loop1;
								}
								
								if(j == 1) {
									result = distance;
								}else {
									if(result >= distance) {
										result = distance;
									}
								}
							}
						
					}
				}
			}
				
			bw.write(result + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
