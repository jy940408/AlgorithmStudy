package JAVAGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class 슬라임합치기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int slimeNum = Integer.parseInt(br.readLine());
		String[] secondLine = (br.readLine()).split(" ");
		ArrayList<Integer> slimeArray = new ArrayList<Integer>();
		for(int i = 0 ; i < slimeNum ; i++) {
			slimeArray.add(Integer.parseInt(secondLine[i]));
		}
		
		Collections.sort(slimeArray, Collections.reverseOrder());
		
		long result = 0;
		while(slimeArray.size() != 1) {
			int newSlime = (slimeArray.get(0) + slimeArray.get(1));
			result += ((long)slimeArray.get(0)*(long)slimeArray.get(1));
			slimeArray.remove(0);
			slimeArray.remove(0);
			slimeArray.add(0, newSlime);		
		}
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}

}
