package JAVAStack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 단어뒤집기2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine_ = (br.readLine()).split("");
		Stack<String> firstLine = new Stack<String>();
		
		for(int i = 0 ; i < firstLine_.length ; i++) {
			firstLine.add(firstLine_[i]);
		}
		
		String result = "";
		String word = "";
		while(firstLine.size() != 0) {
			String test = firstLine.peek();
			if(test.equals(">")) {
				test = firstLine.pop();
				result = test + result;
				while(!test.equals("<")) {
					test = firstLine.pop();
					result = test + result;
				}
			}else {
				while(!test.equals(">") && !test.equals(" ") && firstLine.size() != 0) {
					test = firstLine.peek();
					if(!test.equals(">") && !test.equals(" ")) {
						test = firstLine.pop();
						if(firstLine.size() == 0) {
							word = word + test;
							result = word + result;
							word = "";
						}else {
							word = word + test;
						}
					}else if(test.equals(">")) {
						result = word + result;
						word = "";
					}else if(test.equals(" ")) {
						test = firstLine.pop();
						result = " " + word + result;
						word = "";
					} 
				}
			}
		}
		
		br.close();
		bw.write(result);
		bw.flush();
		bw.close();
		
	}

}
