package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 너구리구구 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long result = 0;
	static long standard = 0;
	static HashMap<String, Long> distance = new HashMap<String, Long>();
	
	public static void main(String[] args) throws IOException{
	
		int roomNum = Integer.parseInt(br.readLine());
		
		ArrayList[] connect = new ArrayList[roomNum+1];
		boolean[] visitList = new boolean[roomNum+1];
		for(int i = 1 ; i < roomNum+1 ; i++) {
			connect[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < roomNum-1 ; i++) {
			String[] roomInform = (br.readLine()).split(" ");
			connect[Integer.parseInt(roomInform[0])].add(Integer.parseInt(roomInform[1]));
			connect[Integer.parseInt(roomInform[1])].add(Integer.parseInt(roomInform[0]));
			distance.put((roomInform[0] + " " + roomInform[1]), Long.parseLong(roomInform[2]));
			distance.put((roomInform[1] + " " + roomInform[0]), Long.parseLong(roomInform[2]));
		}
		
		dfs(1, connect, visitList, 0);
		
		bw.write(result + "");
		br.close();
        bw.flush();
        bw.close();
        
        
	}
	
	private static void dfs(int root, ArrayList[] connect, boolean[] visitList, long resultSum) {
		
		visitList[root] = true;
		
		for(Object i : connect[root]) {
			if(!visitList[(int)i]) {
				resultSum += (Long)distance.get(root + " " + (int)i);
				standard = resultSum;
				if(standard > result) {
					result = standard;
				}
				dfs((int)i, connect, visitList, resultSum);
				
				resultSum -= (Long)distance.get(root + " " + (int)i);
				
			}
		}
		
	}
}