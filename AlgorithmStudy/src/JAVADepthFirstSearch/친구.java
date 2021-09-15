package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 친구 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int connectNum = 0;
	static int visitNum = 0;
	
	public static void main(String[] args) throws IOException{
		
		int friendsNum = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] connect = new ArrayList[friendsNum+1];
		
		for(int i = 1 ; i < friendsNum + 1 ; i++) {
			connect[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < friendsNum ; i++) {
			String[] friendsYN = (br.readLine()).split("");
			for(int j = 0 ; j < friendsNum ; j++) {
				if(friendsYN[j].equals("Y")) {
					(connect[i+1]).add(j+1);
				}
			}
		}
		
		int result = 0;
		for(int i = 1 ; i < friendsNum+1 ; i++) {
			boolean[] visitList = new boolean[friendsNum+1];
			ArrayList<Integer> friendsList = new ArrayList<Integer>();
			ArrayList<Integer> resultList = new ArrayList<Integer>();
			dfs(i, connect, visitList, friendsList);
			
			for(int j = 0 ; j < friendsList.size() ; j++) {
				if(friendsList.indexOf(friendsList.get(j)) == j) {
					resultList.add(friendsList.get(j));
				}
			}
			
			System.out.println("resultList: " + resultList);
			
			connectNum = resultList.size();
			if(connectNum > result) {
				result = connectNum;
			}
		}
		
        bw.write(result + "");
        br.close();
        bw.flush();
        bw.close();
	}
	
	private static void dfs(int root, ArrayList<Integer>[] connect, boolean[] visitList, ArrayList<Integer> friendsList) {
		
		visitList[root] = true;
		
		for(int i : connect[root]) {
			if(!visitList[i]) {
				if(visitNum < 2) {
					visitNum++;
					friendsList.add(i);
					dfs(i, connect, visitList, friendsList);
					visitList[i] = false;
					visitNum--;
				}
			}
		}
	}

}