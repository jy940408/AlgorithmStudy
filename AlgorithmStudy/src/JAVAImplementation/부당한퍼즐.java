package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 부당한퍼즐 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{

		int puzzleNum = Integer.parseInt(br.readLine());
		String[] puzzleLine_ = (br.readLine()).split(" ");
		String[] compareLine_ = (br.readLine()).split(" ");
		int[] puzzleLine = new int[puzzleNum];
		int[] compareLine = new int[puzzleNum];
		int[] reverseLine = new int[puzzleNum];
		
		for(int i = 0 ; i < puzzleNum ; i++) {
			puzzleLine[i] = Integer.parseInt(puzzleLine_[i]);
			compareLine[i] = Integer.parseInt(compareLine_[i]);
		}
		
		int startNum = 0;
		int endNum = 0;
		for(int i = 0 ; i < puzzleNum ; i++) {
			reverseLine[(puzzleNum-1)-i] = puzzleLine[i];
			if(compareLine[i] == puzzleLine[0]) {
				startNum = i;
			}else if(compareLine[i] == puzzleLine[puzzleNum-1]) {
				endNum = i;
			}
		}
		
		String result = "";
		String subResult = "";
		int j = 0;
		for(int i = 0 ; i < puzzleNum ; i++) {
			if((startNum + i) < puzzleNum) {
				if(compareLine[startNum + i] != puzzleLine[i]) {
					result = "bad puzzle";
				}
			}else {
				if(compareLine[j] != puzzleLine[i]) {
					result = "bad puzzle";
				}
				j++;
			}
		}
		
		j = 0;
		for(int i = 0 ; i < puzzleNum ; i++) {
			if((endNum + i) < puzzleNum) {
				if(compareLine[endNum + i] != reverseLine[i]) {
					subResult = "bad puzzle";
				}
			}else {
				if(compareLine[j] != reverseLine[i]) {
					subResult = "bad puzzle";
				}
				j++;
			}
		}
		
		if(result.equals("bad puzzle") && subResult.equals("bad puzzle")) {
			bw.write("bad puzzle");
		}else {
			bw.write("good puzzle");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}