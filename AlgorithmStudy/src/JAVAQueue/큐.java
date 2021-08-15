package JAVAQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 큐 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{

		int firstNum = Integer.parseInt(br.readLine());
		Queue<Integer> queueList = new LinkedList<Integer>();
		int lastNum = 0;
		for(int i = 0 ; i < firstNum ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			if(secondLine[0].equals("push")){
				lastNum = Integer.parseInt(secondLine[1]);
				queueList.add(lastNum);
			}else if(secondLine[0].equals("pop")) {
				if(queueList.size() != 0) {
					bw.write(queueList.poll() + "\n");	
				}else {
					bw.write(-1 + "\n");
				}
			}else if(secondLine[0].equals("size")) {
				bw.write(queueList.size() + "\n");
			}else if(secondLine[0].equals("empty")) {
				if(queueList.size() == 0) {
					bw.write(1 + "\n");
				}else {
					bw.write(0 + "\n");
				}
			}else if(secondLine[0].equals("front")) {
				if(queueList.size() != 0) {
					bw.write(queueList.peek() + "\n");
				}else {
					bw.write(-1 + "\n");
				}
			}else if(secondLine[0].equals("back")) {
				if(queueList.size() != 0) {
					bw.write(lastNum + "\n");
				}else {
					bw.write(-1 + "\n");
				}
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
