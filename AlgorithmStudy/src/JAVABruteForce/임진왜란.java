package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 임진왜란 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int firstNum = Integer.parseInt(br.readLine());
		String[] correctAnswer_ = (br.readLine()).split(" ");
		HashMap<String, Integer> correctAnswer = new HashMap<String, Integer>();
		String[] answer = (br.readLine()).split(" ");
		for(int i = 0 ; i < firstNum ; i++) {
			correctAnswer.put(correctAnswer_[i], i);
		}

		int count = 0;
		for(int i = 0 ; i < firstNum ; i++) {
			for(int j = 0 ; j < firstNum ; j++)
				if(j > i && correctAnswer.get(answer[i]) < correctAnswer.get(answer[j])) {
					count += 1;
				}
		}
		
		bw.write(count + "/" + ((firstNum*(firstNum-1))/2));
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
