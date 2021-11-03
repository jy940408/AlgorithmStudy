package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 트리 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int result = 0;
	static boolean deleteCheck = false;
	
	public static void main(String[] args) throws IOException{
		
		int nodeNum = Integer.parseInt(br.readLine());
		String[] firstLine = (br.readLine()).split(" ");
		
		boolean[] visitList = new boolean[nodeNum];
		ArrayList[] connectList = new ArrayList[nodeNum];
		for(int i = 0 ; i < nodeNum ; i++) {
			connectList[i] = new ArrayList<Integer>();
		}

		for(int i = 0 ; i < nodeNum ; i++) {
			int node = Integer.parseInt(firstLine[i]);
			if(node != -1) {
				connectList[node].add(i);
			}
		}
		
		int deleteNode = Integer.parseInt(br.readLine());

		dfs(deleteNode, connectList, visitList, 0, deleteNode);
		
		for(int i = 0 ; i < nodeNum ; i++) {
			
			if(!visitList[i]) {
				dfs(i, connectList, visitList, 1, deleteNode);
			}
		}
		
		
		br.close();
		for(int i = 0 ; i < nodeNum ; i++) {
			bw.write(connectList[i] + "\n");
		}
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}
	
	private static void dfs(int root, ArrayList[] connectList, boolean[] visitList, int check, int deleteNode) {
		
		visitList[root] = true;
		
		if(check == 1) {
			if(connectList[root].size() == 0) {
				result++;
			}else if(connectList[root].size() == 1 && (int)connectList[root].get(0) == deleteNode) {
				result++;
			}
		}
		
		for(Object i : connectList[root]) {
			if(!visitList[(int)i]) {
				if(check == 1) {
					dfs((int)i, connectList, visitList, 1, deleteNode);
				}else if(check == 0) {
					dfs((int)i, connectList, visitList, 0, deleteNode);
				}
			}
		}
		
	}

}
