package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 촌수계산 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int result = -1;
	static int firstCheck;
	static int secondCheck;
	
	public static void main(String[] args) throws IOException {

		int peopleNum = Integer.parseInt(br.readLine());
		String[] testCase = (br.readLine()).split(" ");
		firstCheck = Integer.parseInt(testCase[0]);
		secondCheck = Integer.parseInt(testCase[1]);
		int connectNum = Integer.parseInt(br.readLine());
		
		ArrayList[] connectList = new ArrayList[peopleNum+1];
		boolean[] visitList = new boolean[peopleNum+1];
		for(int i = 0 ; i < peopleNum+1 ; i++) {
			connectList[i] = new ArrayList<Integer>();
			visitList[i] = true;
		}
		
		for(int i = 0 ; i < connectNum ; i++) {
			String[] testLine = (br.readLine()).split(" ");
			int firstPerson = Integer.parseInt(testLine[0]);
			int secondPerson = Integer.parseInt(testLine[1]);
			connectList[firstPerson].add(secondPerson);
			connectList[secondPerson].add(firstPerson);
		}
	
		dfs(firstCheck, connectList, visitList, 0);
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();

	}
	
	private static void dfs(int root, ArrayList[] connectList, boolean[] visitList, int visitNum) {
		
		visitList[root] = false;
		visitNum++;
		
		for(Object i : connectList[root]) {
			if(visitList[(int)i]) {
				if((int)i == secondCheck) {
					result = visitNum;
				}else {
					dfs((int)i, connectList, visitList, visitNum);
				}
			}
		}
		
	}

}
