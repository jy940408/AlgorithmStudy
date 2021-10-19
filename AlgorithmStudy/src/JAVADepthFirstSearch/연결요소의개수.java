package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 연결요소의개수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int result = 0;
	
	public static void main(String[] args) throws IOException {

		String[] firstLine = (br.readLine()).split(" ");
		int pointNum = Integer.parseInt(firstLine[0]);
		int connectNum = Integer.parseInt(firstLine[1]);
		ArrayList[] connectList = new ArrayList[pointNum+1];
		boolean[] visitList = new boolean[pointNum+1];
		for(int i = 0 ; i < pointNum+1 ; i++) {
			connectList[i] = new ArrayList<Integer>();
			visitList[i] = true;
		}
		
		for(int i = 1 ; i < connectNum+1 ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			int firstNum = Integer.parseInt(secondLine[0]);
			int secondNum = Integer.parseInt(secondLine[1]);
			connectList[firstNum].add(secondNum);
			connectList[secondNum].add(firstNum);
		}
		
		
		for(int i = 1 ; i < pointNum+1 ; i++) {
			if(visitList[i]) {
				dfs(i, connectList, visitList);
				result++;
			}
		}
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}
	
	private static void dfs(int root, ArrayList[] connectList, boolean[] visitList) {
		
		visitList[root] = false;
		
		for(Object i : connectList[root]) {
			if(visitList[(int)i]) {
				dfs((int)i, connectList, visitList);
			}
		}
		
	}

}
