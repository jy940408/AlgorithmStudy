package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class AC {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < testCaseNum ; i++) {
			
			String[] function = (br.readLine()).split("");
			int arrayNum = Integer.parseInt(br.readLine());
			String[] testArray_ = (br.readLine()).split(",");
			Deque<Integer> testArray = new LinkedList<Integer>();
			for(int j = 0 ; j < arrayNum ; j++) {
				if(arrayNum == 1) {
					String check = (String)testArray_[j].subSequence(1, testArray_[j].length()-1);
					testArray.add(Integer.parseInt(check));
				}else {
					if(j == 0) {
						String check = (String)testArray_[j].subSequence(1, testArray_[j].length());
						testArray.add(Integer.parseInt(check));
					}else if(j == arrayNum-1) {
						String check = (String)testArray_[j].subSequence(0, testArray_[j].length()-1);
						testArray.add(Integer.parseInt(check));
					}else {
						testArray.add(Integer.parseInt(testArray_[j]));
					}
				}
			}
			
			int resultCheck = 0;
			int arrayCheck = 0;
			for(int j = 0 ; j < function.length ; j++) {
				if(function[j].equals("R")) {
					if(arrayCheck == 0) {
						arrayCheck = 1;
					}else {
						arrayCheck = 0;
					}
				}else if(function[j].equals("D")) {
					if(testArray.size() == 0) {
						resultCheck = 1;
						break;
					}else {
						if(arrayCheck == 0) {
							testArray.poll();
						}else {
							testArray.pollLast();
						}
					}
				}
			}
			
			int arrayLength = testArray.size();
			if(resultCheck == 0) {
				if(arrayCheck == 0) {
					bw.write("[");
					for(int j = 0 ; j < arrayLength ; j++) {
						if(j == arrayLength-1) {
							bw.write(testArray.poll() + "");
						}else {
							bw.write(testArray.poll() + ",");
						}
					}
					bw.write("]\n");
				}else {
					bw.write("[");
					for(int j = 0 ; j < arrayLength ; j++) {
						if(j == arrayLength-1) {
							bw.write(testArray.pollLast() + "");
						}else {
							bw.write(testArray.pollLast() + ",");
						}
					}
					bw.write("]\n");
				}
			}else {
				bw.write("error\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
