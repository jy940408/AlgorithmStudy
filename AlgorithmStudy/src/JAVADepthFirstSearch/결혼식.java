package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 결혼식 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer> friendsList = new ArrayList<Integer>();
	static ArrayList<Integer> resultList = new ArrayList<Integer>();
	static int visit = 0;
	
	public static void main(String[] args) throws IOException{
		
		int friendsNum = Integer.parseInt(br.readLine());
		int connectNum = Integer.parseInt(br.readLine());
		boolean[] visitList = new boolean[friendsNum+1];
		ArrayList<Integer>[] connectList = new ArrayList[friendsNum+1];

		for(int i = 1 ; i < friendsNum+1 ; i++) {
			connectList[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < connectNum ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			connectList[Integer.parseInt(secondLine[0])].add(Integer.parseInt(secondLine[1]));
			connectList[Integer.parseInt(secondLine[1])].add(Integer.parseInt(secondLine[0]));
		}
		
		dfs(1, connectList, visitList);
		
		for(int j = 0 ; j < friendsList.size() ; j++) {
			if(friendsList.indexOf(friendsList.get(j)) == j) {
				resultList.add(friendsList.get(j));
			}
		}
		
		System.out.println(Arrays.toString(visitList));
		System.out.println(Arrays.toString(connectList));
		System.out.println(friendsList);
		System.out.println(resultList.size());
	}
	
	private static void dfs(int root, ArrayList<Integer>[] connectList, boolean[] visitList) {
		
		visitList[root] = true;
		
		for(int i : connectList[root]) {
			if(!visitList[i]) {
				if(visit < 2){	
					visit++;
					friendsList.add(i);
					dfs(i, connectList, visitList);
					visitList[i] = false;
					visit--;
				}
			}
		}
		
	}

}
