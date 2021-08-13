package JAVAStack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 제로 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int firstNum = Integer.parseInt(br.readLine());
		Stack<Integer> numList = new Stack<Integer>();
		int secondNum = 0;
		int result = 0;
		for(int i = 0 ; i < firstNum ; i++) {
			secondNum = Integer.parseInt(br.readLine());
			if(secondNum == 0) {
				numList.pop();
			}else {
				numList.push(secondNum);
			}
		}
		
		System.out.println("numList:" + numList + ", numList.size(): " + numList.size());
		
		int popNum = 0;
		while(numList.size() != 0) {
			popNum = numList.pop();
			result += popNum;
			System.out.println("popNum: " + popNum + ", result: " + result);
		}
		
		bw.write(result+ "");
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
