package JAVASorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class orderList{
	String testWord;
	int wordRound;
	orderList(String testWord, int wordRound){
		this.testWord = testWord;
		this.wordRound = wordRound;
	}
}

class wordOrder implements Comparator<orderList> {

	int result = 0;
	
	@Override
	public int compare(orderList o1, orderList o2) {
		
		if(o1.wordRound < o2.wordRound) {
			result = 1;
		}else if(o1.wordRound > o2.wordRound) {
			result = -1;
		}else {
			if(o1.testWord.length() < o2.testWord.length()) {
				result = 1;
			}else if(o1.testWord.length() > o2.testWord.length()) {
				result = -1;
			}else {
				result = 0;
			}
		}
		
		return result;
	}
	
}

public class 영단어암기는괴로워 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int wordNum = Integer.parseInt(firstLine[0]);
		int wordLength = Integer.parseInt(firstLine[1]);
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		
		for(int i = 0 ; i < wordNum ; i++) {
			String testString = br.readLine();
			if(testString.length() >= wordLength) {
				wordMap.merge(testString, 1, Integer::sum);
			}
		}
		
		Object[] mapKey = wordMap.keySet().toArray();
		Arrays.sort(mapKey);
		
		System.out.println("mapKey: " + Arrays.toString(mapKey));
		
		orderList[] resultList = new orderList[wordMap.size()];
		for(int i = 0 ; i < wordMap.size() ; i++) {
			resultList[i] = new orderList("", 0);
		}
		
		int wordIdx = 0;
		for(Object key : mapKey) {
			resultList[wordIdx].testWord = (String)key;
			resultList[wordIdx].wordRound = (int) wordMap.get((String)key);
			System.out.println("resultList[" + wordIdx + "].testWord: " + resultList[wordIdx].testWord);
			System.out.println("resultList[" + wordIdx + "].wordRound: " + resultList[wordIdx].wordRound);
			wordIdx += 1;
		}
		
		Arrays.sort(resultList, new wordOrder());
		
		for(int i = 0 ; i < resultList.length ; i++) {
			bw.write(resultList[i].testWord + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}