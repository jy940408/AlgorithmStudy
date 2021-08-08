package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 숫자카드 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int firstNum = Integer.parseInt(br.readLine());
		String[] firstLine_ = (br.readLine()).split(" ");
		int[] firstLine = new int[firstNum];
		for(int i = 0 ; i < firstNum ; i++) {
			firstLine[i] = Integer.parseInt(firstLine_[i]);
		}
		
		Arrays.sort(firstLine);
		
		int secondNum = Integer.parseInt(br.readLine());
		String[] secondLine_ = (br.readLine()).split(" ");
		for(int i = 0 ; i < secondNum ; i++) {
			int secondLine = Integer.parseInt(secondLine_[i]);
			bw.write(numCheck(firstLine, secondLine) + " ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int numCheck(int[] firstLine, int secondLine) {
		
		int first = 0;
		int mid = 0;
		int last = (firstLine.length-1);
		
		while(first <= last) {
			mid = (first+last)/2;

			if(secondLine == firstLine[mid]) {
				return 1;
			}else if(secondLine > firstLine[mid]) {
				first = mid + 1;
			}else if(secondLine < firstLine[mid]) {
				last = mid - 1;
			}
			
		}
		
		return 0;
	}

}
