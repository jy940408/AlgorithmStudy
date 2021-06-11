package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class 전쟁_땅따먹기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int lineAmount = Integer.parseInt(br.readLine());
	
		String[] winner = new String[lineAmount];
		
		for(int i = 0 ; i < lineAmount ; i++) {
			
			String placeNum = br.readLine();
			String[] lineNum_ = (placeNum).split(" ");
			ArrayList<Long> lineNum = new ArrayList<Long>();
			ArrayList<Long> teamList = new ArrayList<Long>();
			
			for(int j = 0 ; j < lineNum_.length ; j++) {
				
				lineNum.add(Long.parseLong(lineNum_[j]));
				int count = Collections.frequency(lineNum, lineNum.get(j));
				
				if(j != 0 && count == 1) {
					teamList.add(lineNum.get(j));
				}
			}
			
			String result = "SYJKGW";
			for(int k = 0 ; k < teamList.size() ; k++) {
				int count = Collections.frequency(lineNum, teamList.get(k));
				
				if(count > (((Long)lineNum.get(0)/2))) {
					result = String.valueOf((Long)teamList.get(k));
				}
			}
			
			winner[i] = result;
			
		}
		
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0 ; i < winner.length ; i++) {
			bw.write(winner[i] + "\n");
			bw.flush();
		}
		
		bw.close();
		
	}

}
