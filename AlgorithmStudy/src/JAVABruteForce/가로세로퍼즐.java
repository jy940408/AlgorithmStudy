package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 가로세로퍼즐 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] wordList = new String[6];
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		ArrayList<String> resultList = new ArrayList<String>();
		
		for(int i = 0 ; i < 6 ; i++) {
			wordList[i] = br.readLine();
			if(wordMap.containsKey(wordList[i])) {
				wordMap.put(wordList[i], wordMap.get(wordList[i])+1);
			}else {
				wordMap.put(wordList[i], 1);
			}
		}

		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0 ; j < 6 ; j++) {
				for(int k = 0 ; k < 6 ; k++) {
					if(j != i && k != i && k != j) {
						String firstTest = (wordList[i].split("")[0])+(wordList[j].split("")[0])+(wordList[k].split("")[0]);
						String secondTest = (wordList[i].split("")[1])+(wordList[j].split("")[1])+(wordList[k].split("")[1]);
						String thirdTest = (wordList[i].split("")[2])+(wordList[j].split("")[2])+(wordList[k].split("")[2]);
						wordMap.put(wordList[i], wordMap.get(wordList[i])-1);
						wordMap.put(wordList[j], wordMap.get(wordList[j])-1);
						wordMap.put(wordList[k], wordMap.get(wordList[k])-1);
						if(wordMap.containsKey(firstTest)) {
							wordMap.put(firstTest, wordMap.get(firstTest)-1);
						}
						if(wordMap.containsKey(secondTest)) {
							wordMap.put(secondTest, wordMap.get(secondTest)-1);
						}
						if(wordMap.containsKey(thirdTest)) {
							wordMap.put(thirdTest, wordMap.get(thirdTest)-1);
						}
						
						if(wordMap.containsKey(firstTest) && wordMap.containsKey(secondTest) && wordMap.containsKey(thirdTest)) {
							if(wordMap.get(wordList[i]) == 0 && wordMap.get(wordList[j]) == 0 && wordMap.get(wordList[k]) == 0 
								&& wordMap.get(firstTest) == 0 && wordMap.get(secondTest) == 0 && wordMap.get(thirdTest) == 0) {
								String result = firstTest + secondTest + thirdTest + wordList[i] + wordList[j] + wordList[k];
								resultList.add(result);
							}
						}
						
						wordMap.put(wordList[i], wordMap.get(wordList[i])+1);
						wordMap.put(wordList[j], wordMap.get(wordList[j])+1);
						wordMap.put(wordList[k], wordMap.get(wordList[k])+1);
						if(wordMap.containsKey(firstTest)) {
							wordMap.put(firstTest, wordMap.get(firstTest)+1);
						}
						if(wordMap.containsKey(secondTest)) {
							wordMap.put(secondTest, wordMap.get(secondTest)+1);
						}
						if(wordMap.containsKey(thirdTest)) {
							wordMap.put(thirdTest, wordMap.get(thirdTest)+1);
						}
					}
				}
			}
		}
		
		if(resultList.size() != 0) {
			Collections.sort(resultList);
			bw.write((resultList.get(0)).substring(0, 3) + "\n" + (resultList.get(0)).substring(3, 6) + "\n" + (resultList.get(0)).substring(6, 9));
		}else {
			bw.write(0 + "");
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
