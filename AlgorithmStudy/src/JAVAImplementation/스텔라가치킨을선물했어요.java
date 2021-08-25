package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 스텔라가치킨을선물했어요 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int playerNum = Integer.parseInt(br.readLine());
		String[] player = new String[playerNum];
		for(int i = 0 ; i < playerNum ; i++) {
			player[i] = br.readLine();
		}

		Arrays.sort(player);
		String testString = "";
		for(int i = 0 ; i < playerNum ; i++) {
			for(int j = i+1 ; j < playerNum ; j++) {
				if(Integer.parseInt(player[i].split(" ")[0]) == Integer.parseInt(player[j].split(" ")[0])) {
					if(Integer.parseInt(player[i].split(" ")[1]) > Integer.parseInt(player[j].split(" ")[1])) {
						testString = player[i];
						player[i] = player[i+1];
						player[i+1] = testString;
						i += 1;
					}
				}
			}
		}
		
		int result = 0;
		for(int i = 0 ; i < (player.length-5); i++) {
			if(Integer.parseInt(player[i].split(" ")[0]) == Integer.parseInt(player[player.length-5].split(" ")[0])) {
				result += 1;
			}
		}
		
		bw.write(result + "");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
