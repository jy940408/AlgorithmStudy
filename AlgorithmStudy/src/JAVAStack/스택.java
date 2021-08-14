package JAVAStack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 스택 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int firstNum = Integer.parseInt(br.readLine());
		Stack<Integer> orderLine = new Stack<Integer>();
		String[] orderSplit = new String[2];
		for(int i = 0 ; i < firstNum ; i++) {
			
			orderSplit = br.readLine().split(" ");
			
			if(orderSplit[0].equals("push")) {
				orderLine.push(Integer.parseInt(orderSplit[1]));
			}else if(orderSplit[0].equals("pop")) {
				if(orderLine.size() != 0) {
					bw.write(orderLine.pop() + "\n");
				}else {
					bw.write("-1" + "\n");
				}
			}else if(orderSplit[0].equals("size")) {
				bw.write(orderLine.size() + "\n");
			}else if(orderSplit[0].equals("empty")) {
				if(orderLine.size() == 0) {
					bw.write("1" + "\n");
				}else {
					bw.write("0" + "\n");
				}
			}else if(orderSplit[0].equals("top")) {
				if(orderLine.size() == 0) {
					bw.write("-1" + "\n");
				}else {
					bw.write(orderLine.peek() + "\n");
				}
			}
			
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
