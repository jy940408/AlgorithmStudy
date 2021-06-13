package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class 전쟁_땅따먹기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		Short lineAmount = Short.parseShort(br.readLine());
		HashMap<Short, String> winner = new HashMap<>();
		
		for(Short i = 0 ; i < lineAmount ; i++) {
			
			String[] lineNum_ = br.readLine().split(" ");
			HashMap<Integer, String> lineNum = new HashMap<>();
			
			for(int j = 1 ; j < lineNum_.length ; j++) {
				lineNum.put(j-1, lineNum_[j]);
			}
			
			ArrayList<String> teamList = new ArrayList<String>(); 
			TreeSet<String> distinctData = new TreeSet<String>(lineNum.values());
			teamList = new ArrayList<String>(distinctData);
			
			
			System.out.println("lineNum:" + lineNum);
			System.out.println("teamList: " + teamList);
			
			String result = "SYJKGW";
			
			Loop1:
			for(int k = 0, o = teamList.size() ; k < o ; k++) {	
				int count_ = 0;
				for(int l = 0, p = lineNum.size() ; l < p ; l++) {
					if(teamList.get(k).equals(lineNum.get(l))) {
						count_ = count_ + 1;
						if(count_ > (lineNum.size())/2) {
							result = teamList.get(k);
							winner.put(i, result);
							break Loop1;
						}
					}
				}
				winner.put(i, result);
				break Loop1;
			}
			
		}
		
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(Short i = 0 ; i < winner.size() ; i++) {
			bw.write(winner.get(i) + "\n");
			bw.flush();
		}
		
		bw.close();
		
	}

}
