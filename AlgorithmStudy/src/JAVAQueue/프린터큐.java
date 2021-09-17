package JAVAQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터큐 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{

		int round = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < round ; i++) {
			
			String[] secondLine = (br.readLine()).split(" ");
			int numLength = Integer.parseInt(secondLine[0]);
			int testNum = Integer.parseInt(secondLine[1]);
			String[] thirdLine = (br.readLine()).split(" ");
			Queue<Integer> numQueue = new LinkedList<Integer>();
			Queue<Integer> orderQueue = new LinkedList<Integer>();
			ArrayList<Integer> numList = new ArrayList<Integer>();
			ArrayList<Integer> resultList = new ArrayList<Integer>();
			
			for(int j = 0 ; j < numLength ; j++) {
				numQueue.add(Integer.parseInt(thirdLine[j]));
				orderQueue.add(j);
				numList.add(Integer.parseInt(thirdLine[j]));
			}
			
			Collections.sort(numList);
			
			while(resultList.size() != numLength) {
				int num = numQueue.poll();
				if(num >= numList.get(numList.size()-1)) {
					numList.remove(numList.size()-1);
					resultList.add(orderQueue.poll());
				}else {
					numQueue.add(num);
					orderQueue.add(orderQueue.poll());
				}
			}
			
			for(int j = 0 ; j < numLength ; j++) {
				if(resultList.get(j) == testNum) {
					bw.write((j+1) + "\n");
				}
			}
			
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
