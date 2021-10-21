package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 색칠하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean result = true;
	
	public static void main(String[] args) throws IOException{
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < testCase ; i++) {
			String[] firstLine = (br.readLine()).split(" ");
			int circleNum = Integer.parseInt(firstLine[0]);
			int connectNum = Integer.parseInt(firstLine[1]);
			
			ArrayList[] connectList = new ArrayList[circleNum+1];
			boolean[] visitList = new boolean[circleNum+1];
			for(int j = 1 ; j < circleNum+1 ; j++) {
				connectList[j] = new ArrayList<Integer>();
			}
			
			for(int j = 0 ; j < connectNum ; j++){
				String[] secondLine = (br.readLine()).split(" ");
				int firstNum = Integer.parseInt(secondLine[0]);
				int secondNum = Integer.parseInt(secondLine[1]);
				connectList[firstNum].add(secondNum);
				connectList[secondNum].add(firstNum);
			}
			
			for(int j = 1 ; j < circleNum+1 ; j++) {
				visitList = new boolean[circleNum+1];
				dfs(j, j, connectList, visitList, 1);
				if(!result) {
					break;
				}
			}
			
			if(result) {
				bw.write("possible\n");
			}else {
				bw.write("impossible\n");
			}
			
			result = true;
			
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	private static void dfs(int root, int standardNum, ArrayList[] connectList, boolean[] visitList, int roundNum) throws IOException{
		
		visitList[root] = true;
		
		if(roundNum%2 == 1) {
			for(int i = 0 ; i < connectList[root].size() ; i++) {
				if((int)connectList[root].get(i) == standardNum) {
					result = false;
				}
			}
		}
		
		for(Object i : connectList[root]) {
			if(!visitList[(int)i]) {
				dfs((int)i, standardNum, connectList, visitList, roundNum+1);
			}
		}
		
	}

}
