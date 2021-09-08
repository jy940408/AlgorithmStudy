package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class 크로스워드 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int height = Integer.parseInt(firstLine[0]);
		int width = Integer.parseInt(firstLine[1]);
		String[][] board = new String[height][width];
		
		ArrayList<String> resultList = new ArrayList<String>();
		for(int i = 0 ; i < height ; i++) {
			String secondLine = br.readLine();
			
			String[] secondCompare = secondLine.split("#");
			for(int j = 0 ; j < secondCompare.length ; j++) {
				if(secondCompare[j].length() > 1) {
					resultList.add(secondCompare[j]);
				}
			}
			String[] secondSplit = secondLine.split("");
			for(int j = 0 ; j < width ; j++) {
				board[i][j] = secondSplit[j];
			}
		}
		
		String heightSum = "";
		for(int i = 0 ; i < width ; i++) {
			for(int j = 0 ; j < height ; j++) {
				heightSum += board[j][i];
			}
			String[] secondCompare = heightSum.split("#");
			for(int j = 0 ; j < secondCompare.length ; j++) {
				if(secondCompare[j].length() > 1) {
					resultList.add(secondCompare[j]);
				}
			}
			heightSum = "";
		}
		
		Collections.sort(resultList);
		
		br.close();
		bw.write(resultList.get(0) + "");
		bw.flush();
		bw.close();
		
	}

}
