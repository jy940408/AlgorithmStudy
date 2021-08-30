package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 바이러스 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int computerNum = Integer.parseInt(br.readLine());
		int edgeNum = Integer.parseInt(br.readLine());
		ArrayList[] edgeList = new ArrayList[computerNum+1]; 
		boolean[] visitList = new boolean[computerNum+1];
		
		for(int i = 1 ; i < computerNum+1 ; i++) {
			edgeList[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < edgeNum ; i++) {
			String[] edgeLine = (br.readLine()).split(" ");
			(edgeList[Integer.parseInt(edgeLine[0])]).add(Integer.parseInt(edgeLine[1]));
			(edgeList[Integer.parseInt(edgeLine[1])]).add(Integer.parseInt(edgeLine[0]));
		}
		
		dfs(1, edgeList, visitList);
		
		int result = 0;
		for(int i = 1 ; i < computerNum+1 ; i++) {
			if(visitList[i]) {
				result += 1;
			}
		}
		
		bw.write((result-1) + "");
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	private static void dfs(int root, ArrayList[] edgeList, boolean[] visitList) {
		
		visitList[root] = true;
		
		for(Object i : edgeList[root]) {
			if(visitList[(int)i] == false) {
				dfs((int)i, edgeList, visitList);
			}
		}
		
	}

}
