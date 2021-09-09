package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 졸려 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int blinkNum = Integer.parseInt(br.readLine());
		String changeWord_ = br.readLine();
		String[] changeWord = changeWord_.split("");
		
		for(int i = 0 ; i < blinkNum ; i++) {
			String firstWord = "";
			String secondWord = "";
			for(int j = 0 ; j < changeWord.length ; j++) {
				if(j%2 == 0) {
					firstWord += changeWord[j];
				}else if(j%2 == 1) {
					secondWord = changeWord[j] + secondWord;
				}
				if(j == changeWord.length-1) {
					changeWord = (firstWord + secondWord).split("");
				}
			}
			if((firstWord + secondWord).equals(changeWord_)) {
				System.out.println("여기: " + i + " " + (blinkNum%i));
				blinkNum = blinkNum%(i+1) + 1;
				i = 0;
			}
			System.out.println("i: " + i + ", firstWord: " + firstWord + ", secondWord: " + secondWord);
		}
		
		String result = "";
		for(int i = 0 ; i < changeWord.length ; i++) {
			result += changeWord[i];
		}
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}

}
