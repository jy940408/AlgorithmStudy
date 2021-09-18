package JAVAQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 요세푸스문제 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] testCase = (br.readLine()).split(" ");

		int allNum = Integer.parseInt(testCase[0]);
		int distance = Integer.parseInt(testCase[1]);
		Queue<Integer> numList = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i = 0 ; i < allNum ; i++) {
			numList.add(i+1);
			System.out.println("numList: " + numList);
		}
		
		int testNum = 0;
		while(numList.size() != 0) {
			testNum++;
			if(testNum != distance) {
				numList.add(numList.poll());
				System.out.println("if: " + numList + ", result: " + result);
			}else {
				result.add(numList.poll());
				testNum = 0;
				System.out.println("el: " + numList + ", result: " + result);
			}
		}
		
		System.out.println("post numList: " + numList);
	
		br.close();
		bw.write("<");
		for(int i = 0 ; i < allNum ; i++) {
			if(i != allNum-1) {
				System.out.println("if result.get(" + i + "): " + result.get(i));
				bw.write(result.get(i) + ", ");
			}else {
				System.out.println("el result.get(" + i + "): " + result.get(i));
				bw.write(result.get(i) + "");
			}
		}
		bw.write(">");
		bw.flush();
		bw.close();
		
	}

}
