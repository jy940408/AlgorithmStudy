package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 트리의부모찾기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int roundNum = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] connectList = new ArrayList[roundNum+1];
		boolean[] visitList = new boolean[roundNum+1];
		for(int i = 1 ; i < roundNum+1 ; i++) {
			connectList[i] = new ArrayList<Integer>();
		}

		for(int i = 1 ; i < roundNum ; i++) {
			String[] connect = (br.readLine()).split(" ");
			connectList[Integer.parseInt(connect[0])].add(Integer.parseInt(connect[1]));
			connectList[Integer.parseInt(connect[1])].add(Integer.parseInt(connect[0]));
		}
		
		int[] result = new int[roundNum+1];
		dfs(1, connectList, visitList, result);
		
		for(int i = 2 ; i < roundNum+1 ; i++) {
			bw.write(result[i] + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	public static void dfs(int root, ArrayList<Integer>[] connectList, boolean[] visitList, int[] result) {
		
		visitList[root] = true;
		
		for(int i : connectList[root]) {
			if(!visitList[i]) {
				dfs(i, connectList, visitList, result);
				result[i] = root;
			}
		}
		
	}

}
