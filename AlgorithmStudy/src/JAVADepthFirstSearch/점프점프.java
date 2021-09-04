package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 점프점프 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int result = 0;
	
	public static void main(String[] args) throws IOException{
		
		int stoneNum = Integer.parseInt(br.readLine());
		String[] secondLine = (br.readLine()).split(" ");
		int startStone = Integer.parseInt(br.readLine());
		
		boolean[] visitList = new boolean[stoneNum+1];
		ArrayList[] possibleList = new ArrayList[stoneNum+1];
		for(int i = 1 ; i < stoneNum+1 ; i++) {
			possibleList[i] = new ArrayList<Integer>();
			int standardNum = Integer.parseInt(secondLine[i-1]);
			if(standardNum < i && standardNum + i <= stoneNum) {
				possibleList[i].add(i-standardNum);
				possibleList[i].add(standardNum+i);
			}else if(standardNum < i && standardNum + i > stoneNum) {
				possibleList[i].add(i-standardNum);
			}else if(standardNum >= i && standardNum + i <= stoneNum) {
				possibleList[i].add(standardNum+i);
			}
		}
		
		bw.write(dfs(startStone, visitList, possibleList) + "");
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	private static int dfs(int root, boolean[] visitList, ArrayList[] possibleList) {
		
		visitList[root] = true;
		result += 1;
		
		for(Object i : possibleList[root]) {
			if(i != null && i != "") {
				if(visitList[(int)i] == false) {
					dfs((int)i, visitList, possibleList);
				}
			}
		}
		
		return result;
	}

}
