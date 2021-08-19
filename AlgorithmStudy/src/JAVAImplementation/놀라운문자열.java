package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 놀라운문자열 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String testString = "";
		while(!testString.equals("*")) {
			
			testString = (br.readLine());
			String[] stringList = testString.split("");
			boolean check = true;
			Loop1:
			for(int i = 1 ; i < stringList.length+1 ; i++) {
				HashMap<String, Integer> resultList = new HashMap<String, Integer>();
				for(int j = 0 ; j < stringList.length ; j++) {
					if((j+i) <= (stringList.length-1)) {
						if(!resultList.containsKey(stringList[j] + stringList[j+i])) {
							resultList.put(stringList[j] + stringList[j+i], 1);
						}else {
							check = false;
							break Loop1;
						}
						System.out.println("stringSum: " + stringList[j] + stringList[j+i] + " " + check);
					}
				}
			}
			
			if(!testString.equals("*")) {
				if(check) {
					bw.write(testString + " is surprising.\n");
				}else {
					bw.write(testString + " is NOT surprising.\n");
				}
			}
			
			check = true;
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
