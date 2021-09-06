package JAVATwoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 두수의합 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int num = Integer.parseInt(br.readLine());
		
		String[] numList_ = (br.readLine()).split(" ");
		int[] numList = new int[numList_.length];
		for(int i = 0 ; i < numList.length ; i++) {
			numList[i] = Integer.parseInt(numList_[i]);
		}
		Arrays.sort(numList);
		int x = Integer.parseInt(br.readLine());
		
		int result = 0;
		int start = 0;
		int end = num-1;
		while(start < end) {
			if(numList[start] + numList[end] == x) {
				result += 1;
			}
			if(numList[start] + numList[end] <= x) {
				start += 1;
			}else {
				end -= 1;
			}
		}
		
		bw.write(result + "");
		br.close();
		bw.flush();
		br.close();
		
	}

}
