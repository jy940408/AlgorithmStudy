package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 랭킹전대기열 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int playerNum = Integer.parseInt(firstLine[0]);
		int fullNum = Integer.parseInt(firstLine[1]);
		String[] playerLine = new String[playerNum];
		String[] resultPlayer = new String[fullNum];
		boolean[] countPlayer = new boolean[playerNum];
		
		for(int i = 0 ; i < playerNum ; i++) {
			playerLine[i] = br.readLine();
			countPlayer[i] = true;
		}
		
		int standard = 0;
		int arrayLength = 0;
		for(int i = 0 ; i < playerNum ; i++) {
			if(countPlayer[i]) {
				standard = Integer.parseInt(playerLine[i].split(" ")[0]);
				for(int j = i ; j < playerNum ; j++) {
					if(countPlayer[j]) {
						if(Integer.parseInt(playerLine[j].split(" ")[0])-10 <= standard 
								& Integer.parseInt(playerLine[j].split(" ")[0])+10 >= standard) {
							countPlayer[j] = false;
							arrayLength += 1;
							for(int k = 0 ; k < fullNum ; k++) {
								if(resultPlayer[k] == null) {
									resultPlayer[k] = playerLine[j];
									break;
								}
							}
						}
						if(resultPlayer[fullNum-1] != null) {
							break;
						}
					}
					
				}
				
				String[] sortResult = new String[arrayLength];
				String[] sortArray = new String[arrayLength];
				for(int j = 0 ; j < arrayLength ; j++) {
					if(resultPlayer[j] != null) {
						sortArray[j] = resultPlayer[j].split(" ")[1];
					}
				}
				
				Arrays.sort(sortArray);
				
				for(int j = 0 ; j < arrayLength ; j++) {
					for(int k = 0 ; k < fullNum ; k++) {
						if(resultPlayer[k] != null) {
							if(sortArray[j].equals(resultPlayer[k].split(" ")[1])) {
								sortResult[j] = resultPlayer[k];
							}
						}
					}
				}
				
				for(int j = 0 ; j < arrayLength ; j++) {
					if(j == 0 && arrayLength == fullNum) {
						bw.write("Started!\n");
						bw.write(sortResult[j] + "\n");
						resultPlayer[j] = null;
						sortArray[j] = null;
						sortResult[j] = null;
					}else if(j == 0 && arrayLength != fullNum) {
						bw.write("Waiting!\n");
						bw.write(sortResult[j] + "\n");
						resultPlayer[j] = null;
						sortArray[j] = null;
						sortResult[j] = null;
					}else {
						bw.write(sortResult[j] + "\n");
						resultPlayer[j] = null;
						sortArray[j] = null;
						sortResult[j] = null;
					}
				}
				
				arrayLength = 0;
				
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}